package com.razor.calculator.controller;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.razor.calculator.model.PlayerModel;
import com.razor.calculator.repository.GullyRepository;

@Controller
@Transactional
@EnableTransactionManagement
@RequestMapping(value="/gullyCricket")
public class ScoreController {
	
	@Autowired
	GullyRepository gr;
	
	
	@RequestMapping(value="/getStats")
	public String getStats(Model model) {
		
		model.addAttribute("PlayerStat", gr.findAll());
		return "showScore";
	}
	@RequestMapping(value="/addPlayer")
	public String callPut(Model model)
	{
		model.addAttribute("PlayerStat", new PlayerModel());
		
		return "putData";
	}
	
	@Autowired
	private EntityManagerFactory emf;
	
	@RequestMapping(value="putData")
	public String putValue(Model model, PlayerModel pm)
	{
		EntityManager em = emf.createEntityManager();
		boolean c=false;
		boolean f=false;
			
		int runs = Integer.parseInt(pm.getRunsScored());
		if(runs>=100)
			c=true;
		else if(runs>=50)
			f=true;
		
		Optional<PlayerModel> op = gr.findById(pm.getPlayerId());
		if(op.isPresent()) {
			PlayerModel pm1 = em.find(PlayerModel.class, op.get().getPlayerId());
			
			em.getTransaction().begin();
			pm1.setPlayedMatches(Integer.toString(Integer.parseInt(pm1.getPlayedMatches())+1));
			pm1.setPlayedInnings(Integer.toString(Integer.parseInt(pm1.getPlayedInnings())+1));
			pm1.setRunsScored(Integer.toString(Integer.parseInt(pm1.getRunsScored())+Integer.parseInt(pm.getRunsScored())));
			pm1.setAverageRuns(Integer.toString(Math.round(Integer.parseInt(pm1.getRunsScored())/Integer.parseInt(pm1.getPlayedInnings()))));
			if(c)
				pm1.setCentutries(Integer.toString(Integer.parseInt(pm1.getCentutries())+1));
			if(f)
				pm1.setFifties(Integer.toString(Integer.parseInt(pm1.getFifties())+1));
			if(Integer.parseInt(pm1.getHighestRuns())< Integer.parseInt(pm.getRunsScored()))
				pm1.setHighestRuns(pm.getRunsScored());
			em.getTransaction().commit();
		}
		else {
			pm.setAverageRuns(pm.getRunsScored());
			pm.setPlayedMatches("1");
			pm.setPlayedInnings("1");
			pm.setHighestRuns(pm.getRunsScored());
			if(c)
				pm.setCentutries("1");
			else
				pm.setCentutries("0");
			if(f)
				pm.setFifties("1");
			else
				pm.setFifties("0");
			
			gr.save(pm);
		}
		
		model.addAttribute("PlayerStat", gr.findAll());
		return "showScore";
	}

}

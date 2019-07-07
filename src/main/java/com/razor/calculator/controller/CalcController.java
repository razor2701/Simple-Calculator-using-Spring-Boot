package com.razor.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.razor.calculator.model.CalLogs;
import com.razor.calculator.repository.CalcRepository;

@Controller
public class CalcController {
	
	@Autowired
	CalcRepository cr;
	
	@RequestMapping(value="/")
	public String getExpression(Model model)
	{
		model.addAttribute("CalLogs", new CalLogs());
		return "getExp";
	}
	
	@RequestMapping(value="/sendData")
	public String Compute(Model model, CalLogs cl)
	{
		String eq = cl.getLogEquation();
		System.out.println(eq);
		int index=0;
		for(int  i=0; i<eq.length(); i++)
		{
			if(eq!=null)
			{
				if(eq.charAt(i)=='*' || eq.charAt(i)=='/' || eq.charAt(i)=='+' || eq.charAt(i)=='-')
				{
					index = i;
				}
			}
		}
		System.out.println(index);
		if(index!=0)
		{
			String par1 = eq.substring(0,index);
			String par2 = eq.substring(index+1, eq.length());
			System.out.println(par1);
			System.out.println(par2);
			int para1 = Integer.parseInt(par1);
			int para2 = Integer.parseInt(par2);
			System.out.println(" "+para1+" "+para2);
			int result = getResult(eq, para1, para2, index);
			cl.setLogResult(Integer.toString(result));
			cr.save(cl);
			
		}
		model.addAttribute("CalLogs", cl);
		
		return "getExp";
	}

	private int getResult(String eq, int para1, int para2, int index) {
		
		int result;
		char operator = eq.charAt(index);
		
		switch(operator) {
		case '*': result=para1*para2;
				  return result;
				  
		case '/': result=(int)para1/para2;
		  		  return result;
		  		  
		case '+': result=para1+para2;
				  return result;
				  
		case '-': result=para1-para2;
		          return result;
		}
			
			
		return 0;
	}
	
	
	

}

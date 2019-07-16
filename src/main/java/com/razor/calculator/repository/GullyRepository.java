package com.razor.calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.razor.calculator.model.PlayerModel;

 public interface GullyRepository extends JpaRepository<PlayerModel, Integer>{

}

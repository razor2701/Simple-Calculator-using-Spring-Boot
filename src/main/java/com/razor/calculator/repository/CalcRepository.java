package com.razor.calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.razor.calculator.model.CalLogs;

public interface CalcRepository extends JpaRepository<CalLogs, Integer> {

}

package com.razor.calculator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CalLogs {
	
	@Id
	@GeneratedValue
	@Column(name="logID")
	int logID;
	
	@Column(name="logEquation")
	String logEquation;
	
	@Column(name="logResult")
	String logResult;

	public CalLogs() {
		super();
	}

	public String getLogResult() {
		return logResult;
	}

	public void setLogResult(String logResult) {
		this.logResult = logResult;
	}

	public int getLogID() {
		return logID;
	}

	public void setLogID(int logID) {
		this.logID = logID;
	}

	public String getLogEquation() {
		return logEquation;
	}

	public void setLogEquation(String logEquation) {
		this.logEquation = logEquation;
	}
	
	

}

package com.razor.calculator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PlayerModel {

	@Id
	@GeneratedValue
	@Column(name="playerID")
	Integer playerId;
	
	@Column(name="playerName")
	String playerName;
	
	@Column(name="playedMatches")
	String playedMatches;
	
	@Column(name="playedInnings")
	String playedInnings;
	
	@Column(name="runsScored")
	String runsScored;
	
	@Column(name="averageRuns")
	String averageRuns;
	
	@Column(name="highestRuns")
	String highestRuns;
	
	@Column(name="centuries")
	String centutries;
	
	@Column(name="fifties")
	String fifties;

	public PlayerModel(Integer playerId, String playerName, String playedMatches, String playedInnings,
			String runsScored, String averageRuns, String highestRuns, String centutries, String fifties) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.playedMatches = playedMatches;
		this.playedInnings = playedInnings;
		this.runsScored = runsScored;
		this.averageRuns = averageRuns;
		this.highestRuns = highestRuns;
		this.centutries = centutries;
		this.fifties = fifties;
	}

	public PlayerModel() {
		super();
	}

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayedMatches() {
		return playedMatches;
	}

	public void setPlayedMatches(String playedMatches) {
		this.playedMatches = playedMatches;
	}

	public String getPlayedInnings() {
		return playedInnings;
	}

	public void setPlayedInnings(String playedInnings) {
		this.playedInnings = playedInnings;
	}

	public String getRunsScored() {
		return runsScored;
	}

	public void setRunsScored(String runsScored) {
		this.runsScored = runsScored;
	}

	public String getAverageRuns() {
		return averageRuns;
	}

	public void setAverageRuns(String averageRuns) {
		this.averageRuns = averageRuns;
	}

	public String getHighestRuns() {
		return highestRuns;
	}

	public void setHighestRuns(String highestRuns) {
		this.highestRuns = highestRuns;
	}

	public String getCentutries() {
		return centutries;
	}

	public void setCentutries(String centutries) {
		this.centutries = centutries;
	}

	public String getFifties() {
		return fifties;
	}

	public void setFifties(String fifties) {
		this.fifties = fifties;
	}
	
	
}

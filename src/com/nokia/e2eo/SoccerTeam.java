package com.nokia.e2eo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;

public class SoccerTeam {
	
	private String name;
	private List<SoccerPlayer> players;
	private SoccerPlayer goalkeeper;
	private List<SoccerPlayer> defenders;
	private List<SoccerPlayer> midfielders;
	private List<SoccerPlayer> strikers;
	private List<SoccerPlayer> substitutes;
	
	public SoccerTeam(String name) {
		this.name = name;
		this.players = new ArrayList<SoccerPlayer>();
		this.defenders = new ArrayList<SoccerPlayer>();
		this.midfielders = new ArrayList<SoccerPlayer>();
		this.strikers = new ArrayList<SoccerPlayer>();
	}
	
	private void addPlayer(SoccerPlayer player) {
		players.add(player);
		player.setTeam(this);
	}
	
	public void addGoalkeeper(SoccerPlayer player) {
		this.addPlayer(player);
		goalkeeper = player;
	}
	
	public void addDefender(SoccerPlayer player) {
		this.addPlayer(player);
		defenders.add(player);
	}
	
	public void addMidfielder(SoccerPlayer player) {
		this.addPlayer(player);
		midfielders.add(player);
	}
	
	public void addStriker(SoccerPlayer player) {
		this.addPlayer(player);
		strikers.add(player);
	}
	
	public void addObserver(Observer o) {
		for (SoccerPlayer player : players) {
			player.addObserver(o);
		}
	}

	public List<SoccerPlayer> getPlayers() {
		return players;
	}

	public void setPlayers(List<SoccerPlayer> players) {
		this.players = players;
	}

	public SoccerPlayer getGoalkeeper() {
		return goalkeeper;
	}

	public void setGoalkeeper(SoccerPlayer goalkeeper) {
		this.goalkeeper = goalkeeper;
	}

	public List<SoccerPlayer> getDefenders() {
		return defenders;
	}

	public void setDefenders(List<SoccerPlayer> defenders) {
		this.defenders = defenders;
	}

	public List<SoccerPlayer> getMidfielders() {
		return midfielders;
	}

	public void setMidfielders(List<SoccerPlayer> midfielders) {
		this.midfielders = midfielders;
	}

	public List<SoccerPlayer> getStrikers() {
		return strikers;
	}

	public void setStrikers(List<SoccerPlayer> strikers) {
		this.strikers = strikers;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SoccerPlayer> getSubstitutes() {
		return substitutes;
	}

	public void setSubstitutes(List<SoccerPlayer> substitutes) {
		this.substitutes = substitutes;
	}

	@Override
	public String toString() {
		StringBuilder sTeam = new StringBuilder();
		sTeam.append("Team: " + this.name + "\n");
		for (SoccerPlayer soccerPlayer : this.players) {
			sTeam.append(soccerPlayer.toString() + "\n");
		}
		return sTeam.toString();
	}
	
	
}

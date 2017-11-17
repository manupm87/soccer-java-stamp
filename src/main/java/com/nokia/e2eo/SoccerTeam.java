package com.nokia.e2eo;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class SoccerTeam {

	private String name;
	private List<SoccerPlayer> players;
	private Goalkeeper goalkeeper;
	private List<Defender> defenders;
	private List<Midfielder> midfielders;
	private List<Striker> strikers;
	private List<SoccerPlayer> substitutes;
	
	private SoccerTeam oponentTeam;

	public SoccerTeam(String name) {
		this.name = name;
		this.players = new ArrayList<SoccerPlayer>();
		this.defenders = new ArrayList<>();
		this.midfielders = new ArrayList<>();
		this.strikers = new ArrayList<>();
	}

	private void addPlayer(SoccerPlayer player) {
		players.add(player);
		player.setOwnTeam(this);
	}

	public void addGoalkeeper(SoccerGoalkeeper player) {
		this.addPlayer(player);
		goalkeeper = player;
	}

	public void addDefender(SoccerDefender player) {
		this.addPlayer(player);
		defenders.add(player);
	}

	public void addMidfielder(SoccerMidfielder player) {
		this.addPlayer(player);
		midfielders.add(player);
	}

	public void addStriker(SoccerPlayer player) {
		this.addPlayer(player);
		strikers.add((SoccerStriker) player);
	}

	public void addObserver(Observer o) {
		for (SoccerPlayer player : players) {
			player.addObserver(o);
		}
	}

	public void play() {
		for (SoccerPlayer soccerPlayer : players) {
			soccerPlayer.play();
		}
	}

	public void kickOff() {
		Striker striker = this.strikers.get(0);
		striker.kickOff();

	}

	public List<SoccerPlayer> getPlayers() {
		return players;
	}

	public void setPlayers(List<SoccerPlayer> players) {
		this.players = players;
	}

	public Goalkeeper getGoalkeeper() {
		return goalkeeper;
	}

	public void setGoalkeeper(SoccerGoalkeeper goalkeeper) {
		this.goalkeeper = goalkeeper;
	}

	public List<Defender> getDefenders() {
		return defenders;
	}

	public void setDefenders(List<Defender> defenders) {
		this.defenders = defenders;
	}

	public List<Midfielder> getMidfielders() {
		return midfielders;
	}

	public void setMidfielders(List<Midfielder> midfielders) {
		this.midfielders = midfielders;
	}

	public List<Striker> getStrikers() {
		return strikers;
	}

	public void setStrikers(List<Striker> strikers) {
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
	
	public SoccerTeam getOponentTeam() {
		return oponentTeam;
	}

	public void setOponentTeam(SoccerTeam oponentTeam) {
		this.oponentTeam = oponentTeam;
		for (SoccerPlayer soccerPlayer : players) {
			soccerPlayer.setOponentTeam(this.oponentTeam);
		}
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

package com.nokia.e2eo;

import java.util.Observable;
import java.util.Observer;

public class SoccerMatch implements Observer {

	private Integer remainingPlays = 20;
	private SoccerTeam teamA;
	private SoccerTeam teamB;
	private Integer scoreTeamA = 0;
	private Integer scoreTeamB = 0;

	/**
	 * Observer - Observable pattern to check for goals
	 */
	@Override
	public void update(Observable o, Object arg) {
		SoccerPlayer scorer = (SoccerPlayer) o;

		System.out.println(scorer.getName() + " scored an amazing goal!!!");
		if (teamA == scorer.getTeam()) {
			scoreTeamA++;
			System.out.println(this.logResult());
			teamB.kickOff();
		} else {
			scoreTeamB++;
			System.out.println(this.logResult());
			teamA.kickOff();
		}

	}
	
	public void play() {
		this.remainingPlays--;
		if (this.remainingPlays >= 0) {
			teamA.play();
			teamB.play();
		}
	}

	public SoccerTeam getTeamA() {
		return teamA;
	}

	public void setTeamA(SoccerTeam teamA) {
		this.teamA = teamA;
	}

	public SoccerTeam getTeamB() {
		return teamB;
	}

	public void setTeamB(SoccerTeam teamB) {
		this.teamB = teamB;
	}

	public Integer getRemainingPlays() {
		return remainingPlays;
	}

	public void setRemainingPlays(Integer remainingPlays) {
		this.remainingPlays = remainingPlays;
	}

	public Integer getScoreTeamA() {
		return scoreTeamA;
	}

	public void setScoreTeamA(Integer scoreTeamA) {
		this.scoreTeamA = scoreTeamA;
	}

	public Integer getScoreTeamB() {
		return scoreTeamB;
	}

	public void setScoreTeamB(Integer scoreTeamB) {
		this.scoreTeamB = scoreTeamB;
	}

	@Override
	public String toString() {
		StringBuilder sMatch = new StringBuilder();
		sMatch.append(String.format("Match: %s - %d : %d - %s\r\n", this.teamA.getName(), this.scoreTeamA,
				this.scoreTeamB, this.teamB.getName()));
		sMatch.append(this.teamA.toString() + "\r\n");
		sMatch.append(this.teamB.toString() + "\r\n");
		return sMatch.toString();
	}
	
	public String logResult() {
		return String.format("Match: %s - %d : %d - %s \t(%d)\r\n", this.teamA.getName(), this.scoreTeamA,
				this.scoreTeamB, this.teamB.getName(), this.remainingPlays);
	}

	public static void main(String[] args) {
		SoccerMatch match = new SoccerMatch();

		SoccerTeam pheromaniacsFC = new SoccerTeam("Pheromaniacs F.C.");
		pheromaniacsFC.addGoalkeeper(new SoccerGoalkeeper("Zsombor", 10f, 10f, 10f, 100));
		pheromaniacsFC.addDefender(new SoccerDefender("Csabi", 10f, 10f, 10f, 100));
		pheromaniacsFC.addMidfielder(new SoccerMidfielder("Manu", 10f, 10f, 10f, 100));
		pheromaniacsFC.addStriker(new SoccerStriker("Attila", 10f, 10f, 10f, 100));
		pheromaniacsFC.addObserver(match);
		match.setTeamA(pheromaniacsFC);

		SoccerTeam pheromaniacsFCbis = new SoccerTeam("Hungaricum F.C.");
		pheromaniacsFCbis.addGoalkeeper(new SoccerGoalkeeper("Mark", 10f, 10f, 10f, 100));
		pheromaniacsFCbis.addDefender(new SoccerDefender("HPeti", 10f, 10f, 10f, 100));
		pheromaniacsFCbis.addMidfielder(new SoccerMidfielder("Csati", 10f, 10f, 10f, 100));
		pheromaniacsFCbis.addStriker(new SoccerStriker("Zsoltaldo", 10f, 10f, 10f, 100));
		pheromaniacsFCbis.addObserver(match);
		match.setTeamB(pheromaniacsFCbis);

		System.out.println(match);
		
		match.teamA.kickOff();
		while(match.getRemainingPlays() >= 0) {
			System.out.println(match.logResult());
			match.play();
		}

	}

}

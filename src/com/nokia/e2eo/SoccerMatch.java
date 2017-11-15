package com.nokia.e2eo;

import java.util.Observable;
import java.util.Observer;

public class SoccerMatch implements Observer {

	private Integer remainingPlays = 20;
	private SoccerTeam teamA;
	private SoccerTeam teamB;
	private Integer scoreTeamA = 0;
	private Integer scoreTeamB = 0;

	@Override
	public void update(Observable o, Object arg) {
		SoccerPlayer scorer = (SoccerPlayer) o;
		if (teamA == scorer.getTeam()) {
			scoreTeamA++;
		} else
			scoreTeamB++;

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
		return String.format("Match: %s - %d : %d - %s\r\n", this.teamA.getName(), this.scoreTeamA,
				this.scoreTeamB, this.teamB.getName());
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
		System.out.println(match.logResult());
		
		pheromaniacsFC.getStrikers().get(0).scoreGoal();
		System.out.println(match.logResult());

		match.getTeamB().getStrikers().get(0).scoreGoal();
		System.out.println(match.logResult());
	}

}

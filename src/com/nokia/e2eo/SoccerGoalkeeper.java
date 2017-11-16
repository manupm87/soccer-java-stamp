package com.nokia.e2eo;

import java.util.Random;

public class SoccerGoalkeeper extends SoccerPlayer implements Goalkeeper {
	
	private SoccerTeam team;
	

	public SoccerGoalkeeper(String name, Float attack, Float defense, Float dribbling, Integer max_stamina) {
		super(name, attack, defense, dribbling, max_stamina);
		this.setDefense(this.getDefense() * Goalkeeper.DEFENSE_MULTIPLIER);
		this.setAttack(this.getAttack() * Goalkeeper.ATTACK_MULTIPLIER);
	}
	
	public SoccerTeam getTeam() {
		return team;
	}

	public void setTeam(SoccerTeam team) {
		this.team = team;
	}

	@Override
	void play() {
		super.play();
		if (this.haveBall) {
			this.pass();
		}else {
			this.log("Staying put close to the goal...");
		}
		
	}
	
	@Override
	public String toString() {
		return String.format("[%s - %s]: \t %s", "G", this.name, super.toString());
	}

	@Override
	public void pass() {
		if (Math.random() < this.PASS_DEF_MID_RATIO) {
			this.passToDefender();
		} else {
			this.passToMidfielder();
		}
		
	}

	@Override
	public void passToDefender() {
		Random rand = new Random();
		SoccerPlayer mate = (SoccerPlayer) this.getTeam().getDefenders()
				.get(rand.nextInt(this.getTeam().getDefenders().size()));
		this.releaseBall();
		mate.receiveBall();
		this.log(String.format("Passing forward to Defender %s...", mate.getName()));
		
	}

	@Override
	public void passToMidfielder() {
		Random rand = new Random();
		SoccerPlayer mate = (SoccerPlayer) this.getTeam().getMidfielders()
				.get(rand.nextInt(this.getTeam().getMidfielders().size()));
		this.releaseBall();
		mate.receiveBall();
		this.log(String.format("Passing forward to Midfielder %s...", mate.getName()));
		
	}
}

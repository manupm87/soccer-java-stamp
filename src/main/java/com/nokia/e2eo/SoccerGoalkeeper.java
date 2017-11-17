package com.nokia.e2eo;

import java.util.Random;

public class SoccerGoalkeeper extends SoccerPlayer implements Goalkeeper {

	private Float ATTACK_MULTIPLIER = 0.1f;
	private Float DEFENSE_MULTIPLIER = 2.5f;
	private Float PASS_DEF_MID_RATIO = 0.7f;

	private SoccerGoalkeeper(String name, Float attack, Float defense, Float dribbling, Integer max_stamina) {
		super(name, attack, defense, dribbling, max_stamina);
		this.setDefense(this.getDefense() * this.DEFENSE_MULTIPLIER);
		this.setAttack(this.getAttack() * this.ATTACK_MULTIPLIER);
	}

	public static SoccerGoalkeeper defaultGoalkeeper(String name, Float attack, Float defense, Float dribbling,
			Integer max_stamina) {
		return new SoccerGoalkeeper(name, attack, defense, dribbling, max_stamina);
	}

	public static SoccerGoalkeeper ofensiveGoalkeeper(String name, Float attack, Float defense, Float dribbling,
			Integer max_stamina) {
		SoccerGoalkeeper goalkeeper = new SoccerGoalkeeper(name, attack, defense, dribbling, max_stamina);
		goalkeeper.PASS_DEF_MID_RATIO = 0.3f;
		return goalkeeper;
	}

	public SoccerTeam getTeam() {
		return ownTeam;
	}

	public void setTeam(SoccerTeam team) {
		this.ownTeam = team;
	}

	@Override
	void playImp() {
		if (this.haveBall) {
			this.pass();
		} else {
			// this.log("Staying put close to the goal...");
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

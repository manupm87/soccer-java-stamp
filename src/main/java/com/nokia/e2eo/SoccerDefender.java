package com.nokia.e2eo;

import java.util.Random;

public class SoccerDefender extends SoccerPlayer implements Defender {
	private Float ATTACK_MULTIPLIER = 0.5f;
	private Float DEFENSE_MULTIPLIER = 2f;
	private Float PASS_BACK_FORTH_RATIO = 0.3f;

	private SoccerDefender(String name, Float attack, Float defense, Float dribbling, Integer max_stamina) {
		super(name, attack, defense, dribbling, max_stamina);
		this.setDefense(this.getDefense() * this.DEFENSE_MULTIPLIER);
		this.setAttack(this.getAttack() * this.ATTACK_MULTIPLIER);
	}

	public static SoccerDefender defaultDefender(String name, Float attack, Float defense, Float dribbling,
			Integer max_stamina) {
		return new SoccerDefender(name, attack, defense, dribbling, max_stamina);
	}

	public static SoccerDefender conservativeDefender(String name, Float attack, Float defense, Float dribbling,
			Integer max_stamina) {
		SoccerDefender defender = new SoccerDefender(name, attack, defense, dribbling, max_stamina);
		defender.PASS_BACK_FORTH_RATIO = 0.6f;
		return defender;
	}

	@Override
	void playImp() {
		if (this.hasBall()) {
			this.pass();
		} else {
			// this.log("Moving around...");
		}

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("[%s - %s]: \t %s", "D", this.name, super.toString());
	}

	@Override
	public void pass() {
		if (Math.random() < this.PASS_BACK_FORTH_RATIO) {
			this.passBackwards();
		} else {
			this.passForward();
		}

	}

	@Override
	public void passForward() {
		Random rand = new Random();
		SoccerPlayer mate = (SoccerPlayer) this.getOwnTeam().getMidfielders()
				.get(rand.nextInt(this.getOwnTeam().getMidfielders().size()));
		this.releaseBall();
		mate.receiveBall();
		this.log(String.format("Passing forward to %s...", mate.getName()));

	}

	@Override
	public void passBackwards() {
		// TODO Auto-generated method stub
		SoccerPlayer mate = (SoccerPlayer) this.getOwnTeam().getGoalkeeper();
		this.releaseBall();
		mate.receiveBall();
		this.log(String.format("Passing backwards to %s...", mate.getName()));

	}

}

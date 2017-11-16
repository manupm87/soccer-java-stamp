package com.nokia.e2eo;

import java.util.Random;

public class SoccerStriker extends SoccerPlayer implements Striker {

	public SoccerStriker(String name, Float attack, Float defense, Float dribbling, Integer max_stamina) {
		super(name, attack, defense, dribbling, max_stamina);
		this.setDefense(this.getDefense() * Striker.DEFENSE_MULTIPLIER);
		this.setAttack(this.getAttack() * Striker.ATTACK_MULTIPLIER);
	}

	@Override
	void play() {
		super.play();
		if (this.hasBall()) {
			if (Math.random() < this.PASS_SHOOT_RATIO) {
				this.passBackwards();
			} else {
				this.shoot();
			}
		}
		else {
			this.log("Moving around...");
		}

	}

	@Override
	public void kickOff() {
		this.receiveBall();
		this.log("Kicking off!");
		this.passBackwards();

	}

	@Override
	public String toString() {
		return String.format("[%s - %s]: \t%s", "S", this.name, super.toString());
	}

	@Override
	public void shoot() {
		this.log("Shooting!");
		this.releaseBall();

		this.scoreGoal();
	}

	@Override
	public void passBackwards() {
		Random rand = new Random();
		SoccerPlayer mate = (SoccerPlayer) this.getTeam().getMidfielders().get(rand.nextInt(this.getTeam().getMidfielders().size()));
		this.releaseBall();
		mate.receiveBall();
		this.log(String.format("Passing backwards to %s...", mate.getName()));
	}

}

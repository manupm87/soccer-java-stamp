package com.nokia.e2eo;

import java.util.Random;

public class SoccerMidfielder extends SoccerPlayer implements Midfielder {

	public SoccerMidfielder(String name, Float attack, Float defense, Float dribbling, Integer max_stamina) {
		super(name, attack, defense, dribbling, max_stamina);
		this.setDefense(this.getDefense() * Midfielder.DEFENSE_MULTIPLIER);
		this.setAttack(this.getAttack() * Midfielder.ATTACK_MULTIPLIER);
	}

	@Override
	void play() {
		super.play();
		if (this.hasBall()) {
			if (Math.random() < this.PASS_SHOOT_RATIO) {
				this.pass();
			} else {
				this.shoot();
			}
		} else {
			this.log("Moving around...");
		}

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("[%s - %s]: \t %s", "M", this.name, super.toString());
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
		SoccerPlayer mate = (SoccerPlayer) this.getTeam().getStrikers()
				.get(rand.nextInt(this.getTeam().getStrikers().size()));
		this.releaseBall();
		mate.receiveBall();
		this.log(String.format("Passing forward to %s...", mate.getName()));

	}

	@Override
	public void passBackwards() {
		Random rand = new Random();
		SoccerPlayer mate = (SoccerPlayer) this.getTeam().getDefenders()
				.get(rand.nextInt(this.getTeam().getDefenders().size()));
		this.releaseBall();
		mate.receiveBall();
		this.log(String.format("Passing backwards to %s...", mate.getName()));

	}

	@Override
	public void shoot() {
		this.log("Shooting!");
		this.releaseBall();
		
		this.scoreGoal();

	}

}

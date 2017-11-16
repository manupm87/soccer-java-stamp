package com.nokia.e2eo;

import java.util.Random;

public class SoccerMidfielder extends SoccerPlayer implements Midfielder {

	private Float ATTACK_MULTIPLIER = 1.2f;
	private Float DEFENSE_MULTIPLIER = 1.2f;
	private Float PASS_SHOOT_RATIO = 0.8f;
	private Float PASS_BACK_FORTH_RATIO = 0.5f;

	private SoccerMidfielder(String name, Float attack, Float defense, Float dribbling, Integer max_stamina) {
		super(name, attack, defense, dribbling, max_stamina);
		this.setDefense(this.getDefense() * this.DEFENSE_MULTIPLIER);
		this.setAttack(this.getAttack() * this.ATTACK_MULTIPLIER);
	}

	public static SoccerMidfielder defaultMidfielder(String name, Float attack, Float defense, Float dribbling,
			Integer max_stamina) {
		SoccerMidfielder midfielder = new SoccerMidfielder(name, attack, defense, dribbling, max_stamina);
		return midfielder;
	}

	public static SoccerMidfielder offensiveMidfielder(String name, Float attack, Float defense, Float dribbling,
			Integer max_stamina) {
		SoccerMidfielder midfielder = new SoccerMidfielder(name, attack, defense, dribbling, max_stamina);
		midfielder.PASS_SHOOT_RATIO = 0.6f;
		midfielder.PASS_BACK_FORTH_RATIO = 0.3f;
		return midfielder;
	}

	public static SoccerMidfielder defensiveMidfielder(String name, Float attack, Float defense, Float dribbling,
			Integer max_stamina) {
		SoccerMidfielder midfielder = new SoccerMidfielder(name, attack, defense, dribbling, max_stamina);
		midfielder.PASS_SHOOT_RATIO = 0.9f;
		midfielder.PASS_BACK_FORTH_RATIO = 0.7f;
		return midfielder;
	}

	@Override
	void playImp() {
		if (this.hasBall()) {
			if (Math.random() < this.PASS_SHOOT_RATIO) {
				this.pass();
			} else {
				this.shoot();
			}
		} else {
			// this.log("Moving around...");
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

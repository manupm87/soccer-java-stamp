package com.nokia.e2eo;

import java.util.Random;

import com.nokia.e2eo.util.RNG;

public class SoccerStriker extends SoccerPlayer implements Striker {

	private Float PASS_SHOOT_RATIO;
	private Float DEFENSE_MULTIPLIER;
	private Float ATTACK_MULTIPLIER;

	private SoccerStriker(String name, Float attack, Float defense, Float dribbling, Integer max_stamina) {
		super(name, attack, defense, dribbling, max_stamina);
		this.PASS_SHOOT_RATIO = 0.5f;
		this.DEFENSE_MULTIPLIER = 0.5f;
		this.ATTACK_MULTIPLIER = 2f;
		this.setDefense(this.getDefense() * this.DEFENSE_MULTIPLIER);
		this.setAttack(this.getAttack() * this.ATTACK_MULTIPLIER);
	}

	public static SoccerStriker defaultStriker(String name, Float attack, Float defense, Float dribbling,
			Integer max_stamina) {

		return new SoccerStriker(name, attack, defense, dribbling, max_stamina);
	}

	public static SoccerStriker shooterStriker(String name, Float attack, Float defense, Float dribbling,
			Integer max_stamina) {

		SoccerStriker striker = new SoccerStriker(name, attack, defense, dribbling, max_stamina);
		striker.PASS_SHOOT_RATIO = 0.2f;
		striker.ATTACK_MULTIPLIER = 2.2f;
		striker.DEFENSE_MULTIPLIER = 0.2f;
		return striker;
	}

	public static SoccerStriker passerStriker(String name, Float attack, Float defense, Float dribbling,
			Integer max_stamina) {

		SoccerStriker striker = new SoccerStriker(name, attack, defense, dribbling, max_stamina);
		striker.PASS_SHOOT_RATIO = 0.8f;
		return striker;
	}

	@Override
	void playImp() {
		if (this.hasBall()) {
			if (this.rng.random() < this.PASS_SHOOT_RATIO) {
				this.passBackwards();
			} else {
				this.shoot();
			}
		} else {
			// this.log("Moving around...");
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
		SoccerPlayer mate = (SoccerPlayer) this.getTeam().getMidfielders()
				.get(rand.nextInt(this.getTeam().getMidfielders().size()));
		this.releaseBall();
		mate.receiveBall();
		this.log(String.format("Passing backwards to %s...", mate.getName()));
	}

}

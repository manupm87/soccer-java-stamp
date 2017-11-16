package com.nokia.e2eo;

import java.util.Random;

public class SoccerDefender extends SoccerPlayer implements Defender {

	public SoccerDefender(String name, Float attack, Float defense, Float dribbling, Integer max_stamina) {
		super(name, attack, defense, dribbling, max_stamina);
		this.setDefense(this.getDefense() * Defender.DEFENSE_MULTIPLIER);
		this.setAttack(this.getAttack() * Defender.ATTACK_MULTIPLIER);
	}

	@Override
	void play() {
		super.play();
		if (this.hasBall()) {
			this.pass();
		} else {
			this.log("Moving around...");
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
		SoccerPlayer mate = (SoccerPlayer) this.getTeam().getMidfielders()
				.get(rand.nextInt(this.getTeam().getMidfielders().size()));
		this.releaseBall();
		mate.receiveBall();
		this.log(String.format("Passing forward to %s...", mate.getName()));
		
	}

	@Override
	public void passBackwards() {
		// TODO Auto-generated method stub
		
	}

}

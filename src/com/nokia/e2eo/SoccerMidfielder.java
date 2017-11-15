package com.nokia.e2eo;

public class SoccerMidfielder extends SoccerPlayer implements Midfielder{

	public SoccerMidfielder(String name, Float attack, Float defense, Float dribbling, Integer max_stamina) {
		super(name, attack, defense, dribbling, max_stamina);
		this.setDefense(this.getDefense() * Midfielder.defense_multiplier);
		this.setAttack(this.getAttack() * Midfielder.attack_multiplier);
	}

	@Override
	void play() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("[%s - %s]: \t %s", "M", this.name, super.toString());
	}

	@Override
	public void pass() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void passForward() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void passBackwards() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shoot() {
		// TODO Auto-generated method stub
		
	}

}

package com.nokia.e2eo;

public class SoccerStriker extends SoccerPlayer implements Striker {

	public SoccerStriker(String name, Float attack, Float defense, Float dribbling, Integer max_stamina) {
		super(name, attack, defense, dribbling, max_stamina);
		this.setDefense(this.getDefense() * Striker.defense_multiplier);
		this.setAttack(this.getAttack() * Striker.attack_multiplier);
	}

	@Override
	void play() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("[%s - %s]: \t%s", "S", this.name, super.toString());
	}

	@Override
	public void shoot() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void passBackwards() {
		// TODO Auto-generated method stub
		
	}

}

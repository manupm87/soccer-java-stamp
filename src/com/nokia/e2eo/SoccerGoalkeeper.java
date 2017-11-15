package com.nokia.e2eo;

public class SoccerGoalkeeper extends SoccerPlayer implements Goalkeeper {
	
	private SoccerTeam team;
	

	public SoccerGoalkeeper(String name, Float attack, Float defense, Float dribbling, Integer max_stamina) {
		super(name, attack, defense, dribbling, max_stamina);
		this.setDefense(this.getDefense() * Goalkeeper.defense_multiplier);
		this.setAttack(this.getAttack() * Goalkeeper.attack_multiplier);
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
		}
		
	}
	
	@Override
	public String toString() {
		return String.format("[%s - %s]: \t %s", "G", this.name, super.toString());
	}

	@Override
	public void pass() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void passToDefender() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void passToMidfielder() {
		// TODO Auto-generated method stub
		
	}
}

package com.nokia.e2eo;

import java.util.Observable;

public abstract class SoccerPlayer extends Observable{
	public static final Integer stamina_consumption = 5;
	public static final Integer stamina_restoration = 10;
	
	public String name;
	
	public SoccerTeam team;
	
	public Float attack;
	public Float defense;
	public Float dribbling;
	public Integer max_stamina;
	public Integer cur_stamina;
	public Boolean haveBall = false;
	
	public SoccerPlayer(String name, Float attack, Float defense, Float dribbling, Integer max_stamina) {
		super();
		this.name = name;
		this.attack = attack;
		this.defense = defense;
		this.dribbling = dribbling;
		this.max_stamina = this.cur_stamina = max_stamina;
	}
	
	public void scoreGoal() {
		System.out.println(this.name + " scored an amazing goal!!!");
		this.setChanged();
		this.notifyObservers();
	}
	
	
	void rest() {
		this.cur_stamina = Math.min(this.max_stamina, this.cur_stamina + SoccerPlayer.stamina_restoration);
	}
	
	void play() {
		this.cur_stamina = Math.max(0, this.cur_stamina - SoccerPlayer.stamina_consumption);
	}
	
	public Boolean hasBall(){
		return this.haveBall;
	}
	
	public void giveBall() {
		this.haveBall = true;
	}
	
	
	public Float getAttack() {
		return attack;
	}

	public void setAttack(Float attack) {
		this.attack = attack;
	}

	public Float getDefense() {
		return defense;
	}

	public void setDefense(Float defense) {
		this.defense = defense;
	}

	public Float getDribbling() {
		return dribbling;
	}

	public void setDribbling(Float dribbling) {
		this.dribbling = dribbling;
	}

	public Integer getMax_stamina() {
		return max_stamina;
	}

	public void setMax_stamina(Integer max_stamina) {
		this.max_stamina = max_stamina;
	}

	public Integer getCur_stamina() {
		return cur_stamina;
	}

	public void setCur_stamina(Integer cur_stamina) {
		this.cur_stamina = cur_stamina;
	}
	

	public SoccerTeam getTeam() {
		return team;
	}

	public void setTeam(SoccerTeam team) {
		this.team = team;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String representation = String.format("Attack: %f, Defense: %f, Dribbling: %f, Stamina: %d / %d", this.attack,
				this.defense, this.dribbling, this.cur_stamina, this.max_stamina);
		return representation;
	}
}

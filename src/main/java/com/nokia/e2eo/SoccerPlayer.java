package com.nokia.e2eo;

import java.util.Observable;

import com.nokia.e2eo.util.RNG;
import com.nokia.e2eo.util.RNGFactory;
import com.nokia.e2eo.util.RandomNumberGenerator;

public abstract class SoccerPlayer extends Observable {
	protected static final Integer STAMINA_CONSUMPTION = 5;
	protected static final Integer STAMINA_RESTORATION = 10;
    
	protected String name;
    
	protected SoccerTeam ownTeam;
	protected SoccerTeam oponentTeam;
    
	protected Float attack;
	protected Float defense;
	protected Float dribbling;
	protected Integer maxStamina;
	protected Integer curStamina;
	protected Boolean haveBall = false;
	
	protected RandomNumberGenerator rng;

	protected SoccerPlayer(String name, Float attack, Float defense, Float dribbling, Integer max_stamina) {
		super();
		this.name = name;
		this.attack = attack;
		this.defense = defense;
		this.dribbling = dribbling;
		this.maxStamina = this.curStamina = max_stamina;
		this.rng = RNGFactory.rng();
	}

	public void scoreGoal() {
		this.setChanged();
		this.notifyObservers();
	}

	void rest() {
		this.curStamina = Math.min(this.curStamina, this.curStamina + SoccerPlayer.STAMINA_RESTORATION);
	}

	final public void play() {
		this.curStamina = Math.max(0, this.curStamina - SoccerPlayer.STAMINA_CONSUMPTION);
		this.playImp();
	}

	abstract void playImp();

	public Boolean hasBall() {
		return this.haveBall;
	}

	public void releaseBall() {
		this.haveBall = false;
	}

	public void receiveBall() {
		this.haveBall = true;
	}

	public String log(String message) {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("[%s] %s [%s]: %s\r\n", this.ownTeam.getName(), this.name, this.getClass().getSimpleName(), message));
		System.out.println(sb.toString());
		return sb.toString();
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

	public Integer getMaxStamina() {
		return curStamina;
	}

	public void setMaxStamina(Integer max_stamina) {
		this.curStamina = max_stamina;
	}

	public Integer getCurStamina() {
		return curStamina;
	}

	public void setCurStamina(Integer cur_stamina) {
		this.curStamina = cur_stamina;
	}

	public SoccerTeam getOwnTeam() {
		return ownTeam;
	}

	public void setOwnTeam(SoccerTeam team) {
		this.ownTeam = team;
	}
	
	public SoccerTeam getOponentTeam() {
		return oponentTeam;
	}

	public void setOponentTeam(SoccerTeam oponentTeam) {
		this.oponentTeam = oponentTeam;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setRng(RandomNumberGenerator rng) {
		this.rng = rng;
	}

	@Override
	public String toString() {
		String representation = String.format("Attack: %f, Defense: %f, Dribbling: %f, Stamina: %d / %d", this.attack,
				this.defense, this.dribbling, this.curStamina, this.curStamina);
		return representation;
	}

}

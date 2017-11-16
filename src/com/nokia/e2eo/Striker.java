package com.nokia.e2eo;

public interface Striker {
	Float DEFENSE_MULTIPLIER = 0.5f;
	Float ATTACK_MULTIPLIER = 2f;
	Float PASS_SHOOT_RATIO = 0.7f;
	
	void shoot();
	void passBackwards();
	void kickOff();
}

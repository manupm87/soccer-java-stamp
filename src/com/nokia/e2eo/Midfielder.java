package com.nokia.e2eo;

public interface Midfielder {
	Float ATTACK_MULTIPLIER = 1.2f;
	Float DEFENSE_MULTIPLIER = 1.2f;
	Float PASS_SHOOT_RATIO = 0.9f;
	Float PASS_BACK_FORTH_RATIO = 0.5f;
	
	void pass();
	void passForward();
	void passBackwards();
	
	void shoot();
}

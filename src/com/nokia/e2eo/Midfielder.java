package com.nokia.e2eo;

public interface Midfielder {
	Float attack_multiplier = 1.2f;
	Float defense_multiplier = 1.2f;
	
	void pass();
	void passForward();
	void passBackwards();
	
	void shoot();
}

package com.nokia.e2eo;

public interface Goalkeeper {
	Float attack_multiplier = 0.1f;
	Float defense_multiplier = 2.5f;
	
	void pass();
	void passToDefender();
	void passToMidfielder();
}

package com.nokia.e2eo;

public interface Goalkeeper {
	Float ATTACK_MULTIPLIER = 0.1f;
	Float DEFENSE_MULTIPLIER = 2.5f;
	Float PASS_DEF_MID_RATIO = 0.7f;
	
	void pass();
	void passToDefender();
	void passToMidfielder();
}

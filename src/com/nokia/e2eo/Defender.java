package com.nokia.e2eo;

public interface Defender {
	Float ATTACK_MULTIPLIER = 0.5f;
	Float DEFENSE_MULTIPLIER = 2f;
	Float PASS_BACK_FORTH_RATIO = 0.3f;
	
	void pass();
	void passForward();
	void passBackwards();

}

package com.nokia.e2eo;

public interface Defender {
	Float attack_multiplier = 0.5f;
	Float defense_multiplier = 2f;
	
	void pass();
	void passForward();
	void passBackwards();

}

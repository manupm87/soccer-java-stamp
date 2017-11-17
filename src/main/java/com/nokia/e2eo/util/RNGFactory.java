package com.nokia.e2eo.util;

public final class RNGFactory {
	public static RandomNumberGenerator rng() {
		return RNG.getInstance();
	}
	
	public static RandomNumberGenerator rngDetLow() {
		return RngDetLow.getInstance();
	}
	
	public static RandomNumberGenerator rngDetHigh() {
		return RngDetHigh.getInstance();
	}
}

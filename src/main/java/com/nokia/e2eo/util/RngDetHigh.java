package com.nokia.e2eo.util;

public class RngDetHigh implements RandomNumberGenerator {
	
	private static RngDetHigh instance = null;

	protected RngDetHigh() {
		// Exists only to defeat instantiation.
	}

	protected static RngDetHigh getInstance() {
		if (instance == null) {
			instance = new RngDetHigh();
		}
		return instance;
	}

	@Override
	public Integer nextInt(int bound) {
		return bound - 1;
	}

	@Override
	public Double random() {
		return 0.99;
	}
}

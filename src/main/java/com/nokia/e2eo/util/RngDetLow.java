package com.nokia.e2eo.util;

public class RngDetLow extends RNG {
	private static RngDetLow instance = null;

	protected RngDetLow() {
		// Exists only to defeat instantiation.
	}

	protected static RngDetLow getInstance() {
		if (instance == null) {
			instance = new RngDetLow();
		}
		return instance;
	}

	@Override
	public Integer nextInt(int bound) {
		return 0;
	}

	@Override
	public Double random() {
		return 0.01;
	}
}

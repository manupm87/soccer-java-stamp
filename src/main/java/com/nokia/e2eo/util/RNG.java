package com.nokia.e2eo.util;

import java.util.Random;

public class RNG implements RandomNumberGenerator {

	private static RNG instance = null;

	protected RNG() {
		// Exists only to defeat instantiation.
	}

	protected static RNG getInstance() {
		if (instance == null) {
			instance = new RNG();
		}
		return instance;
	}

	@Override
	public Integer nextInt(int bound) {
		return new Random().nextInt(bound);
	}

	@Override
	public Double random() {
		// TODO Auto-generated method stub
		return new Random().nextDouble();
	}

}

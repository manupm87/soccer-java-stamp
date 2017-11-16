package com.nokia.e2eo.util;

public class RNGdet extends RNG {
	@Override
	public Double random() {
		return 0.5;
	}

	@Override
	public Integer nextInt(int bound) {
		return 3;
	}
}

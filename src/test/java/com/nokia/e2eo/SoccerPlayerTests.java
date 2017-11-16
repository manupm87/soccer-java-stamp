package com.nokia.e2eo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SoccerPlayerTests {
	
	@Test
	public void strikerAttacksBetterThanMidfielder() {
		SoccerPlayer midfielder = SoccerMidfielder.defaultMidfielder("Mid", 10f, 10f, 10f, 100);
		SoccerPlayer striker = SoccerStriker.defaultStriker("Str", 10f, 10f, 10f, 100);
		assertTrue(midfielder.attack < striker.attack);
	}
	
	@Test
	public void midfielderAttacksBetterThanDefender() {
		SoccerPlayer midfielder = SoccerMidfielder.defaultMidfielder("Mid", 10f, 10f, 10f, 100);
		SoccerPlayer defender = SoccerDefender.defaultDefender("Def", 10f, 10f, 10f, 100);
		assertTrue(midfielder.attack > defender.attack);
	}
	
	@Test
	public void defenderAttacksBetterThanGoalkeeper() {
		SoccerPlayer goalkeeper = SoccerGoalkeeper.defaultGoalkeeper("Gol", 10f, 10f, 10f, 100);
		SoccerPlayer defender = SoccerDefender.defaultDefender("Def", 10f, 10f, 10f, 100);
		assertTrue(defender.attack > goalkeeper.attack);
	}

}

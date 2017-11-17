package com.nokia.e2eo;

import org.junit.Test;

import com.nokia.e2eo.util.RNGFactory;
import com.nokia.e2eo.util.RngDetHigh;
import com.nokia.e2eo.util.RngDetLow;

import junit.framework.TestCase;

public class SoccerDefenderTests extends TestCase{
	
	protected SoccerMatch match;
	protected SoccerDefender defender;

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		match = new SoccerMatch();
		defender = SoccerDefender.defaultDefender("Csabi", 10f, 10f, 10f, 100);
		SoccerTeam pheromaniacsFC = new SoccerTeam("Pheromaniacs F.C.");
		pheromaniacsFC.addGoalkeeper(SoccerGoalkeeper.defaultGoalkeeper("Zsombor", 10f, 10f, 10f, 100));
		pheromaniacsFC.addDefender(defender);
		pheromaniacsFC.addMidfielder(SoccerMidfielder.offensiveMidfielder("Manu", 10f, 10f, 10f, 100));
		pheromaniacsFC.addStriker(SoccerStriker.shooterStriker("Attila", 10f, 10f, 10f, 100));
		pheromaniacsFC.addObserver(match);
		match.setTeamA(pheromaniacsFC);

		SoccerTeam pheromaniacsFCbis = new SoccerTeam("Hungaricum F.C.");
		pheromaniacsFCbis.addGoalkeeper(SoccerGoalkeeper.ofensiveGoalkeeper("Mark", 10f, 10f, 10f, 100));
		pheromaniacsFCbis.addDefender(SoccerDefender.conservativeDefender("HPeti", 10f, 10f, 10f, 100));
		pheromaniacsFCbis.addMidfielder(SoccerMidfielder.defensiveMidfielder("Csati", 10f, 10f, 10f, 100));
		pheromaniacsFCbis.addStriker(SoccerStriker.defaultStriker("Zsoltaldo", 10f, 10f, 10f, 100));
		pheromaniacsFCbis.addObserver(match);
		match.setTeamB(pheromaniacsFCbis);

		pheromaniacsFC.setOponentTeam(pheromaniacsFCbis);
		pheromaniacsFCbis.setOponentTeam(pheromaniacsFC);
	}
	
	@Test
	public void testPlayImp() {
		SoccerDefender defender = (SoccerDefender) match.getTeamA().getDefenders().get(0);
		defender.releaseBall();
		Integer curStamina = defender.getCurStamina();
		defender.play();
		assertFalse(defender.hasBall());
		assertTrue(curStamina > defender.getCurStamina());
		
		defender.receiveBall();
		curStamina = defender.getCurStamina();
		defender.play();
		assertFalse(defender.hasBall());
		assertTrue(curStamina > defender.getCurStamina());
	}

	@Test
	public void testToString() {
		assertTrue(defender.toString().contains(defender.getName()));
	}

	@Test
	public void testDefaultDefender() {
		SoccerDefender def0 = SoccerDefender.defaultDefender("Def", 10f, 10f, 10f, 100);
		SoccerDefender def1 = SoccerDefender.conservativeDefender("DefCon", 10f, 10f, 10f, 1000);
		
		assertTrue(def1.PASS_BACK_FORTH_RATIO > def0.PASS_BACK_FORTH_RATIO);
	}

	@Test
	public void testConservativeDefender() {
		SoccerDefender def0 = SoccerDefender.defaultDefender("Def", 10f, 10f, 10f, 100);
		SoccerDefender def1 = SoccerDefender.conservativeDefender("DefCon", 10f, 10f, 10f, 1000);
		
		assertTrue(def1.PASS_BACK_FORTH_RATIO > def0.PASS_BACK_FORTH_RATIO);
	}

	@Test
	public void testPass() {
		
		defender.setRng(RNGFactory.rngDetLow());
		defender.pass();
		SoccerPlayer goalkeeper = (SoccerGoalkeeper) defender.getOwnTeam().getGoalkeeper();
		assertTrue(goalkeeper.hasBall());
		assertFalse(defender.hasBall());
		
		defender.setRng(RNGFactory.rngDetHigh());
		defender.pass();
		SoccerPlayer midfielder = (SoccerMidfielder) defender.getOwnTeam().getMidfielders().get(0);
		assertTrue(midfielder.hasBall());
		assertFalse(defender.hasBall());
	}

	@Test
	public void testPassForward() {
		defender.passForward();
		SoccerPlayer midfielder = (SoccerMidfielder) defender.getOwnTeam().getMidfielders().get(0);
		assertTrue(midfielder.hasBall());
		assertFalse(defender.hasBall());
	}

	@Test
	public void testPassBackwards() {
		defender.passBackwards();
		SoccerPlayer goalkeeper = (SoccerGoalkeeper) defender.getOwnTeam().getGoalkeeper();
		assertTrue(goalkeeper.hasBall());
		assertFalse(defender.hasBall());
	}

}

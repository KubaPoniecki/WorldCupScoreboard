package org.scoreboard;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class WorldCupScoreboardTest

{
    @Test
    public void settingNewMatchScoreToZeros() {
        Match match = new Match("Mexico", "Canada");
        assertEquals(match.getScore(), "Mexico 0 - Canada 0");
    }

    @Test
    public void changingScoreOfMatch() {
        Match match = new Match("Mexico", "Canada");
        match.setScore(1,0);
        assertEquals(match.getScore(), "Mexico 1 - Canada 0");
        match.setScore(1,1);
        assertEquals(match.getScore(), "Mexico 1 - Canada 1");
        match.setScore(1,2);
        assertEquals(match.getScore(), "Mexico 1 - Canada 2");
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters({"-1, 0", "0, -1", "-1, -1"})
    public void settingScoreToWrongNumber(int homeTeamScore, int awayTeamScore) {
        Match match = new Match("Mexico", "Canada");
        match.setScore(homeTeamScore,awayTeamScore);
    }

}

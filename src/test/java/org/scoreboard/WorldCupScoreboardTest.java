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
    @Parameters({"1, 0", "1, 1", "1, 2"})
    public void changingScoreOfMatch(int homeTeamScore, int awayTeamScore) {
        Match match = new Match("Mexico", "Canada");
        match.setScore(homeTeamScore,awayTeamScore);
        assertEquals(match.getScore(), "Mexico " + homeTeamScore + " - Canada " + awayTeamScore);
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters({"-1, 0", "0, -1", "-1, -1"})
    public void settingScoreToWrongNumber(int homeTeamScore, int awayTeamScore) {
        Match match = new Match("Mexico", "Canada");
        match.setScore(homeTeamScore,awayTeamScore);
    }

}

package org.scoreboard;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class WorldCupScoreboardTest

{
    @Test
    public void settingNewMatchScoreToZeros() {
        Match match = new Match("Mexico", "Canada");
        assertEquals(match.getScore(), "0 - 0");
    }

}

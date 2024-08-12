package org.scoreboard;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class WorldCupScoreboardTest {

    @Before
    public void init() {
        ScoreBoard.finishAll();
    }

    @Test
    public void settingNewMatchScoreToZeros() {
        Match match = new Match("Mexico", "Canada");
        assertEquals("Mexico 0 - Canada 0", match.getScore());
    }

    @Test
    public void removingLeadingAndTrailingWhiteSpaces() {
        Match match = new Match(" Mexico ", " Canada ");
        assertEquals("Mexico 0 - Canada 0", match.getScore());
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters({", Canada", "Canada,", ","})
    public void createMatchWithEmptyTeamName(String homeTeam, String awayTeam) {
        Match match = new Match(homeTeam, awayTeam);
    }

    @Test
    @Parameters({"1, 0", "1, 1", "1, 2"})
    public void changingScoreOfMatch(int homeTeamScore, int awayTeamScore) {
        Match match = new Match("Mexico", "Canada");
        match.setScore(homeTeamScore, awayTeamScore);
        assertEquals("Mexico " + homeTeamScore + " - Canada " + awayTeamScore, match.getScore());
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters({"-1, 0", "0, -1", "-1, -1"})
    public void settingScoreToWrongNumber(int homeTeamScore, int awayTeamScore) {
        Match match = new Match("Mexico", "Canada");
        match.setScore(homeTeamScore, awayTeamScore);
    }

    @Test
    public void addMatchToTheScoreBoard() {
        Match match = new Match("Mexico", "Canada");
        ScoreBoard.add(match);
        assertEquals(match, ScoreBoard.get(0));
    }

    @Test
    public void finishAllOngoingMatches() {
        Match match = new Match("Mexico", "Canada");
        Match match2 = new Match("Spain", "Brazil");
        ScoreBoard.add(match);
        ScoreBoard.add(match2);
        ScoreBoard.finishAll();
        assertEquals(Collections.emptyList(), ScoreBoard.ongoingMatches());
    }

    @Test
    public void finishMatchRemoveFromScoreBoard() {
        Match match = new Match("Mexico", "Canada");
        Match match2 = new Match("Spain", "Brazil");
        ScoreBoard.add(match);
        ScoreBoard.add(match2);
        ScoreBoard.finish("Mexico", "Canada");
        assertEquals(1, ScoreBoard.ongoingMatches().size());
    }


    @Test(expected = IllegalArgumentException.class)
    public void finishMatchWhichDoesntExist() {
        Match match = new Match("Mexico", "Canada");
        Match match2 = new Match("Spain", "Brazil");
        ScoreBoard.add(match);
        ScoreBoard.add(match2);
        ScoreBoard.finish("Spain", "Canada");
    }


    @Test
    public void getSummaryOfGamesInProgressSorted() {
        Match match = new Match("Mexico", "Canada");
        Match match2 = new Match("Spain", "Brazil");
        Match match3 = new Match("Germany", "France");
        ScoreBoard.add(match);
        ScoreBoard.add(match2);
        ScoreBoard.add(match3);
        ScoreBoard.get(1).setScore(2, 4);
        ScoreBoard.get(2).setScore(1, 0);
        assertEquals("1. Spain 2 - Brazil 4\n" +
                "2. Germany 1 - France 0\n" +
                "3. Mexico 0 - Canada 0\n", ScoreBoard.getSummary());
    }

    @Test
    public void getSummaryOfGamesInProgressSortedWhenTotalScoresAreEqual() {
        Match match = new Match("Mexico", "Canada");
        Match match2 = new Match("Spain", "Brazil");
        Match match3 = new Match("Germany", "France");
        Match match4 = new Match("Uruguay", "Italy");
        ScoreBoard.add(match);
        ScoreBoard.add(match2);
        ScoreBoard.add(match3);
        ScoreBoard.add(match4);
        ScoreBoard.get(1).setScore(2, 4);
        ScoreBoard.get(2).setScore(1, 0);
        assertEquals("1. Spain 2 - Brazil 4\n" +
                "2. Germany 1 - France 0\n" +
                "3. Uruguay 0 - Italy 0\n" +
                "4. Mexico 0 - Canada 0\n", ScoreBoard.getSummary());
    }

    @Test
    public void getSummaryWhenScoreBoardIsEmpty() {
        assertEquals("Score board is empty.", ScoreBoard.getSummary());
    }
}

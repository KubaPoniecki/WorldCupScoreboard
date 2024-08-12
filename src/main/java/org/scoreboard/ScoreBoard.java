package org.scoreboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreBoard {
    private static final List<Match> scoreBoard = new ArrayList<>();
    private static int whenStarted = 0;

    public static void add(Match match) {
        match.setStart(whenStarted);
        scoreBoard.add(match);
        whenStarted++;
    }

    public static Match get(int index) {
        return scoreBoard.get(index);
    }

    public static void finishAll() {
        scoreBoard.clear();
    }

    public static List<Match> ongoingMatches() {
        return scoreBoard;
    }

    public static void finish(String homeTeam, String awayTeam) {
        for (Match m : scoreBoard) {
            if (m.getHomeTeam().equals(homeTeam) && m.getAwayTeam().equals(awayTeam)) {
                scoreBoard.remove(m);
                return;
            }
        }
        throw new IllegalArgumentException("The match you are trying to end doesn't exist.");
    }

    public static String getSummary() {
        Collections.sort(scoreBoard);
        StringBuilder summary = new StringBuilder();
        if (scoreBoard.isEmpty()) {
            return "Score board is empty.";
        }
        for (int i = 0; i < scoreBoard.size(); i++) {
            summary.append(i + 1).append(". ").append(scoreBoard.get(i).getScore()).append("\n");
        }
        return summary.toString();
    }
}

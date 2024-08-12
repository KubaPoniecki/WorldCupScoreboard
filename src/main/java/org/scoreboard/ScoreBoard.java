package org.scoreboard;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {
    private static final List<Match> scoreBoard = new ArrayList<>();

    public static void add(Match match) {
        scoreBoard.add(match);
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
        StringBuilder summary = new StringBuilder();
        for (int i = 0; i < scoreBoard.size(); i++) {
            summary.append(i+1).append(". ").append(scoreBoard.get(i).getScore()).append("\n");
        }
        return summary.toString();
    }
}

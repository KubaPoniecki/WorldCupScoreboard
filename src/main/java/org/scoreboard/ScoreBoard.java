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
}

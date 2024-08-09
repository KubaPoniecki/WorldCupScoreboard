package org.scoreboard;

import java.util.Objects;

public class Match {
    private final String homeTeam;
    private final String awayTeam;
    private int homeTeamScore;
    private int awayTeamScore;

    public Match(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamScore = 0;
        this.awayTeamScore = 0;
    }

    public String getScore() {
        return homeTeam + " " + homeTeamScore + " - " + awayTeam + " " + awayTeamScore;
    }

    public void setScore(int homeTeamScore, int awayTeamScore) {
        if (homeTeamScore < 0 || awayTeamScore < 0) {
            throw new IllegalArgumentException("Score can't be negative");
        }
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return homeTeamScore == match.homeTeamScore && awayTeamScore == match.awayTeamScore && Objects.equals(homeTeam, match.homeTeam) && Objects.equals(awayTeam, match.awayTeam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeam, awayTeam, homeTeamScore, awayTeamScore);
    }

}

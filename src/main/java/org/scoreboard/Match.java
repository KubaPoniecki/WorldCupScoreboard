package org.scoreboard;

import java.util.Objects;

public class Match implements Comparable<Match> {
    private final String homeTeam;
    private final String awayTeam;
    private int homeTeamScore;
    private int awayTeamScore;
    private int totalScore;
    private int whenStarted;

    public Match(String homeTeam, String awayTeam) {
        if (homeTeam.isBlank() || awayTeam.isBlank()) {
            throw new IllegalArgumentException("Team name can't be empty");
        }
        this.homeTeam = homeTeam.trim();
        this.awayTeam = awayTeam.trim();
        this.homeTeamScore = 0;
        this.awayTeamScore = 0;
        this.totalScore = 0;
    }

    public String getScore() {
        return homeTeam + " " + homeTeamScore + " - " + awayTeam + " " + awayTeamScore;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getWhenStarted() {
        return whenStarted;
    }

    public void setScore(int homeTeamScore, int awayTeamScore) {
        if (homeTeamScore < 0 || awayTeamScore < 0) {
            throw new IllegalArgumentException("Score can't be negative");
        }
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
        this.totalScore = homeTeamScore + awayTeamScore;
    }

    public void setStart(int whenStarted) {
        this.whenStarted = whenStarted;
    }

    @Override
    public int compareTo(Match otherMatch) {
        if (otherMatch.getTotalScore() == getTotalScore()) {
            return Integer.compare(otherMatch.getWhenStarted(), getWhenStarted());
        }
        return Integer.compare(otherMatch.getTotalScore(), getTotalScore());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return homeTeamScore == match.homeTeamScore && awayTeamScore == match.awayTeamScore && totalScore == match.totalScore && whenStarted == match.whenStarted && Objects.equals(homeTeam, match.homeTeam) && Objects.equals(awayTeam, match.awayTeam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeam, awayTeam, homeTeamScore, awayTeamScore, totalScore, whenStarted);
    }
}

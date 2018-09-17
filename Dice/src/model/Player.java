package model;

public class Player {

    private String name;
    private int currentScore;
    private int totalScore;

    public String getName() {
        return name;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public Player(String name, int currentScore, int totalScore) {
        this.name = name;
        this.currentScore = currentScore;
        this.totalScore = totalScore;
    }

}

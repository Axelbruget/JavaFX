package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Player {

    //private String name;
    private IntegerProperty currentScore = new SimpleIntegerProperty();
    private IntegerProperty totalScore = new SimpleIntegerProperty();

    public int getCurrentScore() { return currentScore.get(); }
    public IntegerProperty currentScoreProperty() { return currentScore; }
    public void setCurrentScore(int currentScore) { this.currentScore.set(currentScore); }

    public void setTotalScore(int totalScore) { this.totalScore.set(totalScore); }
    public int getTotalScore() { return totalScore.get(); }
    public IntegerProperty totalScoreProperty() { return totalScore; }


    public Player() {
        setCurrentScore(0);
        setTotalScore(0);
    }

}

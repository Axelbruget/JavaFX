package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class PlayerManager {

    private Player playerOne;
    private Player playerTwo;

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    private IntegerProperty currentPlayerPlaying = new SimpleIntegerProperty();
    public int getCurrentPlayerPlaying() {return currentPlayerPlaying.get();}
    public void setCurrentPlayerPlaying(int currentPlayerPlaying) {this.currentPlayerPlaying.set(currentPlayerPlaying); }
    public IntegerProperty currentPlayerPlayingProperty() {return currentPlayerPlaying;}


    public PlayerManager(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        setCurrentPlayerPlaying(1);
    }

    public void nextPlayer(){
        if (getCurrentPlayerPlaying() == 1){
            setCurrentPlayerPlaying(2);
        }
        else setCurrentPlayerPlaying(1);
    }

    public Player getPlayer(){
        if (getCurrentPlayerPlaying() == 1){
            return playerOne;
        }
        else return playerTwo;
    }
}

package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Generator;
import model.Player;
import model.PlayerManager;


public class MainView{

    @FXML
    private Button roll;

    @FXML
    private Label result;

    @FXML
    private Label currentPlayerOne;

    @FXML
    private Label totalPlayerOne;

    @FXML
    private Label currentPlayerTwo;

    @FXML
    private Label totalPlayerTwo;

    @FXML
    private Label currentPlayerPlaying;


    private Generator generator = new Generator();
    private PlayerManager playerManager = new PlayerManager(new Player(), new Player());

    public void initialize(){

        result.textProperty().bind(generator.randomNumberProperty().asString());
        currentPlayerPlaying.textProperty().bind(playerManager.currentPlayerPlayingProperty().asString());

        currentPlayerOne.textProperty().bind(playerManager.getPlayerOne().currentScoreProperty().asString());
        totalPlayerOne.textProperty().bind(playerManager.getPlayerOne().totalScoreProperty().asString());

        currentPlayerTwo.textProperty().bind(playerManager.getPlayerTwo().currentScoreProperty().asString());
        totalPlayerTwo.textProperty().bind(playerManager.getPlayerTwo().totalScoreProperty().asString());

    }


    @FXML
    public void hold(){
        playerManager.getPlayer().setTotalScore(playerManager.getPlayer().getTotalScore() + playerManager.getPlayer().getCurrentScore());
        playerManager.getPlayer().setCurrentScore(0);
        playerManager.nextPlayer();
    }

    @FXML
    public void rollDice(){
        generator.generate();
        playerManager.getPlayer().setCurrentScore(playerManager.getPlayer().getCurrentScore() + generator.getRandomNumber());
    }

    @FXML
    public void quit(){
        result.getScene().getWindow().hide();
    }

}

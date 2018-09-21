package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
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

    @FXML
    private BorderPane borderPanePlayer1;

    @FXML
    private BorderPane borderPanePlayer2;



    private Generator generator = new Generator();
    private PlayerManager playerManager = new PlayerManager(new Player(), new Player());

    public void initialize(){

        result.textProperty().bind(generator.randomNumberProperty().asString());
        currentPlayerPlaying.textProperty().bind(playerManager.currentPlayerPlayingProperty().asString());

        currentPlayerOne.textProperty().bind(playerManager.getPlayerOne().currentScoreProperty().asString());
        totalPlayerOne.textProperty().bind(playerManager.getPlayerOne().totalScoreProperty().asString());

        currentPlayerTwo.textProperty().bind(playerManager.getPlayerTwo().currentScoreProperty().asString());
        totalPlayerTwo.textProperty().bind(playerManager.getPlayerTwo().totalScoreProperty().asString());

        playerManager.currentPlayerPlayingProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

            }
        });

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
        int number = generator.getRandomNumber();
        if (number == 1 ){
            playerManager.getPlayer().setCurrentScore(0);
            playerManager.nextPlayer();
        }
        else{
            playerManager.getPlayer().setCurrentScore(playerManager.getPlayer().getCurrentScore() + generator.getRandomNumber());
        }

    }

    @FXML
    public void quit(){
        result.getScene().getWindow().hide();
    }

    @FXML
    public void newGame(){
        playerManager.resetScore(playerManager.getPlayers());
    }

}

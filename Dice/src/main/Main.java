package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Player;
import model.PlayerManager;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/view/MainFXML.fxml"));
        primaryStage.setTitle("Dice Game");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        Boolean running = true;
        PlayerManager manager = new PlayerManager(new Player(), new Player());

        while ( running == true ){

            if (manager.getPlayerOne().getTotalScore() == 100 || manager.getPlayerTwo().getTotalScore() == 100){
                running = false;
            }
        }

    }
}

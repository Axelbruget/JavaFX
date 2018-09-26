package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Classe Main qui permet de démarrer le programme
 */
public class Main extends Application {

    /**
     * Permet d'afficher la fenêtre principale de l'application
     * @param primaryStage Le stage de la fenêtre principale
     * @throws Exception Propage une exception lorsque la fenêtre ne peut être affichée correctement
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        primaryStage.setTitle("Observable List");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * Appelee au lancement du programme, démarre l'application
     * @param args Tableau de chaines de caractères
     */
    public static void main(String[] args) {
        launch(args);
    }
}

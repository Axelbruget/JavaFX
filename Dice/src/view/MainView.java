package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Generator;


public class MainView {

    @FXML
    private Button roll;

    @FXML
    private Label result;

    @FXML
    public void test(){
        result.setText("resultat : " + Generator.generate());
    }
}

package view;

import javafx.fxml.FXML;

import java.awt.*;

public class CreationView {

    @FXML private TextField textFieldNomMatiere;

    public void clicValider(){
        textFieldNomMatiere.setText("");
    }

    public void clicAnnuler(){
        textFieldNomMatiere.setText("");
    }

    public String getNomMatiere() {
        return textFieldNomMatiere.getText();
    }
}

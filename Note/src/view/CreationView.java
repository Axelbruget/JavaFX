package view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class CreationView {

    @FXML private TextField textFieldNomMatiere;

    private String nomMatiere = null;

    public void clicValider(){
        nomMatiere = textFieldNomMatiere.getText();
        textFieldNomMatiere.getScene().getWindow().hide();
    }

    public void clicAnnuler(){
        nomMatiere = null;
        textFieldNomMatiere.getScene().getWindow().hide();
    }

    public String getNomMatiere() {
        return nomMatiere;
    }
}

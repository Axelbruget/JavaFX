package view;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import model.Personne;
import model.PersonneManager;

import javax.swing.plaf.basic.BasicOptionPaneUI;


/**
 * Vue principale qui correspond au fichier main.fxml
 */
public class MainView {

    /**
     * ListView qui correspond à la liste de personne affichée
     */
    @FXML
    private ListView<Personne> listeVue;

    /**
     * Button qui permet de supprimer une personne de la liste
     */
    @FXML
    private Button deleteButton;

    /**
     * Button qui permet de supprimer ce qui est saisie dans le TextField
     */
    @FXML
    private Button eventButton;

    /**
     * TextField qui permet de saisir un nom de personne
     */
    @FXML
    private TextField personneNameToolBar;

    /**
     * Second TextField qui permet également de saisir le nom d'une personne
     */
    @FXML
    private TextField affichageLabel;

    /**
     * Attribut PersonneManager qui permet de gérer la liste de personne
     */
    private PersonneManager manager = new PersonneManager();

    /**
     * Booleen qui retourne vrai lorsque la liste est vide, faux sinon
     */
    private BooleanProperty emptylist = new SimpleBooleanProperty();

    /**
     * Appelee juste avant le chargement du fichier FXML
     * Permet de réaliser les bindings
     */
    public void initialize(){

        listeVue.itemsProperty().bind(manager.listProperty());

        emptylist.bind(manager.listProperty().emptyProperty());
        deleteButton.disableProperty().bind(emptylist);

        affichageLabel.textProperty().bindBidirectional(personneNameToolBar.textProperty());

        eventButton.setOnAction(event -> affichageLabel.setText(null));

    }

    /**
     * Permet d'ajouter une personne à la liste au clic du boutton Add
     */
    public void add(){
        manager.addPersonne(personneNameToolBar.getText());
    }
    /**
     * Permet de supprimer une personne de la liste au clic du boutton Remove
     */
    public void delete(){
        manager.deletePersonne(listeVue.getSelectionModel().getSelectedIndex());
    }
}

package view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Personne;
import model.PersonneManager;


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
     * Label qui affiche la Personne sélectionnée
     */
    @FXML
    private Label affichageLabel;

    /**
     * Attribut PersonneManager qui permet de gérer la liste de personne
     */
    private PersonneManager manager = new PersonneManager();

    /**
     * Appelee juste avant le chargement du fichier FXML
     * Permet de réaliser les bindings
     */
    public void initialize(){

        listeVue.itemsProperty().bind(manager.listProperty());

        listeVue.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                affichageLabel.textProperty().bind(newValue.nomProperty().concat(" - ").concat(newValue.ageProperty()));
            }
            if (oldValue != null){
                affichageLabel.textProperty().unbindBidirectional(oldValue.nomProperty());
            }
        });

        eventButton.setOnAction(event -> personneNameToolBar.setText(""));

        listeVue.setCellFactory(param -> new MaListCell());

    }

    /**
     * Permet d'ajouter une personne à la liste au clic du boutton Add
     */
    public void add(){
        manager.addPersonne(personneNameToolBar.getText());
        personneNameToolBar.setText("");
    }
    /**
     * Permet de supprimer une personne de la liste au clic du boutton Remove
     */
    public void delete(){
        manager.deletePersonne(listeVue.getSelectionModel().getSelectedIndex());
    }
}

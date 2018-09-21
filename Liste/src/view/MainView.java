package view;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.Personne;
import model.PersonneManager;


/**
 * Vue principale
 */
public class MainView {

    @FXML
    private ListView listeVue;

    @FXML
    private Button deleteButton;

    private PersonneManager manager = new PersonneManager();
    private BooleanProperty emptylist = new SimpleBooleanProperty();

    public void initialize(){

        listeVue.itemsProperty().bind(manager.listProperty());

        emptylist.bind(manager.listProperty().emptyProperty());
        deleteButton.disableProperty().bind(emptylist);

    }

    public void addPersonne(){
        manager.getList().add(new Personne("test",(int) (Math.random() * 150)));
    }

    public void deletePersonne(){
        manager.getList().remove(manager.getList().size()-1);
    }
}

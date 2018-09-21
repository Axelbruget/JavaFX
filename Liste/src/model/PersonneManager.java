package model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class PersonneManager {

    private ObservableList<Personne> listobservable = FXCollections.observableArrayList();
    private ListProperty<Personne> list = new SimpleListProperty<>(listobservable);


    public ObservableList<Personne> getList() { return list.get(); }
    public ListProperty<Personne> listProperty() { return list; }
    public void setList(ObservableList<Personne> list) { this.list.set(list); }

    public PersonneManager() {
        listobservable.add(new Personne("Axel",15));
    }
}

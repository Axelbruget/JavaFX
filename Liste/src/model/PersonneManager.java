package model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Classe PersonneManager qui possède la liste de toutes les Personnes existantes et gérer l'ajout et suppression de Personne
 */
public class PersonneManager {

    /**
     * Collection Observable issue de la classe utilitaire FXCollections
     */
    private ObservableList<Personne> listobservable = FXCollections.observableArrayList();

    /**
     * Collection java standard qui correspond à une liste de personnes
     */
    private ListProperty<Personne> list = new SimpleListProperty<>(listobservable);


    public ObservableList<Personne> getList() { return list.get(); }
    public ListProperty<Personne> listProperty() { return list; }
    public void setList(ObservableList<Personne> list) { this.list.set(list); }

    /**
     * Constructeur qui permet d'avoir un élément dans la liste lorsqu'on instancie un objet PersonneManager
     */
    public PersonneManager() {
        listobservable.add(new Personne("Axel",21));
    }

    /**
     * Ajoute une Personne à la liste avec un nom donné et un age random
     * @param nomPersonne Le nom de la personne à ajouter
     */
    public void addPersonne(String nomPersonne){
        getList().add(new Personne(nomPersonne, (int) (Math.random() * 150)));
    }

    /**
     * Permet de supprimer une Personne de la liste
     * @param index L'index dans la liste de la personne que l'on veut supprimer
     */
    public void deletePersonne(int index){
            getList().remove(index);
    }
}

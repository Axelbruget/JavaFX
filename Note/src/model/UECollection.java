package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class UECollection {

    private List<Matiere> listMatiere = new ArrayList<>();
    private String nom;

    public static final String PROP_LIST = "listmatiere";
    public static final String PROP_NOM = "nom";

    private final transient PropertyChangeSupport propertyChangeUECollection = new PropertyChangeSupport(this);


    public List<Matiere> getListMatiere() { return listMatiere; }
    public String getNom() { return nom; }

    public void setListMatiere(List<Matiere> newList) {
        List<Matiere> oldList = this.listMatiere;
        propertyChangeUECollection.firePropertyChange(PROP_LIST,oldList,newList);
        this.listMatiere = newList;
    }

    public void setNom(String newNom) {
        String oldNom = this.nom;
        propertyChangeUECollection.firePropertyChange(PROP_NOM,oldNom,newNom);
        this.nom = newNom;
    }

    public UECollection(String nom) {
        this.nom = nom;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        propertyChangeUECollection.addPropertyChangeListener(listener);
    }

    public void supprimerMatiere(Matiere matiere) {
        listMatiere.remove(matiere);
    }

    public void ajouterMatiere(Matiere matiere) {
        listMatiere.add(matiere);
        int indexAjout = listMatiere.indexOf(matiere);
        propertyChangeUECollection.fireIndexedPropertyChange(PROP_LIST,indexAjout,null,matiere);
    }
}


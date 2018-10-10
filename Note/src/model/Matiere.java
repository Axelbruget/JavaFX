package model;


import javafx.beans.property.DoubleProperty;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Matiere {
    private String nom;
    private List<Note> listNote = new ArrayList<>();
    private Double moyenne;

    public static final String PROP_NOM = "nom";
    public static final String PROP_LIST = "listNote";
    public static final String PROP_MOYENNE = "moyenne";

    private final transient PropertyChangeSupport propertyChangeMatiere = new PropertyChangeSupport(this);

    public String getNom() { return nom; }
    public List<Note> getListNote() { return listNote; }
    public Double getMoyenne() { return moyenne; }

    public void setNom(String newNom) {
        String oldNom = this.nom;
        propertyChangeMatiere.firePropertyChange(PROP_NOM,oldNom,newNom);
        this.nom = newNom;
    }

    public void setListNote(List<Note> newList) {
        List<Note> oldList = this.listNote;
        propertyChangeMatiere.firePropertyChange(PROP_LIST,oldList,newList);
        this.listNote = newList;
    }

    public void setMoyenne(Double newMoyenne) {
        Double oldMoyenne = this.moyenne;
        propertyChangeMatiere.firePropertyChange(PROP_MOYENNE,oldMoyenne,newMoyenne);
        this.moyenne = newMoyenne;
    }

    public Matiere(String nom) {
        this.nom = nom;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        propertyChangeMatiere.addPropertyChangeListener(listener);
    }

    public void supprimerNote(Note note) {
        listNote.remove(note);
        mettreAJourMoyenne();
    }

    public void ajouterNote(Note note) {
        listNote.add(note);
        int indexAjout = listNote.indexOf(note);
        propertyChangeMatiere.fireIndexedPropertyChange(PROP_LIST,indexAjout,null,note);
        mettreAJourMoyenne();
    }

    private void mettreAJourMoyenne() {
        int total = 0;
        for (int i = 0;i<listNote.size();i++){
            total += listNote.get(i).getNote();
        }
        setMoyenne((double) total/listNote.size());
    }
}

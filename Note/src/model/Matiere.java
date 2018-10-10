package model;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Matiere {
    private String nom;
    private List<Note> listNote = new ArrayList<>();

    public static final String PROP_NOM = "nom";
    public static final String PROP_LIST = "listNote";

    private final transient PropertyChangeSupport propertyChangeMatiere = new PropertyChangeSupport(this);

    public String getNom() { return nom; }
    public List<Note> getListNote() { return listNote; }


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

    public Matiere(String nom) {
        this.nom = nom;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        propertyChangeMatiere.addPropertyChangeListener(listener);
    }

    public void supprimerNote(Note note) {
        listNote.remove(note);
    }

    public void ajouterNote(Note note) {
        listNote.add(note);
        int indexAjout = listNote.indexOf(note);
        propertyChangeMatiere.fireIndexedPropertyChange(PROP_LIST,indexAjout,null,note);
    }
}

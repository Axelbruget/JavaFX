package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Patient {

    private String nom;
    public static final String PROP_NOM = "nom";
    private final transient PropertyChangeSupport propertyChangePatient = new PropertyChangeSupport(this);

    public String getNom() { return nom; }

    public void setNom(String newNom) {
        String oldNom = this.nom;
        propertyChangePatient.firePropertyChange(PROP_NOM,oldNom,newNom);
        this.nom = newNom;
    }

    public Patient(String nom) {
        this.nom = nom;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        propertyChangePatient.addPropertyChangeListener(listener);
    }
}

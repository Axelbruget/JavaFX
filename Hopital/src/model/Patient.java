package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Patient {

    private String nom;
    private String prenom;

    public static final String PROP_NOM = "nom";
    public static final String PROP_PRENOM = "prenom";
    private final transient PropertyChangeSupport propertyChangePatient = new PropertyChangeSupport(this);

    public String getNom() { return nom; }
    public String getPrenom() {return prenom; }

    public void setNom(String newNom) {
        String oldNom = this.nom;
        propertyChangePatient.firePropertyChange(PROP_NOM,oldNom,newNom);
        this.nom = newNom;
    }

    public void setPrenom(String newPrenom){
        String oldPrenom = this.prenom;
        propertyChangePatient.firePropertyChange(PROP_PRENOM,oldPrenom,newPrenom);
        this.prenom = newPrenom;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        propertyChangePatient.addPropertyChangeListener(listener);
    }
}

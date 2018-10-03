package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Chambre {

    private int numero;
    public static final String PROP_NUMERO = "numero";

    private Patient patient;
    public static final String PROP_PATIENT = "patient";

    private final transient PropertyChangeSupport propertyChangeChambre = new PropertyChangeSupport(this);

    public void setNumero(int newNumero) {
        int oldNumero = this.numero;
        propertyChangeChambre.firePropertyChange(PROP_NUMERO,oldNumero,newNumero);
        this.numero = newNumero;
    }

    public void setPatient(Patient newPatient) {
        Patient oldPatient = this.patient;
        propertyChangeChambre.firePropertyChange(PROP_PATIENT,oldPatient,newPatient);
        this.patient = newPatient;

    }

    public Chambre(int numero, Patient patient) {
        this.numero = numero;
        this.patient = patient;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        propertyChangeChambre.addPropertyChangeListener(listener);
    }
}

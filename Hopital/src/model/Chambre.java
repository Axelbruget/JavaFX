package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class Chambre {

    private int numero;
    public static final String PROP_NUMERO = "numero";

    private List<Patient> listPatient;
    public static final String PROP_LIST_PATIENT = "listPatient";

    private final transient PropertyChangeSupport propertyChangeChambre = new PropertyChangeSupport(this);

    public void setNumero(int newNumero) {
        int oldNumero = this.numero;
        propertyChangeChambre.firePropertyChange(PROP_NUMERO,oldNumero,newNumero);
        this.numero = newNumero;
    }

    public void setListPatient(List<Patient> newListPatient) {
        List<Patient> oldListPatient = this.listPatient;
        propertyChangeChambre.firePropertyChange(PROP_LIST_PATIENT,oldListPatient,newListPatient);
        this.listPatient = newListPatient;

    }
    public int getNumero() { return numero; }
    public List<Patient> getListPatient() { return listPatient; }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        propertyChangeChambre.addPropertyChangeListener(listener);
    }
}

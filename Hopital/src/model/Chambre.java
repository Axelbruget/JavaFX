package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Chambre {

    private int numero;
    public static final String PROP_NUMERO = "numero";

    private List<Patient> listPatient = new ArrayList<>();
    public static final String PROP_LIST_PATIENT = "listPatient";

    private final transient PropertyChangeSupport propertyChangeChambre = new PropertyChangeSupport(this);

    public void setNumero(int newNumero) {
        int oldNumero = this.numero;
        propertyChangeChambre.firePropertyChange(PROP_NUMERO,oldNumero,newNumero);
        this.numero = newNumero;
    }

    public void ajouterPatient(Patient patient){
        listPatient.add(patient);
        int indexAjout = listPatient.indexOf(patient);
        propertyChangeChambre.fireIndexedPropertyChange(PROP_LIST_PATIENT,indexAjout,null,patient);
    }
    public void supprimerPatient(Patient patient){
        listPatient.remove(patient);
    }

    public int getNumero() { return numero; }
    public List<Patient> getListPatient() { return listPatient; }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        propertyChangeChambre.addPropertyChangeListener(listener);
    }
}

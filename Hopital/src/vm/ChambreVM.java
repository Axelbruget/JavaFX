package vm;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import model.Chambre;
import model.Patient;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ChambreVM implements PropertyChangeListener {

    private Chambre model;

    private IntegerProperty numero = new SimpleIntegerProperty();
        public int getNumero() { return numero.get(); }
        public IntegerProperty numeroProperty() { return numero; }
        public void setNumero(int numero) { this.numero.set(numero); }

    private ObjectProperty<Patient> patient = new SimpleObjectProperty<Patient>();
        public Object getPatient() { return patient.get(); }
        public ObjectProperty patientProperty() { return patient; }
        public void setPatient(Patient patient) { this.patient.set(patient); }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(Chambre.PROP_NUMERO)){
            numero.set((Integer) evt.getNewValue());
        }

        if (evt.getPropertyName().equals(Chambre.PROP_PATIENT)){
            patient.set((Patient) evt.getNewValue());
        }
    }
}

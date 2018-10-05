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

    private IntegerProperty numeroProperty = new SimpleIntegerProperty();
        public int getNumero() { return numeroProperty.get(); }
        public IntegerProperty getNumeroProperty() { return numeroProperty; }
        public void setNumero(int numero) { this.numeroProperty.set(numero); }

    private ObjectProperty<Patient> patientProperty = new SimpleObjectProperty<Patient>();
        public Object getPatient() { return patientProperty.get(); }
        public ObjectProperty getPatientProperty() { return patientProperty; }
        public void setPatient(Patient patient) { this.patientProperty.set(patient); }


    public ChambreVM() {
        model = new Chambre(1, new Patient("toto"));
        model.addPropertyChangeListener(this);
        patientProperty.setValue(model.getPatient());
        numeroProperty.set(model.getNumero());

        patientProperty.addListener((obs,oldv,newV) -> model.setPatient(newV));
        numeroProperty.addListener((obs,oldv,newV) -> model.setNumero((Integer) newV));

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(Chambre.PROP_NUMERO)){
            numeroProperty.set((Integer) evt.getNewValue());
        }

        if (evt.getPropertyName().equals(Chambre.PROP_PATIENT)){
            patientProperty.set((Patient) evt.getNewValue());
        }
    }
}

package vm;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Patient;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PatientVM implements PropertyChangeListener {

    private Patient model;

    private StringProperty propertyNom = new SimpleStringProperty();
        public void setNomProperty(String nomProperty) { this.propertyNom.set(nomProperty); }
        public String getNomProperty() { return propertyNom.get(); }
        public StringProperty nomPropertyProperty() { return propertyNom; }


    public PatientVM() {
        model = new Patient("test");
        model.addPropertyChangeListener(this);
        propertyNom.set(model.getNom());
        propertyNom.addListener((obs,oldv,newV) -> model.setNom(newV));
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(Patient.PROP_NOM)){
            propertyNom.set((String) evt.getNewValue());
        }
    }
}

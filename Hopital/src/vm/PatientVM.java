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
        public StringProperty propertyNomProperty() { return propertyNom; }

    private StringProperty propertyPrenom = new SimpleStringProperty();
        public void setPrenomProperty(String propertyPrenom) { this.propertyPrenom.set(propertyPrenom); }
        public String getPrenomProperty() { return propertyPrenom.get(); }
        public StringProperty propertyPrenomProperty() { return propertyPrenom; }

    public Patient getModel() {
        return model;
    }

    public PatientVM() {
        model = new Patient();
        model.addPropertyChangeListener(this);
        setNomProperty(model.getNom());
        setPrenomProperty(model.getPrenom());
        propertyNom.addListener((obs,oldv,newV) -> model.setNom(newV));
        propertyPrenom.addListener((ons,oldV,newV) -> model.setPrenom(newV));
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(Patient.PROP_NOM)){
            setNomProperty((String) evt.getNewValue());
        }
    }
}

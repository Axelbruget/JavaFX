package vm;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Chambre;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ChambreVM implements PropertyChangeListener {

    private Chambre model;

    private IntegerProperty numeroProperty = new SimpleIntegerProperty();
        public int getNumero() { return numeroProperty.get(); }
        public IntegerProperty getNumeroProperty() { return numeroProperty; }
        public void setNumero(int numero) { this.numeroProperty.set(numero); }


    private ObservableList<PatientVM> listObs = FXCollections.observableArrayList();
        private ListProperty<PatientVM> list = new SimpleListProperty<>(listObs);
        public ObservableList<PatientVM> getList() { return FXCollections.unmodifiableObservableList(list.get()); }
        public ReadOnlyListProperty<PatientVM> listProperty() { return list; }


    public Chambre getModel() { return model; }

    public ChambreVM() {
        model = new Chambre();
        model.addPropertyChangeListener(this);

        numeroProperty.set(model.getNumero());
        numeroProperty.addListener((obs,oldv,newV) -> model.setNumero((Integer) newV));
    }

    public ChambreVM(Chambre chambre){
            this.model = chambre;
            model.addPropertyChangeListener(this);
            setNumero(model.getNumero());
            numeroProperty.addListener((observable, oldValue, newValue) -> model.setNumero(getNumero()));
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(Chambre.PROP_NUMERO)){
            numeroProperty.set((Integer) evt.getNewValue());
        }

        if (evt.getPropertyName().equals(Chambre.PROP_LIST_PATIENT)){
            listObs.setAll((PatientVM) evt.getNewValue());
        }
    }

    public void addPatientVM(String nomPatient) {
        PatientVM patientVM = new PatientVM();
        patientVM.setNomProperty(nomPatient);
        listObs.add(patientVM);
    }
}

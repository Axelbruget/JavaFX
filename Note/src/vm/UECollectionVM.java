package vm;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Matiere;
import model.UECollection;

import java.beans.IndexedPropertyChangeEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class UECollectionVM implements PropertyChangeListener {

    private UECollection model;

    private ObservableList<MatiereVM> listObs = FXCollections.observableArrayList();
    private ListProperty<MatiereVM> list = new SimpleListProperty<>(listObs);
        public ObservableList<MatiereVM> getList() { return FXCollections.unmodifiableObservableList(list.get()); }
        public ReadOnlyListProperty<MatiereVM> listProperty() { return list; }

    private StringProperty nomProperty = new SimpleStringProperty();
        public void setNomProperty(String nomProperty) { this.nomProperty.set(nomProperty); }
        public String getNomProperty() { return nomProperty.get(); }
        public StringProperty nomPropertyProperty() { return nomProperty; }

    public UECollection getModel() { return model; }

    public UECollectionVM(String nomUE) {
        model = new UECollection(nomUE);
        model.addPropertyChangeListener(this);
        nomProperty.set(model.getNom());
        nomProperty.addListener((obs,oldV,newV) -> model.setNom(newV));
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        IndexedPropertyChangeEvent e = (IndexedPropertyChangeEvent) evt;

        if (evt.getPropertyName().equals(UECollection.PROP_LIST)){
            Matiere matiere = (Matiere) evt.getNewValue();
            if (listObs.size() <= e.getIndex()){
                listObs.add(new MatiereVM((Matiere) evt.getNewValue()));
            }else{
                if (!listObs.get(e.getIndex()).getModel().equals(matiere)){
                    listObs.add(e.getIndex(),new MatiereVM((String) evt.getNewValue()));
                }
            }
        }
        if(evt.getPropertyName().equals(UECollection.PROP_NOM)){
            nomProperty.set((String) evt.getNewValue());
        }
    }

    public void addMatiereVM(String nomMatiere) {
            MatiereVM MatiereVMAAjouter = new MatiereVM(nomMatiere);
            listObs.add(MatiereVMAAjouter);
            model.ajouterMatiere(MatiereVMAAjouter.getModel());
    }

    public void removeMatiereVM(MatiereVM matiereVM) {
            listObs.remove(matiereVM);
            model.supprimerMatiere(matiereVM.getModel());
    }
}

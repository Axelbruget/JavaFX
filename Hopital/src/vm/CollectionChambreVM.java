package vm;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.CollectionChambre;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class CollectionChambreVM implements PropertyChangeListener {

    private CollectionChambre model;

    private ObservableList<ChambreVM> listObs = FXCollections.observableArrayList();
    private ListProperty<ChambreVM> list = new SimpleListProperty<>(listObs);
        public ObservableList<ChambreVM> getList() { return FXCollections.unmodifiableObservableList(list.get()); }
        public ReadOnlyListProperty<ChambreVM> listProperty() { return list; }


    public CollectionChambreVM() {
        model = new CollectionChambre(new ArrayList<>());
        model.addPropertyChangeListener(this);
        //listObs.setAll(model.getListChambre());
        //listObs.addListener((obs,oldV,newV) -> model.setListChambre(newV));
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(CollectionChambre.PROP_LIST)){
            listObs.add((ChambreVM) evt.getNewValue());
        }
    }

    public void addChambreVM(ChambreVM chambre){
            listObs.add(chambre);
    }
}

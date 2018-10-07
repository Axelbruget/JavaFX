package vm;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Chambre;
import model.CollectionChambre;

import java.beans.IndexedPropertyChangeEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CollectionChambreVM implements PropertyChangeListener {

    private CollectionChambre model;

    private ObservableList<ChambreVM> listObs = FXCollections.observableArrayList();
    private ListProperty<ChambreVM> list = new SimpleListProperty<>(listObs);
        public ObservableList<ChambreVM> getList() { return FXCollections.unmodifiableObservableList(list.get()); }
        public ReadOnlyListProperty<ChambreVM> listProperty() { return list; }


    public CollectionChambreVM() {
        model = new CollectionChambre();
        model.addPropertyChangeListener(this);

    }

    public CollectionChambre getModel() { return model; }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        IndexedPropertyChangeEvent e = (IndexedPropertyChangeEvent) evt;

        if (evt.getPropertyName().equals(CollectionChambre.PROP_LIST)){
            Chambre chambre = (Chambre) evt.getNewValue();
            if (listObs.size() <= e.getIndex()){
                listObs.add(new ChambreVM((Chambre) evt.getNewValue()));
            }else{
                if(!listObs.get(e.getIndex()).getModel().equals(chambre)){
                    listObs.add(e.getIndex(),new ChambreVM((Chambre) evt.getNewValue()));
                }
            }
        }
    }

    public void ajouterChambreVM(ChambreVM chambreVM){
            listObs.add(chambreVM);
            model.ajouterChambre(chambreVM.getModel());
    }

    public void supprimerChambreVM(ChambreVM chambreVM){
            listObs.remove(chambreVM);
            model.supprimerChambre(chambreVM.getModel());
    }
}

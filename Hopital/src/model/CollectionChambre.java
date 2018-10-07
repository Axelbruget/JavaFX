package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class CollectionChambre {

    private List<Chambre> listChambre = new ArrayList<>();
    public static final String PROP_LIST = "listchambre";
    private final transient PropertyChangeSupport propertyChangeCollectionChambre = new PropertyChangeSupport(this);

    public List<Chambre> getListChambre() { return listChambre; }

    public void ajouterChambre(Chambre chambre){
        listChambre.add(chambre);
        int indexAjout = listChambre.indexOf(chambre);
        propertyChangeCollectionChambre.fireIndexedPropertyChange(PROP_LIST,indexAjout,null,chambre);
    }

    public void supprimerChambre(Chambre chambre){
        listChambre.remove(chambre);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        propertyChangeCollectionChambre.addPropertyChangeListener(listener);
    }
}

package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class CollectionChambre {

    private List<Chambre> listChambre;
    public static final String PROP_LIST = "listchambre";
    private final transient PropertyChangeSupport propertyChangeCollectionChambre = new PropertyChangeSupport(this);

    public List<Chambre> getListChambre() { return listChambre; }

    public void setListChambre(List<Chambre> newlistChambre) {
        List oldList = this.listChambre;
        propertyChangeCollectionChambre.firePropertyChange(PROP_LIST,oldList,newlistChambre);
        this.listChambre = newlistChambre;
    }

    public CollectionChambre(List<Chambre> listChambre) {
        this.listChambre = listChambre;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        propertyChangeCollectionChambre.addPropertyChangeListener(listener);
    }
}

package vm;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Matiere;
import model.Note;

import java.beans.IndexedPropertyChangeEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MatiereVM implements PropertyChangeListener {
    private Matiere model;

    private ObservableList<NoteVM> listObs = FXCollections.observableArrayList();
    private ListProperty<NoteVM> list = new SimpleListProperty<>(listObs);
        public ObservableList<NoteVM> getList() { return FXCollections.unmodifiableObservableList(list.get()); }
        public ReadOnlyListProperty<NoteVM> listProperty() { return list; }

    private StringProperty nomProperty = new SimpleStringProperty();
        public String getNomProperty() { return nomProperty.get(); }
        public void setNomProperty(String nomProperty) { this.nomProperty.set(nomProperty); }
        public StringProperty nomPropertyProperty() { return nomProperty; }


    public Matiere getModel() { return model; }

    public MatiereVM(String nomMatiere) {
        model = new Matiere(nomMatiere);
        model.addPropertyChangeListener(this);
        nomProperty.set(model.getNom());
        nomProperty.addListener((obs,oldV,newV) -> model.setNom(newV));
    }

    public MatiereVM(Matiere matiere){
         model = matiere;
         model.addPropertyChangeListener(this);
         setNomProperty(model.getNom());
         nomProperty.addListener((obs,oldV,newV) -> model.setNom(newV));
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        IndexedPropertyChangeEvent e = (IndexedPropertyChangeEvent) evt;

        if (evt.getPropertyName().equals(Matiere.PROP_NOM)){
            nomProperty.set((String) evt.getNewValue());
        }
        if (evt.getPropertyName().equals(Matiere.PROP_LIST)){
            Note note = (Note) evt.getNewValue();
            if (listObs.size() <= e.getIndex()){
                listObs.add(new NoteVM((Integer) evt.getNewValue()));
            }else{
                if(! listObs.get(e.getIndex()).getModel().equals(note)){
                    listObs.add(e.getIndex(),new NoteVM((Integer) evt.getNewValue()));
                }
            }
        }
    }

    public void addNote(int note) {
            NoteVM noteAAjouter = new NoteVM(note);
            listObs.add(noteAAjouter);
            model.ajouterNote(noteAAjouter.getModel());
    }

    public void removeNote(NoteVM selectedNote) {
            listObs.remove(selectedNote);
            model.supprimerNote(selectedNote.getModel());
    }
}

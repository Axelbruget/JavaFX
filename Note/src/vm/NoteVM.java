package vm;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import model.Note;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class NoteVM implements PropertyChangeListener {

    private Note model;

    private IntegerProperty noteProperty = new SimpleIntegerProperty();
        public void setNoteProperty(int noteProperty) { this.noteProperty.set(noteProperty); }
        public int getNoteProperty() { return noteProperty.get(); }
        public IntegerProperty notePropertyProperty() { return noteProperty; }

    public Note getModel() { return model; }

    public NoteVM(int value) {
        model = new Note(value);
        model.addPropertyChangeListener(this);
        setNoteProperty(model.getNote());
        noteProperty.addListener((obs,oldv,newV) -> model.setNote((Integer) newV));
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(Note.PROP_NOTE)){
            setNoteProperty((Integer) evt.getNewValue());
        }
    }
}

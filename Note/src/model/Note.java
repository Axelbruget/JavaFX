package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Note {
    private int note;
    public static final String PROP_NOTE = "note";
    private final transient PropertyChangeSupport propertyChangeNote = new PropertyChangeSupport(this);

    public int getNote() { return note; }

    public void setNote(int newNote) {
        int oldNote = this.note;
        propertyChangeNote.firePropertyChange(PROP_NOTE,oldNote,newNote);
        this.note = newNote;
    }

    public Note(int note) {
        this.note = note;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        propertyChangeNote.addPropertyChangeListener(listener);
    }

}

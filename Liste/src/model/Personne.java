package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Personne {
    private StringProperty nom = new SimpleStringProperty();
    private IntegerProperty age = new SimpleIntegerProperty();

    public String getNom() { return nom.get(); }
    public StringProperty nomProperty() { return nom; }
    public void setNom(String nom) { this.nom.set(nom); }

    public int getAge() { return age.get(); }
    public IntegerProperty ageProperty() { return age; }
    public void setAge(int age) { this.age.set(age); }

    public Personne(String nom, int age) {
        setAge(age);
        setNom(nom);
    }

    @Override
    public String toString(){
        return getNom() + " " + getAge();
    }
}

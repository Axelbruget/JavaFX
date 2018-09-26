package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Classe Personne qui possède un nom sous forme de chaine de caractère et un age sous forme d'entier
 */
public class Personne {
    private StringProperty nom = new SimpleStringProperty();
    private IntegerProperty age = new SimpleIntegerProperty();

    public String getNom() { return nom.get(); }
    public StringProperty nomProperty() { return nom; }
    public void setNom(String nom) { this.nom.set(nom); }

    public int getAge() { return age.get(); }
    public IntegerProperty ageProperty() { return age; }
    public void setAge(int age) { this.age.set(age); }

    /**
     * Constructeur d'une Personne
     * @param nom Le nom de la personne sous forme de chaîne de caractère
     * @param age L'age de la personne sous forme d'entier
     * @throws IllegalArgumentException Une exception est levée lorsqu'un nom vide ou nul est donné au constructeur
     */
    public Personne(String nom, int age) throws IllegalArgumentException{
        if (nom == null || nom.equals("")){
            throw new IllegalArgumentException();
        }
        setAge(age);
        setNom(nom);
    }


    /**
     * Redéfinition de la méthode toString qui renvoit de base le nom de l'objet et son addresse
     * @return Retourne le nom suivie de l'age de la Personne
     */
    @Override
    public String toString(){
        return getNom() + " " + getAge();
    }
}

package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Generator {

    private IntegerProperty randomNumber = new SimpleIntegerProperty();

    public int getRandomNumber() { return randomNumber.get(); }
    public IntegerProperty randomNumberProperty() { return randomNumber; }
    public void setRandomNumber(int randomNumber) { this.randomNumber.set(randomNumber); }


    public Generator() {

    }

    public void generate(){
        randomNumber.setValue((Math.random() * 6) + 1);
    }
}

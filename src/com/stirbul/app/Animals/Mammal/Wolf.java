package com.stirbul.app.Animals.Mammal;

import com.stirbul.app.AdditionalClasses.Predator;
import com.stirbul.app.Animals.Animal;
import com.stirbul.app.AdditionalClasses.Pray;

public class Wolf extends Mammal {
    private int numberOfEyes = 2;

    public Wolf(String species, int numberOfLegs, boolean hasATail, int moveSpeed, String habitat, Double weight,
                Double height, Double brainWeight, String hairColour, int numberOfLungs, int numberOfEyes) {
        super(species, numberOfLegs, hasATail, moveSpeed, habitat, weight, height, brainWeight, hairColour, numberOfLungs);
        this.numberOfEyes = numberOfEyes;
    }

    public int getNumberOfEyes() {
        return numberOfEyes;
    }

    public void setNumberOfEyes(int numberOfEyes) {
        this.numberOfEyes = numberOfEyes;
    }

    @Override
    protected void move() {
        System.out.println("The com.stirbul.app.Animals.Mammal.Wolf is moving with the unknown speed");
    }

}

package com.stirbul.app.Animals.Mammal;

import com.stirbul.app.Animals.Animal;

public class Mammal extends Animal {
    private Double brainWeight;
    private String hairColour;
    private int numberOfLungs = 2;

    public Mammal(String species,int numberOfLegs, boolean hasATail, int moveSpeed, String habitat, Double weight, Double height,
                  Double brainWeight, String hairColour, int numberOfLungs) {
        super(species,numberOfLegs, hasATail, moveSpeed, habitat, weight, height);
        this.brainWeight = brainWeight;
        this.hairColour = hairColour;
        this.numberOfLungs = numberOfLungs;
    }

    public Double getBrainWeight() {
        return brainWeight;
    }

    public void setBrainWeight(Double brainWeight) {
        this.brainWeight = brainWeight;
    }

    public String getHairColour() {
        return hairColour;
    }

    public void setHairColour(String hairColour) {
        this.hairColour = hairColour;
    }

    public int getNumberOfLungs() {
        return numberOfLungs;
    }

    public void setNumberOfLungs(int numberOfLungs) {
        this.numberOfLungs = numberOfLungs;
    }
}

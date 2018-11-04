package com.stirbul.app.Animals.Mammal;

import com.stirbul.app.AdditionalClasses.Pray;
import com.stirbul.app.AdditionalClasses.Predator;
import com.stirbul.app.Animals.Animal;

public class Fox extends Mammal {
    private String agilityLevel;

    public Fox(String species,int numberOfLegs, boolean hasATail, int moveSpeed, String habitat, Double weight, Double height,
               Double brainWeight, String hairColour, int numberOfLungs, String agilityLevel) {
        super(species, numberOfLegs, hasATail, moveSpeed, habitat, weight, height, brainWeight, hairColour, numberOfLungs);
        this.agilityLevel = agilityLevel;
    }

    public String getAgilityLevel() {
        return agilityLevel;
    }

    public void setAgilityLevel(String agilityLevel) {
        this.agilityLevel = agilityLevel;
    }
}

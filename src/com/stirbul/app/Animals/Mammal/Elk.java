package com.stirbul.app.Animals.Mammal;

import com.stirbul.app.AdditionalClasses.Pray;
import com.stirbul.app.AdditionalClasses.Predator;
import com.stirbul.app.Animals.Animal;

public class Elk extends Mammal{
    private boolean hasHorns;
    private int hornSize;

    public Elk(String species, int numberOfLegs, boolean hasATail, int moveSpeed, String habitat, Double weight,
               Double height, Double brainWeight, String hairColour, int numberOfLungs,
               boolean hasHorns, int hornSize) {
        super(species, numberOfLegs, hasATail, moveSpeed, habitat, weight, height, brainWeight, hairColour, numberOfLungs);
        this.hasHorns = hasHorns;
        this.hornSize = hornSize;
    }


    public boolean isHasHorns() {
        return hasHorns;
    }

    public void setHasHorns(boolean hasHorns) {
        this.hasHorns = hasHorns;
    }

    public int getHornSize() {
        return hornSize;
    }

    public void setHornSize(int hornSize) {
        this.hornSize = hornSize;
    }
}

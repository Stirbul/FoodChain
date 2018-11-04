package com.stirbul.app.Animals.Bird;

import com.stirbul.app.AdditionalClasses.Pray;
import com.stirbul.app.AdditionalClasses.Predator;
import com.stirbul.app.Animals.Animal;

public class Eagle extends Bird {
    private int vision;
    private int divingSpeed;

    public Eagle(String species, int numberOfLegs, boolean hasATail, int moveSpeed, String habitat, Double weight, Double height,
                 Double flyHeight, Double wingSpread, String formOfBeak, int vision, int divingSpeed) {
        super(species,numberOfLegs, hasATail, moveSpeed, habitat, weight, height, flyHeight, wingSpread, formOfBeak);
        this.vision = vision;
        this.divingSpeed = divingSpeed;
    }

    public int getVision() {
        return vision;
    }

    public void setVision(int vision) {
        this.vision = vision;
    }

    public int getDivingSpeed() {
        return divingSpeed;
    }

    public void setDivingSpeed(int divingSpeed) {
        this.divingSpeed = divingSpeed;
    }
}

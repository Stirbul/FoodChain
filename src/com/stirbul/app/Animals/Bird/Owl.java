package com.stirbul.app.Animals.Bird;

import com.stirbul.app.AdditionalClasses.Pray;
import com.stirbul.app.AdditionalClasses.Predator;
import com.stirbul.app.Animals.Animal;

public class Owl extends Bird {
    private String headRotate;
    private boolean eyesMotion;

    public Owl(String species, int numberOfLegs, boolean hasATail, int moveSpeed, String habitat, Double weight, Double height,
               Double flyHeight, Double wingSpread, String formOfBeak, String headRotate, boolean eyesMotion) {
        super(species,numberOfLegs, hasATail, moveSpeed, habitat, weight, height, flyHeight, wingSpread, formOfBeak);
        this.headRotate = headRotate;
        this.eyesMotion = eyesMotion;
    }

    public String getHeadRotate() {
        return headRotate;
    }

    public void setHeadRotate(String headRotate) {
        this.headRotate = headRotate;
    }

    public boolean isEyesMotion() {
        return eyesMotion;
    }

    public void setEyesMotion(boolean eyesMotion) {
        this.eyesMotion = eyesMotion;
    }
}

package com.stirbul.app.Animals.Bird;

import com.stirbul.app.Animals.Animal;

public class Bird extends Animal {
    private Double flyHeight;
    private Double wingSpread;
    private String formOfBeak;

    public Bird(String species,int numberOfLegs, boolean hasATail, int moveSpeed, String habitat, Double weight,
                Double height, Double flyHeight, Double wingSpread, String formOfBeak) {
        super(species,numberOfLegs, hasATail, moveSpeed, habitat, weight, height);
        this.flyHeight = flyHeight;
        this.wingSpread = wingSpread;
        this.formOfBeak = formOfBeak;
    }

    public Double getFlyHeight() {
        return flyHeight;
    }

    public void setFlyHeight(Double flyHeight) {
        this.flyHeight = flyHeight;
    }

    public Double getWingSpread() {
        return wingSpread;
    }

    public void setWingSpread(Double wingSpread) {
        this.wingSpread = wingSpread;
    }

    public String getFormOfBeak() {
        return formOfBeak;
    }

    public void setFormOfBeak(String formOfBeak) {
        this.formOfBeak = formOfBeak;
    }
}

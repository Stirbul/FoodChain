package com.stirbul.app.Animals.Bird;

import com.stirbul.app.AdditionalClasses.Pray;
import com.stirbul.app.AdditionalClasses.Predator;
import com.stirbul.app.Animals.Animal;

public class Pigeon extends Bird {
    private Double distancePerDay;
    private boolean canSitOnBranch;

    public Pigeon(String species, int numberOfLegs, boolean hasATail, int moveSpeed, String habitat, Double weight, Double height,
                  Double flyHeight, Double wingSpread, String formOfBeak, Double distancePerDay,
                  boolean canSitOnBranch) {
        super(species,numberOfLegs, hasATail, moveSpeed, habitat, weight, height, flyHeight, wingSpread, formOfBeak);
        this.distancePerDay = distancePerDay;
        this.canSitOnBranch = canSitOnBranch;
    }

    public Double getDistancePerDay() {
        return distancePerDay;
    }

    public void setDistancePerDay(Double distancePerDay) {
        this.distancePerDay = distancePerDay;
    }

    public boolean isCanSitOnBranch() {
        return canSitOnBranch;
    }

    public void setCanSitOnBranch(boolean canSitOnBranch) {
        this.canSitOnBranch = canSitOnBranch;
    }
}

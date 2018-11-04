package com.stirbul.app.Animals.Mammal;


import com.stirbul.app.AdditionalClasses.Predator;
import com.stirbul.app.Animals.Animal;

public class Mouse extends Mammal {
    private boolean isScientific;
    private String eyeColour;

    public Mouse(String species, int numberOfLegs, boolean hasATail, int moveSpeed, String habitat, Double weight,
                 Double height, Double brainWeight, String hairColour, int numberOfLungs, boolean isScientific, String eyeColour) {
        super(species, numberOfLegs, hasATail, moveSpeed, habitat, weight, height, brainWeight, hairColour, numberOfLungs);
        this.isScientific = isScientific;
        this.eyeColour = eyeColour;
    }


    public boolean isScientific() {
        return isScientific;
    }

    public void setScientific(boolean scientific) {
        isScientific = scientific;
    }

    public String getEyeColour() {
        return eyeColour;
    }

    public void setEyeColour(String eyeColour) {
        this.eyeColour = eyeColour;
    }
}

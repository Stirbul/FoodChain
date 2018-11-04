package com.stirbul.app.Animals.Mammal;

import com.stirbul.app.AdditionalClasses.Predator;
import com.stirbul.app.Animals.Animal;
import com.stirbul.app.AdditionalClasses.Pray;

public class Wolf extends Mammal {
    private int numberOfEyes;

    public static class Builder extends Mammal.Builder{
        private int numberOfEyes;

        public Builder(String species){
            super(species);
        }

        public Builder numberOfEyes(int numberOfEyes){
            this.numberOfEyes = numberOfEyes;
            return this;
        }

//        @Override
//        public Builder brainWeight(Double brainWeight) {
//            return brainWeight(brainWeight);
//        }

        @Override
        public Builder hairColour(String hairColour) {
            return hairColour(hairColour);
        }

        @Override
        public Builder numberOfLungs(int numberOfLungs) {
            return numberOfLungs(numberOfLungs);
        }

        @Override
        public Builder numberOfLegs(int numberOfLegs) {
            return numberOfLegs(numberOfLegs);
        }

        @Override
        public Builder hasATail(boolean hasATail) {
            return hasATail(hasATail);
        }

        @Override
        public Builder moveSpeed(int moveSpeed) {
            return moveSpeed(moveSpeed);
        }

        @Override
        public Builder habitat(String habitat) {
            return habitat(habitat);
        }

        @Override
        public Builder weight(Double weight) {
            return weight(weight);
        }

        @Override
        public Builder height(Double height) {
            return height(height);
        }

        @Override
        public Wolf build() {
            return new Wolf(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    protected Wolf(Builder builder){
        super(builder);
        this.numberOfEyes = builder.numberOfEyes;
    }

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

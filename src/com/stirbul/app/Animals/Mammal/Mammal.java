package com.stirbul.app.Animals.Mammal;

import com.stirbul.app.Animals.Animal;

public class Mammal extends Animal {
    private Double brainWeight;
    private String hairColour;
    private int numberOfLungs = 2;

    protected abstract static class Init<T extends Init<T>> extends Animal.Init<T>{
        private Double brainWeight;
        private String hairColour;
        private int numberOfLungs = 2;

        Init(String species){
            super(species);
        }

        public T brainWeight(Double brainWeight){
            this.brainWeight = brainWeight;
            return self();
        }

        public T hairColour(String hairColour){
            this.hairColour = hairColour;
            return self();
        }

        public T numberOfLungs(int numberOfLungs){
            this.numberOfLungs = numberOfLungs;
            return self();
        }

        @Override
        public Mammal build() {
            return new Mammal(this);
        }
    }

    public static class Builder extends Init<Builder>{

        public Builder(String species){
            super(species);
        }
        @Override
        protected Builder self() {
            return this;
        }
    }

    protected Mammal(Init<?> init){
        super(init);
        this.brainWeight = init.brainWeight;
        this.hairColour = init.hairColour;
        this.numberOfLungs = init.numberOfLungs;
    }

    //------------------------------
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

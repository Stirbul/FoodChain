package com.stirbul.app.Animals;

import com.stirbul.app.AdditionalClasses.Pray;
import com.stirbul.app.AdditionalClasses.Predator;


public abstract class Animal {
    private String species;
    private int numberOfLegs;
    private boolean hasATail;
    private int moveSpeed;
    private String habitat;
    private Double weight;
    private Double height;
    private Pray pray = new Pray();
    private Predator predator = new Predator();


    protected abstract static class Builder<T extends Builder<T>>{
        private String species;
        private int numberOfLegs;
        private boolean hasATail;
        private int moveSpeed;
        private String habitat;
        private Double weight;
        private Double height;

        public Builder(String species){
            this.species = species;
        }

        public T numberOfLegs(int numberOfLegs){
            this.numberOfLegs = numberOfLegs;
            return self();
        }

        public T hasATail(boolean hasATail){
            this.hasATail = hasATail;
            return self();
        }

        public T moveSpeed(int moveSpeed){
            this.moveSpeed = moveSpeed;
            return self();
        }

        public T habitat(String habitat){
            this.habitat = habitat;
            return self();
        }

        public T weight(Double weight){
            this.weight = weight;
            return self();
        }

        public T height(Double height){
            this.height = height;
            return self();
        }

        protected abstract T self();
        public abstract Animal build();
    }

    protected Animal(Builder<?> builder){
        species = builder.species;
        numberOfLegs = builder.numberOfLegs;
        hasATail = builder.hasATail;
        moveSpeed = builder.moveSpeed;
        habitat = builder.habitat;
        weight = builder.weight;
        height = builder.height;
    }



//    public Animal() {
//    }

    public Animal(String species, int numberOfLegs, boolean hasATail, int moveSpeed,
                  String habitat, Double weight, Double height) {
        this.species = species;
        this.numberOfLegs = numberOfLegs;
        this.hasATail = hasATail;
        this.moveSpeed = moveSpeed;
        this.habitat = habitat;
        this.weight = weight;
        this.height = height;
    }

    public Animal(String species, int numberOfLegs, boolean hasATail,
                  int moveSpeed, String habitat,
                  Double weight, Double height, Pray pray, Predator predator) {
        this.species = species;
        this.numberOfLegs = numberOfLegs;
        this.hasATail = hasATail;
        this.moveSpeed = moveSpeed;
        this.habitat = habitat;
        this.weight = weight;
        this.height = height;
        this.pray = pray;
        this.predator = predator;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    public boolean isHasATail() {
        return hasATail;
    }

    public void setHasATail(boolean hasATail) {
        this.hasATail = hasATail;
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Pray getPray() {
        return pray;
    }

    public void setPray(Pray pray) {
        this.pray = pray;
    }

    public void setPray(Animal... prayArray) {
        this.pray.prayOf(prayArray);
    }

    public Predator getPredator() {
        return predator;
    }

    public void setPredator(Predator predator) {
        this.predator = predator;
    }

    public void setPredator(Animal... predatorArray) {
        this.predator.predatorOf(predatorArray);
    }

    protected void move(){
        System.out.println("com.stirbul.app.Animals.Animal is moving with unknown speed");
    }

    protected void move(int moveSpeed){
        this.moveSpeed =  moveSpeed;
        System.out.println("com.stirbul.app.Animals.Animal is mooving with " + this.moveSpeed);
    }

}

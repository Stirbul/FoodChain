package com.stirbul.app.Animals;

import com.stirbul.app.AdditionalClasses.Pray;
import com.stirbul.app.AdditionalClasses.Predator;


public class Animal {
    private String species;
    private int numberOfLegs;
    private boolean hasATail;
    private int moveSpeed;
    private String habitat;
    private Double weight;
    private Double height;
    private Pray pray;
    private Predator predator;

    protected abstract static class Init<T extends Init<T>>{
        private String species;
        private int numberOfLegs;
        private boolean hasATail;
        private int moveSpeed;
        private String habitat;
        private Double weight;
        private Double height;
        private Pray pray;
        private Predator predator;

        public Init(String species){
            this.species = species;
            pray = new Pray();
            predator = new Predator();
        }

        public T pray(Animal... prayArray){
            this.pray.prayOf(prayArray);
            return self();
        }

        public T predator(Animal... predatorArray){
            this.predator.predatorOf(predatorArray);
            return self();
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

        public Animal build(){
            return new Animal(this);
        }

        protected abstract T self();
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

    protected Animal(Init<?> init){
        species = init.species;
        numberOfLegs = init.numberOfLegs;
        hasATail = init.hasATail;
        moveSpeed = init.moveSpeed;
        habitat = init.habitat;
        weight = init.weight;
        height = init.height;
        predator = init.predator;
        pray = init.pray;
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

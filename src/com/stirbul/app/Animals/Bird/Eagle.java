package com.stirbul.app.Animals.Bird;

public class Eagle extends Bird {
    private int vision;
    private int divingSpeed;

    public static class Builder extends Bird.Init<Builder>{
        private int vision;
        private int divingSpeed;

        public Builder(String species){
            super(species);
        }

        public Builder vision(int vision){
            this.vision = vision;
            return self();
        }

        public Builder divingSpeed(int divingSpeed){
            this.divingSpeed = divingSpeed;
            return self();
        }

        @Override
        public Eagle build() {
            return new Eagle(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private Eagle(Builder builder){
        super(builder);
        this.vision = builder.vision;
        this.divingSpeed = builder.divingSpeed;
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

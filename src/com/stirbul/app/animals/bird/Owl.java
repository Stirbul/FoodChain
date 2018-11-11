package com.stirbul.app.animals.bird;

public class Owl extends Bird {
    private String headRotate;
    private boolean eyesMotion;

    public static class Builder extends Bird.Init<Builder>{
        private String headRotate;
        private boolean eyesMotion;

        public Builder(String species){
            super(species);
        }

        public Builder headRotate(String headRotate){
            this.headRotate = headRotate;
            return self();
        }

        public Builder eyesMotion(boolean eyesMotion){
            this.eyesMotion = eyesMotion;
            return self();
        }

        @Override
        public Owl build() {
            return new Owl(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private Owl(Builder builder){
        super(builder);
        this.headRotate = builder.headRotate;
        this.eyesMotion = builder.eyesMotion;
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

package com.stirbul.app.animals.bird;

import com.stirbul.app.animals.Animal;

public class Bird extends Animal {
    private Double flyHeight;
    private Double wingSpread;
    private String formOfBeak;

    protected abstract static class Init<T extends Init<T>> extends Animal.Init<T>{
        private Double flyHeight;
        private Double wingSpread;
        private String formOfBeak;

        Init(String species){
            super(species);
        }

        public T flyHeight(Double flyHeight){
            this.flyHeight = flyHeight;
            return self();
        }

        public T wingSpread(Double wingSpread){
            this.wingSpread = wingSpread;
            return self();
        }

        public T formOfBeak(String formOfBeak){
            this.formOfBeak = formOfBeak;
            return self();
        }

        @Override
        public Bird build() {
            return new Bird(this);
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

    protected Bird(Init<?> init){
        super(init);
        this.flyHeight = init.flyHeight;
        this.formOfBeak = init.formOfBeak;
        this.wingSpread = init.wingSpread;

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

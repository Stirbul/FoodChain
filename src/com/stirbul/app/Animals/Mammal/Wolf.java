package com.stirbul.app.Animals.Mammal;

public class Wolf extends Mammal {
    private int numberOfEyes;

    public static class Builder extends Mammal.Init<Builder>{
        private int numberOfEyes;

        public Builder(String species){
            super(species);
        }

        public Wolf.Builder numberOfEyes(int numberOfEyes){
            this.numberOfEyes = numberOfEyes;
            return self();
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

    private Wolf(Builder builder){
        super(builder);
        this.numberOfEyes = builder.numberOfEyes;
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

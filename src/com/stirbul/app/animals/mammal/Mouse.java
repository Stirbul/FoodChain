package com.stirbul.app.animals.mammal;

public class Mouse extends Mammal {
    private boolean isScientific;
    private String eyeColour;

    public static class Builder extends Mammal.Init<Builder>{
        private boolean isScientific;
        private String eyeColour;

        public Builder(String species) {
            super(species);
        }

        public Mouse.Builder isScientific(boolean isScientific){
            this.isScientific = isScientific;
            return self();
        }

        public Mouse.Builder eyeColour(String eyeColour){
            this.eyeColour = eyeColour;
            return self();
        }

        @Override
        public Mouse build() {
            return new Mouse(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private Mouse(Builder builder){
        super(builder);
        this.isScientific = builder.isScientific;
        this.eyeColour = builder.eyeColour;
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

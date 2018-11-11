package com.stirbul.app.animals.mammal;

public class Fox extends Mammal {
    private String agilityLevel;

    public static class Builder extends Mammal.Init<Builder>{
        private String agilityLevel;

        public Builder(String species){
            super(species);
        }

        public Builder agilityLevel(String agilityLevel){
            this.agilityLevel = agilityLevel;
            return self();
        }

        @Override
        public Fox build() {
            return new Fox(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private Fox(Builder builder){
        super(builder);
        this.agilityLevel = builder.agilityLevel;
    }

    public String getAgilityLevel() {
        return agilityLevel;
    }

    public void setAgilityLevel(String agilityLevel) {
        this.agilityLevel = agilityLevel;
    }
}

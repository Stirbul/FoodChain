package com.stirbul.app.Animals.Mammal;

public class Elk extends Mammal{
    private boolean hasHorns;
    private int hornSize;

    public static class Builder extends Mammal.Init<Builder>{

        private boolean hasHorns;
        private int hornSize;

        public Builder(String species){
            super(species);
        }

        public Builder hasHorns(boolean hasHorns){
            this.hasHorns = hasHorns;
            return self();
        }

        public Builder hornSize(int hornSize){
            this.hornSize = hornSize;
            return self();
        }

        @Override
        public Elk build() {
            return new Elk(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private Elk(Builder builder){
        super(builder);
        this.hornSize = builder.hornSize;
        this.hasHorns = builder.hasHorns;
    }

    public boolean isHasHorns() {
        return hasHorns;
    }

    public void setHasHorns(boolean hasHorns) {
        this.hasHorns = hasHorns;
    }

    public int getHornSize() {
        return hornSize;
    }

    public void setHornSize(int hornSize) {
        this.hornSize = hornSize;
    }
}

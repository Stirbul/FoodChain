package com.stirbul.app.Animals.Bird;

public class Pigeon extends Bird {
    private Double distancePerDay;
    private boolean canSitOnBranch;

    public static class Builder extends Bird.Init<Builder>{
        private Double distancePerDay;
        private boolean canSitOnBranch;

        public Builder(String species){
            super(species);
        }

        public Builder distancePerDay(Double distancePerDay){
            this.distancePerDay = distancePerDay;
            return self();
        }

        public Builder canSitOnBranch(boolean canSitOnBranch){
            this.canSitOnBranch = canSitOnBranch;
            return self();
        }

        @Override
        public Pigeon build() {
            return new Pigeon(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private Pigeon(Builder builder){
        super(builder);
        this.distancePerDay = builder.distancePerDay;
        this.canSitOnBranch = builder.canSitOnBranch;
    }

    public Double getDistancePerDay() {
        return distancePerDay;
    }

    public void setDistancePerDay(Double distancePerDay) {
        this.distancePerDay = distancePerDay;
    }

    public boolean isCanSitOnBranch() {
        return canSitOnBranch;
    }

    public void setCanSitOnBranch(boolean canSitOnBranch) {
        this.canSitOnBranch = canSitOnBranch;
    }
}

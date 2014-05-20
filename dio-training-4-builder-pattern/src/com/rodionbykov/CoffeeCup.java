package com.rodionbykov;

/**
 * Created by Rodion Bykov on 24.04.2014. implements Drinkable
 */
public class CoffeeCup  {

    private final CoffeeType coffeeType;
    private final int sugar;
    private final int volume;

    private CoffeeCup(Builder builder) {
        this.coffeeType = builder.coffeeType;
        this.sugar = builder.sugar;
        this.volume = builder.volume;
    }

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    public int getSugar() { return this.sugar; }

    public int getVolume() { return volume; }

    /*
    public CoffeeCup refill(int sugar, int volume){

    }

    public CoffeeCup drink(int volume){

    }

    public CoffeeCup empty(){

    }
     */

    public static class Builder {

        private CoffeeType coffeeType;
        private int sugar;
        private int volume;

        public Builder() {

        }

        public Builder(CoffeeCup original) {
            this.coffeeType = original.coffeeType;
            this.sugar = original.sugar;
            this.volume = original.volume;
        }

        public Builder coffeeType(CoffeeType coffeeType) {
            this.coffeeType = coffeeType;
            return this;
        }

        public Builder sugar(int sugar) {
            this.sugar = sugar;
            return this;
        }

        public Builder volume(int volume) {
            this.volume = volume;
            return this;
        }

        public CoffeeCup build() {
            return new CoffeeCup(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoffeeCup coffeeCup = (CoffeeCup) o;

        if (coffeeType != coffeeCup.coffeeType) return false;
        if (sugar != coffeeCup.sugar) return false;
        if (volume != coffeeCup.volume) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = coffeeType != null ? coffeeType.hashCode() : 0;
        result = 31 * result + sugar;
        return result;
    }

    @Override
    public String toString() {
        return "CoffeeCup{" +
                "coffeeType=" + coffeeType +
                ", sugar=" + sugar +
                ", volume=" + volume +
                '}';
    }
}

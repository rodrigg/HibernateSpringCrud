package com.rodionbykov;

/**
 * Created by Rodion Bykov on 24.04.2014.
 */
public class CoffeeCup implements Drinkable {

    private CoffeeType coffeeType;
    private int sugar;
    private int volume;

    public CoffeeCup(CoffeeType coffeeType, int sugar, int volume) {
        this.coffeeType = coffeeType;
        this.sugar = sugar;
        this.volume = volume;
    }

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(CoffeeType coffeeType) {
        this.coffeeType = coffeeType;
    }

    public int getVolume() { return volume; }

    public void setVolume(int volume) { this.volume = volume; }

    public void refill(int sugar, int volume){
        this.sugar += sugar;
        this.volume += volume;
    }

    public void drink(int volume){
        this.volume -= volume;
    }

    public void empty(){
        this.volume = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoffeeCup coffeeCup = (CoffeeCup) o;

        if (sugar != coffeeCup.sugar) return false;
        if (coffeeType != coffeeCup.coffeeType) return false;

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

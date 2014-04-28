package com.rodionbykov;

/**
 * Created by Rodion Bykov on 24.04.2014.
 */
public class TeaCup implements Drinkable {

    private TeaType teaType;
    private int sugar;
    private int volume;

    public TeaCup(TeaType teaType, int sugar, int volume) {
        this.teaType = teaType;
        this.sugar = sugar;
        this.volume = volume;
    }

    public TeaType getTeaType() {
        return teaType;
    }

    public void setTeaType(TeaType teaType) {
        this.teaType = teaType;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

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

        TeaCup teaCup = (TeaCup) o;

        if (sugar != teaCup.sugar) return false;
        if (volume != teaCup.volume) return false;
        if (teaType != teaCup.teaType) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = teaType != null ? teaType.hashCode() : 0;
        result = 31 * result + sugar;
        result = 31 * result + volume;
        return result;
    }

    @Override
    public String toString() {
        return "TeaCup{" +
                "teaType=" + teaType +
                ", sugar=" + sugar +
                ", volume=" + volume +
                '}';
    }
}

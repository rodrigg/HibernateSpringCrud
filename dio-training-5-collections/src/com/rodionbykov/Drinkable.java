package com.rodionbykov;

/**
 * Created by Rodion Bykov on 24.04.2014.
 */
public interface Drinkable {

    public void refill(int sugar, int volume);
    public void drink(int volume);
    public void empty();

}

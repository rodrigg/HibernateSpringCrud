import com.rodionbykov.CoffeeCup;
import com.rodionbykov.CoffeeType;

import org.junit.Test;

/**
 * Created by Rodion Bykov on 07.05.2014.
 */
public class CoffeeCupTest {

    private CoffeeCup tallCappuccino = new CoffeeCup.Builder().coffeeType(CoffeeType.CAPPUCCINO).sugar(2).volume(250).build();
    private CoffeeCup largeCappuccino = new CoffeeCup.Builder().coffeeType(CoffeeType.CAPPUCCINO).sugar(2).volume(200).build();
    private CoffeeCup smallCappuccino = new CoffeeCup.Builder().coffeeType(CoffeeType.CAPPUCCINO).sugar(1).volume(100).build();
    private CoffeeCup tallLatte = new CoffeeCup.Builder().coffeeType(CoffeeType.LATTE).sugar(2).volume(250).build();
    private CoffeeCup largeLatte = new CoffeeCup.Builder().coffeeType(CoffeeType.LATTE).sugar(2).volume(200).build();
    private CoffeeCup smallLatte = new CoffeeCup.Builder().coffeeType(CoffeeType.LATTE).sugar(1).volume(100).build();
    private CoffeeCup espresso = new CoffeeCup.Builder().coffeeType(CoffeeType.BLACK).sugar(1).volume(50).build();
    private CoffeeCup doubleEspresso = new CoffeeCup.Builder().coffeeType(CoffeeType.BLACK).sugar(2).volume(100).build();

    @Test
    public void mergeTest(){

    }

}

package ingredients.meats;

import mainClasses.Money;

/**
 * Subclass of Meat, represents a
 * sausage topping for a Pizza
 *
 * @author Kylun Robbins
 */
public class Sausage extends Meat {
    public static final String description = "Sausage";
    public static final Money cost = new Money(1, 25);
    public static final int calories = 150;

    /**
     * Constructor for Sausage, calls
     * Meat's constructor to set
     * values for description, cost,
     * and calories of Sausage
     */
    public Sausage() {
        super(description, cost, calories);
    }

}

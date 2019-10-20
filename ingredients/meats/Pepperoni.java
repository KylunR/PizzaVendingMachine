package ingredients.meats;

import mainClasses.Money;

/**
 * Subclass of Meat, represents a
 * pepperoni topping for a Pizza
 *
 * @author Kylun Robbins
 */
public class Pepperoni extends Meat {
    public static final String description = "Pepperoni";
    public static final Money cost = new Money(1, 0);
    public static final int calories = 100;

    /**
     * Constructor for Pepperoni,
     * calls Meat's constructor to set
     * values for description, cost,
     * and calories of Pepperoni
     */
    public Pepperoni() {
        super(description, cost, calories);
    }
}

package ingredients.cheeses;

import mainClasses.Money;

/**
 * Subclass of Cheese, class represents
 * a Mozzarella cheese topping for a Pizza
 *
 * @author Kylun Robbins
 */
public class Mozzarella extends Cheese {
    public static final String description = "Mozzarella";
    public static final Money cost = new Money(2, 0);
    public static final int calories = 100;

    /**
     * Constructor for Mozzarella,
     * calls Cheese's constructor to
     * set values for description, cost,
     * and calories
     */
    public Mozzarella() {
        super(description, cost, calories);
    }
}

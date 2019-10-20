package ingredients.cheeses;

import mainClasses.Money;

/**
 * Subclass of Cheese, class represents
 * a Goat cheese topping for a pizza
 *
 * @author Kylun Robbins
 */
public class Goat extends Cheese {
    public static final String description = "Goat cheese";
    public static final Money cost = new Money(3, 0);
    public static final int calories = 150;

    /**
     * Constructor for Goat, calls
     * Cheese's constructor to set
     * values for description, cost,
     * and calories
     */
    public Goat() {
        super(description, cost, calories);
    }
}

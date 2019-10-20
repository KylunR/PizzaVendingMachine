package ingredients.bases;

import mainClasses.Money;

/**
 * Subclass of Base, class represents
 * a Marinara sauce/base for a pizza
 *
 * @author Kylun Robbins
 */
public class Marinara extends Base{
    public static final String description = "Marinara sauce";
    public static final Money cost = new Money(0, 50);
    public static final int calories = 100;

    /**
     * Constructor for Marinara,
     * calls Base's constructor to
     * set values for description,
     * cost, and calories
     */
    public Marinara() {
        super(description, cost, calories);
    }
}

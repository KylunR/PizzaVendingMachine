package ingredients.bases;

import mainClasses.Money;

/**
 * Subclass of Base, class represents
 * an Alfredo sauce/base for a pizza
 *
 * @author Kylun Robbins
 */
public class Alfredo extends Base {
    public static final String description = "Alfredo sauce";
    public static final Money cost = new Money(1, 50);
    public static final int calories = 125;

    /**
     * Constructor for Alfredo,
     * calls Base's constructor to
     * set values for description,
     * cost, and calories
     */
    public Alfredo() {
        super(description, cost, calories);
    }
}

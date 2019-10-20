package ingredients.vegetables;

import mainClasses.Money;

import java.awt.*;

/**
 * Subclass of Vegetable, class represents
 * a olive topping for a pizza
 *
 * @author Kylun Robbins
 */
public class Olive extends Vegetable {
    public static final String description = "Olive";
    public static final Money cost = new Money(0, 75);
    public static final int calories = 100;

    /**
     * Constructor for Olive, that calls
     * Vegetable's constructor to set
     * description, cost, calories, and color
     */
    public Olive() {
        super(description, cost, calories, Color.black);
    }

}

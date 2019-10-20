package ingredients.vegetables;

import mainClasses.Money;

import java.awt.*;

/**
 * Subclass of Vegetable, class represents
 * a pepper topping for a pizza
 *
 * @author Kylun Robbins
 */
public class Pepper extends Vegetable {
    public static final String description = "Pepper";
    public static final Money cost = new Money(1, 0);
    public static final int calories = 50;

    /**
     * Constructor for Pepper, that calls
     * Vegetable's constructor to set
     * description, cost, calories, and color
     */
    public Pepper() {
        super(description, cost, calories, Color.red);
    }
}

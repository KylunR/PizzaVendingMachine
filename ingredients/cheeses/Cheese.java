package ingredients.cheeses;

import ingredients.Ingredient;
import mainClasses.Money;

/**
 * Cheese class is a subclass of Ingredient,
 * and will be a parent class to different
 * types of cheeses
 *
 * @author Kylun Robbins
 */
public class Cheese extends Ingredient {

    /**
     * Constructor for a Cheese object, calls
     * Ingredient's constructor
     *
     * @param newDescription - description of cheese
     * @param newCost        - cost of cheese
     * @param newCalories    - calories of cheese
     */
    public Cheese(String newDescription, Money newCost, int newCalories) {
        super(newDescription, newCost, newCalories);
    }
}

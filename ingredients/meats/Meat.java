package ingredients.meats;

import ingredients.Ingredient;
import mainClasses.Money;

/**
 * Meat class is a subclass of Ingredient, and
 * will be a parent class for different types
 * of Meat ingredients
 *
 * @author Kylun Robbins
 */
public class Meat extends Ingredient {

    /**
     * Constructor for Meat, calls
     * Ingredient's constructor
     *
     * @param newDescription - description of meat
     * @param newCost        - cost of meat
     * @param newCalories    - calories of meat
     */
    public Meat(String newDescription, Money newCost, int newCalories) {
        super(newDescription, newCost, newCalories);
    }
}

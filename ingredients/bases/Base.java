package ingredients.bases;

import ingredients.Ingredient;
import mainClasses.Money;

/**
 * Base class is a subclass of Ingredient,
 * and will be a parent class to different
 * types of bases for a Pizza, uses Ingredient's
 * constructor to define each base as an ingredient
 *
 * @author Kylun Robbins
 * @version 06/06/2019
 */
public class Base extends Ingredient {

    /**
     * Constructor for a pizza Base,
     * calls Ingredient's constructor
     *
     * @param newDescription - new description for base
     * @param newCost        - new cost for base
     * @param newCalories    - new calorie amount for base
     */
    public Base(String newDescription, Money newCost, int newCalories) {
        super(newDescription, newCost, newCalories);
    }
}

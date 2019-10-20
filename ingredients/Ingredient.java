package ingredients;

import mainClasses.Money;

/**
 * Abstract class that defines what an ingredient
 * must have in their class, will be a parent class
 * to different categories of ingredients
 *
 * @author Kylun Robbins
 */
public abstract class Ingredient implements Comparable{
    public final String description;
    public final Money cost;
    public final int calories;

    /**
     * Constructor for an ingredient
     *
     * @param newDescription - description for ingredient
     * @param newCost        - cost of ingredient
     * @param newCalories    - calorie amount of ingredient
     */
    public Ingredient(String newDescription, Money newCost, int newCalories) {
        description = newDescription;
        cost = newCost;
        calories = newCalories;
    }

    /**
     * Getter for cost
     * @return Money object
     */
    public Money getCost() {
        return new Money(cost);
    }

    /**
     * Getter for calories
     * @return int
     */
    public int getCalories() {
        return calories;
    }

    /**
     * Getter for description
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * compareTo method calls Money's
     * compare to method that compares
     * based on cost
     *
     * @param o - Object to compare
     * @return int
     */
    @Override
    public int compareTo(Object o) {
        return cost.compareTo(o);
    }

    /**
     * toString returns a String representation
     * of an ingredient including description,
     * cost, and calories
     * @return String
     */
    public String toString() {
        return "Description: " + getDescription() + ", Cost: " + getCost() + ", Calories: " + getCalories();
    }

    /**
     * Equals method compares two Ingredients
     * and returns true if equal and false if
     * they are not equal
     *
     * @param o - Object to compare
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if(o == null || !(o instanceof Ingredient)) {   // If argument is null or not an ingredient
            return false;                               // Cannot be equal, return false
        }
        Ingredient that = (Ingredient)o;
        return this.getDescription().equals(that.getDescription()) && this.getCost() == that.getCost()
                && this.getCalories() == that.getCalories();
    }
}

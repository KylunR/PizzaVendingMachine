package ingredients.vegetables;

import ingredients.Ingredient;
import mainClasses.Money;

import java.awt.*;

/**
 * Vegetable is a subclass of Ingredient,
 * and will be a parent class to different
 * vegetable toppings for Pizza, Vegetable
 * also adds a new color characteristic to
 * Vegetable ingredients
 *
 * @author Kylun Robbins
 */
public class Vegetable extends Ingredient {
    private Color myColor;

    /**
     * Constructor for an ingredient,
     * that sets the description, cost,
     * and calories for the ingredient
     *
     * @param newDescription - description of vegetable
     * @param newCost        - cost of vegetable
     * @param newCalories    - calories of vegetable
     */
    public Vegetable(String newDescription, Money newCost, int newCalories) {
        super(newDescription, newCost, newCalories);
    }

    /**
     * Constructor that sets description,
     * cost, and calories by calling the super
     * class's constructor and takes a input for
     * color of the vegetable
     *
     * @param newDescription - description of vegetable
     * @param newCost        - cost of vegetable
     * @param newCalories    - calories of vegetable
     * @param newColor       - color of vegetable
     */
    public Vegetable(String newDescription, Money newCost, int newCalories, Color newColor) {
        super(newDescription, newCost, newCalories);
        setMyColor(newColor);
    }

    /**
     * Getter for Color
     * @return Color object
     */
    public Color getMyColor(){
        return new Color(myColor.getRGB());
    }

    /**
     * Setter for Color
     * @param myColor - new color for vegetable
     */
    public void setMyColor(Color myColor) {
        myColor = new Color(myColor.getRGB());
    }

    /////////////////
    /**
     * To String returns a String representation
     * of the ingredient's information including color
     * @return String
     */
    public String toString() {
        return super.toString();
    }

    /**
     * Equals method that calls Ingredient's
     * to compare two Vegetable's description,
     * cost, and calories, in addition this method
     * compares color
     * @param o - Object to compare
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if(o == null || !(o instanceof Vegetable)) {    // If argument is null or not an ingredient
            return false;                               // Cannot be equal, return false
        }
        Vegetable that = (Vegetable)o;
        return super.equals(o) && this.getMyColor() == that.getMyColor();
    }
}

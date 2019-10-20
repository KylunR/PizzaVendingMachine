package mainClasses;

import ingredients.Ingredient;
import ingredients.bases.Alfredo;
import ingredients.bases.Marinara;
import ingredients.cheeses.Goat;
import ingredients.cheeses.Mozzarella;
import ingredients.meats.Pepperoni;
import ingredients.meats.Sausage;
import ingredients.vegetables.Olive;
import ingredients.vegetables.Pepper;
import mainClasses.shapes.Circle;
import mainClasses.shapes.Shape;
import mainClasses.shapes.Square;
import mainClasses.timeStamp.Date;
import mainClasses.timeStamp.TimeStamp;
import java.util.Random;

/**
 * Class represents a Pizza Object, which
 * holds values for ingredients, calories,
 * cost, Shape, remaining pizza, and date made,
 * this class implements PizzaComparable to compare
 * pizzas by different conditions
 *
 * @author Kylun Robbins
 * @version 06/06/2019
 */
public class Pizza implements PizzaComparable {
	private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
	private int calories = 0;
	private Money cost = new Money(0, 0);
	private Shape myShape;
	private Fraction remainingPizza = new Fraction(1, 1);
	private TimeStamp dateMade;

	public Pizza() { 
		Random random = new Random();

		// Using random to choose shape
		if(random.nextInt(2) == 0) {
			setShape(new Circle());
		} else {
			setShape(new Square());
		}

		// Using random to choose base
		if(random.nextInt(2) == 0) {
			addIngredient(new Alfredo());
		} else {
			addIngredient(new Marinara());
		}

		// Using random to choose cheese
		if(random.nextInt(2) == 0) {
			addIngredient(new Mozzarella());
		} else {
			addIngredient(new Goat());
		}

		// Using random to choose meat
		if(random.nextInt(2) == 0) {
			addIngredient(new Pepperoni());
		} else {
			addIngredient(new Sausage());
		}

		// Using random to choose vegetables
		if(random.nextInt(2) == 0) {
			addIngredient(new Olive());
		} else {
			addIngredient(new Pepper());
		}

		dateMade = new TimeStamp(PizzaManager.getCurrentDate(), PizzaManager.getCurrentTime());
	}

	/**
	 * Adds argument ingredient to the
	 * ingredients list, then updates cost
	 * and total calories to reflect the
	 * addition of the new ingredient
	 * @param newIngredient - Ingredient to add to Pizza
	 */
	public void addIngredient(Ingredient newIngredient) {
		ingredients.insert(newIngredient);
		calories += newIngredient.getCalories();
		cost.add(newIngredient.cost);
	}

	/**
	 * This method subtracts how much
	 * Pizza the customer is eating from
	 * the remaining Pizza, throws an exception
	 * if they try to eat more than what is
	 * remaining
	 *
	 * @param amt - amount to be taken from remaining pizza
	 */
	public void eatSomePizza(Fraction amt) {
		if(amt.getNumerator() < 0) {												// If amount is negative
			throw new PizzaException("Cannot eat a negative amount");				// throw exception
		}

		int x = remainingPizza.getNumerator() * amt.getDenominator();				// Cross multiply to find out how much
		int y = remainingPizza.getDenominator() * amt.getNumerator();				// to subtract

		if(x - y < 0) {																// If amount to eat is larger than remaining
			throw new PizzaException("Cannot eat more than what is remaining");		// throw an exception
		}

		this.remainingPizza = new Fraction(x - y, 						// Set remaining pizza to original - amount to eat
						remainingPizza.getDenominator() * amt.getDenominator());
	}

	/**
	 * Getter for the Date the
	 * pizza was made
	 * @return Date object
	 */
	public Date getMadeDate() {
		return new Date(dateMade);
	}

	/**
	 * Getter for the remaining
	 * amount of pizza left
	 * @return Fraction object
	 */
	public Fraction getRemainingFraction() {
		return new Fraction(remainingPizza);
	}

	/**
	 * Returns the remaining area of the
	 * current Pizza
	 * @return double
	 */
	public double getRemainingArea() {
		return myShape.getArea() * ((double)remainingPizza.getNumerator() / (double)remainingPizza.getDenominator());
	}

	/**
	 * Getter for total calories
	 * on the pizza
	 * @return int
	 */
	public int getCalories() {
		return calories;
	}

	/**
	 * Getter for total cost
	 * of the pizza
	 * @return int
	 */
	public Money getCost() {
		return new Money(cost);
	}

	/**
	 * Setter for myShape, either
	 * a Square or Circle
	 * @param s - new Shape for pizza
	 */
	public void setShape(Shape s) {
		myShape = (Shape) s.clone();
	}

	/**
	 * Getter for myShape
	 * @return Shape
	 */
	public Shape getShape() {
		return (Shape) myShape.clone();
	}

	/**
	 * To String method that return a
	 * String representation of the
	 * information of the current Pizza
	 * object, including the date made,
	 * shape, cost, calories, ingredients,
	 * and pizza remaining.
	 * @return String
	 */
	public String toString() {
		return "Date Pizza Was Made: " + getMadeDate() +
				"\nShape: " + getShape().toString() + "\nCalories: " + getCalories() +
				"\nCost: " + cost.toString() + "\nIngredients:\n" + ingredients.toString()
				+ "Pizza Remaining: " + remainingPizza + "\nRemaining Area: " + getRemainingArea()
				+"\n";
	}

	/**
	 * Compare to method that compares
	 * the current Pizza object to the
	 * input by cost, returns a positive
	 * integer if current is larger than
	 * input, zero if equal, and negative
	 * if the current is cheaper
	 * @param o	- Object to compare
	 * @return int
	 */
	@Override
	public int compareTo(Object o) {
		if(o == null || !(o instanceof Pizza)) {
			throw new PizzaException("Input is null or not a Pizza.");
		}
		Pizza that = (Pizza)o;
		return (int) ((this.cost.getMoney() * 100) - (that.cost.getMoney() * 100));
	}

	/**
	 * Compares two pizzas by size remaining of
	 * the pizza, by calling Fraction's compareTo
	 * method, returns a positive integer if the
	 * original pizza is larger than the argument,
	 * returns zero if equal, and negative if less
	 * than
	 *
	 * @param o - Pizza object to compare
	 * @return int
	 */
	@Override
	public int compareToBySize(Object o) {
		if(o == null || !(o instanceof Pizza)) {
			throw new PizzaException("Input is null or not a Pizza.");
		}
		Pizza that = (Pizza)o;
		return (int)this.getRemainingArea() - (int)that.getRemainingArea();
	}

	/**
	 * Compares two pizzas by calories,
	 * returns a positive if original has
	 * more calories than the argument,
	 * returns zero if they have the same
	 * amount of calories, and negative if
	 * the argument has more calories
	 *
	 * @param o - Pizza Object to compare
	 * @return int
	 */
	@Override
	public int compareToByCalories(Object o) {
		if(o == null || !(o instanceof Pizza)) {
			throw new PizzaException("Input is null or not a Pizza.");
		}
		Pizza that = (Pizza)o;
		return this.getCalories() - that.getCalories();
	}
}

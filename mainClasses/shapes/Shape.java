package mainClasses.shapes;

import java.awt.*;

/**
 * Shape superclass the holds values for
 * the x-position, y-position, and the Color
 * of the Shape
 *
 * @author Kylun Robbins
 * @version 06/01/19
 */
public abstract class Shape implements Cloneable {
	private int x = 0;
	private int y = 0;
	private Color myColor;

	/**
	 * Constructor to set the values of
	 * x, y, and myColor
	 *
	 * @param newX - new value for x
	 * @param newY - new value for y
	 * @param newColor - new value for myColor
	 */
	public Shape(int newX, int newY, Color newColor) {
		setX(newX);
		setY(newY);
		setMyColor(newColor);
	}

	/**
	 * Clone method that returns
	 * a copy of the current Object
	 * @return Object
	 */
	public abstract Object clone();

	/**
	 * Get area method to be overrode
	 * by classes that extend Shape
	 * @return double
	 */
	public abstract double getArea();

	public abstract String toString();

	/**
	 * Draw method to be overrode
	 * by classes the extend Shape
	 * @param g - Graphics
	 */
	public void draw(Graphics g){

	}

	/**
	 * Getter for x-position
	 * @return int
	 */
	public int getX() {
		return x;
	}

	/**
	 * Getter for y-postiion
	 * @return int
	 */
	public int getY() {
		return y;
	}

	/**
	 * Getter for myColor, ensures
	 * there is no privacy leak
	 * @return Color
	 */
	public Color getMyColor() {
		return new Color(myColor.getRGB());
	}

	/**
	 * Setter for x
	 * @param newX - new value for x
	 */
	public void setX(int newX) {
		x = newX;
	}

	/**
	 * Setter for y
	 * @param newY - new value for y
	 */
	public void setY(int newY) {
		y = newY;
	}

	/**
	 * Setter for myColor
	 * @param newColor - new Color for myColor
	 */
	public void setMyColor(Color newColor) {
		myColor = new Color(newColor.getRGB());
	}
}
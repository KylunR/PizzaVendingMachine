package mainClasses.shapes;

import java.awt.*;

/**
 * Subclass of Shape, that represents a
 * Circle, Circle holds a value of radius
 *
 * @author Kylun Robbins
 * @version 06/01/19
 */
public class Circle extends Shape{
    private int radius;

    /**
     * Constructor that calls the super class's
     * constructor to set x and y position and
     * Color, this constructor also sets the radius
     * of the cirlce
     *
     * @param newX      - new value for x-position
     * @param newY      - new value for y-position
     * @param newColor  - new Color for myColor
     * @param newRadius - new value for radius
     */
    public Circle(int newX, int newY, Color newColor, int newRadius) {
        super(newX, newY, newColor);
        radius = newRadius;
    }

    /**
     * No-argument constructor that
     * creates a circle of radius ten
     */
    public Circle() {
        super(0, 0, Color.white);
        setRadius(10);
    }

    /**
     * Draw method that overrides the
     * method in super class that gives
     * instructions on how to draw a circle
     *
     * @param g - Graphics
     */
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(getMyColor());
        g2d.drawOval(getX(),getY(),radius, radius);
    }

    /**
     * Get area method, overrides from
     * super class that returns the
     * correct area for a circle
     *
     * @return double
     */
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /**
     * Setter for radius
     * @param newRadius - new value for radius
     */
    public void setRadius(int newRadius) {
        radius = newRadius;
    }

    /**
     * Returns a String representation
     * of Circle
     * @return String
     */
    @Override
    public String toString() {
        return "Circle";
    }

    @Override
    public Object clone() {
        return new Square(getX(), getY(), getMyColor(), radius);
    }
}

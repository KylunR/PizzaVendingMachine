package mainClasses.shapes;

import java.awt.*;

/**
 * Subclass of Shape, that represents a
 * Square, square holds a value of size,
 * that represents the side lengths of the
 * square
 *
 * @author Kylun Robbins
 * @version 06/01/19
 */
public class Square extends Shape{
    private int size;

    /**
     * Constructor that calls super class's constructor
     * to set x, y, and color, in addition, it sets the value
     * of the size of the square
     *
     * @param newX      - new value for x
     * @param newY      - new value for y
     * @param newColor  - new value for Color
     * @param newSize   - new value for size
     */
    public Square(int newX, int newY, Color newColor, int newSize) {
        super(newX, newY, newColor);
        size = newSize;
    }

    /**
     * No-argument constructor that
     * creates a Square of side-length ten
     */
    public Square() {
        super(0, 0, Color.white);
        setSize(10);
    }

    @Override
    public Object clone() {
        return new Square(getX(), getY(), getMyColor(), size);
    }

    /**
     * Draw method that overrides the
     * method in super class that gives
     * instructions on how to draw a square
     *
     * @param g - Graphics
     */
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;

        g2d.setColor(getMyColor());
        g2d.draw3DRect(getX(), getY(), size, size, false);
    }

    /**
     * Get area method, overrides from
     * super class that returns the
     * correct area for a square
     *
     * @return double
     */
    @Override
    public double getArea() {
        return size * size;
    }

    /**
     * Setter for size
     * @param newSize - new value for size
     */
    public void setSize(int newSize) {
        size = newSize;
    }

    /**
     * Returns a String representation
     * of Square
     * @return String
     */
    @Override
    public String toString() {
        return "Square";
    }
}

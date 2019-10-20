package mainClasses;

/**
 * PizzaException is a custom exception created for us
 * in the PizzaManager project, inherits from RuntimeException
 *
 * @author Kylun Robbins
 * @version 06/06/2019
 */
public class PizzaException extends RuntimeException {

    /**
     * Constructor that calls the
     * super class's method and prints
     * a generic error message
     */
    public PizzaException() {
        super("Error in PizzaManager!");
    }

    /**
     * Constructor that takes in a
     * String that will print when the
     * exception is thrown
     *
     * @param message - special message sent when exception is thrown
     */
    public PizzaException(String message) {
        super(message);
    }
}
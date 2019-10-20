package mainClasses;

/**
 * Money class that holds a value for dollars and cent
 *
 * @author Kylun Robbins
 * @version 06/06/2019
 */
public class Money implements Comparable, Cloneable {
    private int dollars;
    private int cents;

    /**
     * Clone method that returns a copy of the
     * current instance of Money
     * @return Object
     */
    public Object clone() {
        return new Money(getDollars(), getCents());
    }

    /**
     * compareTo method that compares two Money
     * objects, returns positive if greater than
     * input, zero if equal, and negative if less
     * than
     *
     * @param o - Money object to compare
     * @return int
     */
    @Override
    public int compareTo(Object o) {
        if(o == null || !(o instanceof Money)) {
            throw new RuntimeException();
        }
        Money that = (Money)o;
        int thisDelta = this.dollars * 100 + this.cents;
        int thatDelta = that.dollars * 100 + that.cents;
        return thisDelta - thatDelta;
    }

    /**
     * Equals method that returns true if
     * input Object and the current Money
     * instance are equal
     *
     * @param o - Object to compare
     * @return - boolean
     */
    public boolean equals(Object o) {
        if(o == null) {
            return false;
        }
        if(o instanceof Money == false) {
            return false;
        }
        Money that = (Money)o;
        return that.getDollars() == this.getDollars() && that.getCents() == this.getCents();
    }

    /**
     * Method returns a String representation of the
     * Money object
     *
     * @return String
     */
    @Override
    public String toString() {
        return "$" + getDollars() + "." + getCents();
    }

    /**
     * Constructor that set the values of
     * dollars and cents
     *
     * @param newDollars - new value for dollars
     * @param newCents - new value for cents
     */
    public Money(int newDollars, int newCents) {
        setDollars(newDollars);
        setCents(newCents);
    }

    /**
     * Copy constructor that calls the original
     * constructor
     *
     * @param other - Money object to set current instance too
     */
    public Money(Money other) {
        this(other.getDollars(), other.getCents());
    }

    /**
     * Getter for dollars
     * @return int dollars
     */
    public int getDollars() {
        return dollars;
    }

    /**
     * Setter for dollars, ensures that dollars
     * is being set to a positive amount
     *
     * @param newDollars - new value for dollars
     */
    public void setDollars(int newDollars) {
        if(newDollars >= 0) {
            dollars = newDollars;
        } else {
            throw new IllegalArgumentException("Dollars cannot be negative.");
        }
    }

    /**
     * Getter for cents
     * @return int cents
     */
    public int getCents() {
        return cents;
    }

    /**
     * Setter for cents, ensures cents is being
     * set to a positive number, if number is greater
     * than 100, setter will automatically update the dollar
     * amount too.
     *
     * @param newCents - new value for cents
     */
    public void setCents(int newCents) {
        if(newCents < 0) {
            throw new IllegalArgumentException("Cents must be positive");
        } else {
            if(newCents >= 100) {
                dollars += newCents / 100;
                cents = newCents % 100;
            } else {
                cents = newCents;
            }
        }
    }

    /**
     * Setter for both dollars and cents, maintains
     * same rules as the individual setter methods
     *
     * @param newDollars - new value for dollars
     * @param newCents - new value for cents
     */
    public void setMoney(int newDollars, int newCents) {
        setDollars(newDollars);
        setCents(newCents);
    }

    /**
     * Getter for total money that returns a
     * double of the dollars and cents
     *
     * @return double
     */
    public double getMoney() {
        return (double) dollars + (cents / 100);
    }

    /**
     * Add method that adds the inputs to the current
     * instance of Money
     *
     * @param inputDollars - amount to add to dollars
     * @param inputCents - amount to add to cents
     */
    public void add(int inputDollars, int inputCents) {
        setDollars(dollars + inputDollars);
        setCents(cents + inputCents);
    }

    /**
     * Add method that adds a Money object to the
     * current instance of Money
     *
     * @param other - Money object to add
     */
    public void add(Money other) {
        setDollars(dollars + other.getDollars());
        setCents(cents + other.getCents());
    }
}

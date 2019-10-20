package mainClasses;

/**
 * Fraction class that hold a value for the numerator
 * and denominator, class automatically reduces when
 * constructor is used
 *
 * @author Kylun Robbins
 */
public class Fraction implements Comparable, Cloneable {
    private final int numerator;
    private final int denominator;

    /**
     * Constructor to set the values of
     * numerator and denominator, constructor
     * ensures denominator is not zero and that the
     * fraction is changed to positive if both the numerator
     * and denominator are negative, reduces fraction by
     * finding the greatest common divisor
     *
     * @param newNumerator - New value for numerator
     * @param newDenominator - New value for denominator
     */
    public Fraction(int newNumerator, int newDenominator) {
        if(newDenominator == 0) {                                       // Check to make sure input denominator is not 0
            throw new RuntimeException("Denominator cannot be zero!");  // If it is throw an exception
        }

        if(newNumerator < 0 && newDenominator < 0) {                    // Check to see if both numerator and denominator
            newNumerator *= -1;                                         // are negative, if so, multiply both by -1
            newDenominator *= -1;                                       // to make the fraction positive
        }

        int divisor = reduce(newNumerator, newDenominator);            // Calls GCD method to find greatest common divisor

        denominator = newDenominator / divisor;                     // Set denominator to input / greatest common divisor
        numerator = newNumerator / divisor;                         // Set numerator to input / greatest common divisor
    }

    /**
     * Copy constructor that calls the
     * original constructor
     *
     * @param other - Fraction Object to set instance to
     */
    public Fraction(Fraction other) {
        this(other.getNumerator(), other.getDenominator());
    }

    /**
     * Clone method that returns a copy of the
     * current instance of Fraction
     *
     * @return Object
     */
    public Object clone() {
        return new Fraction(getNumerator(), getDenominator());
    }

    /**
     * Compare to method that returns a positive
     * integer if the Fraction is greater than the input,
     * returns 0 if they are equal, and returns a negative
     * integer if the Fraction is less than the input
     *
     * @param o - Object to compare to current Fraction
     * @return int
     */
    public int compareTo(Object o) {
        if(o == null || !(o instanceof Fraction)) {
            throw new RuntimeException("Bad input!");
        }
        Fraction that = (Fraction)o;
        return (this.getNumerator() * that.getDenominator()) - (that.getNumerator() * this.getDenominator());
    }

    /**
     * Equals method that returns true if the instance
     * is equal to the Object input
     *
     * @param o - Object to compare to
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if(o == null || !(o instanceof Fraction)) {                     // Check if input is null or not an instance of fraction
            return false;                                               // if so, return false, because it cannot be equal
        }

        Fraction that = (Fraction)o;
        return this.numerator == that.numerator && this.denominator == that.denominator;
    }

    /**
     * Returns a string representation of
     * the current Fraction
     * @return String
     */
    public String toString() {
        return numerator + "/" + denominator;
    }

    /**
     * Method to find the greatest common
     * divisor between a numerator and denominator,
     * returns the greatest common divisor
     *
     * @param numerator - input numerator to find GCD
     * @param denominator - input denominator to find GCD
     * @return int
     */
    private int reduce(int numerator, int denominator) {
        int gcd = 1;
        for(int i = 1; i <= 100; i++) {
            if(numerator % i == 0 && denominator % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    public double toDecimal() {
        return (double)(getNumerator() / getDenominator());
    }

    /**
     * Method removes a fraction of
     * the current fraction, this will be
     * used in the eatSomePizza method
     *
     * @param amt - Amount you wish to remove
     * @return Fraction object
     */
    public Fraction removeFraction(Fraction amt) {
        if(this.getDenominator() == amt.getDenominator()) {                     // If denominators are the same
            return new Fraction(this.getNumerator()               // subtract the two numerators
                                - amt.getNumerator(), this.getDenominator());
        } else {                                                                               // If denominators are not the same
            return new Fraction((this.getNumerator() * amt.getDenominator()) -   // multiply each numerator by the other
                                (this.getDenominator() * amt.getNumerator()),                 // fractions denominator and subtract to get
                        this.getDenominator() * amt.getDenominator());         // new numerator, multiply two denominators to get
        }                                                                                     // new denominator
    }

    /**
     * Getter for denominator
     * @return int
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * Gettter for numerator
     * @return int
     */
    public int getNumerator() {
        return numerator;
    }
}

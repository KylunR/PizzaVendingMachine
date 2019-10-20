package mainClasses.timeStamp;

/**
 * Class that creates a date object that
 * includes a day, month, and year.
 *
 * Invariants:
 * Day values should be between 1-31
 * Month values should be between 1-12
 * Year values should be between 2014-2024
 *
 * @author Kylun Robbins
 * @version 04/17/19
 */

public class Date implements Comparable, Cloneable {
    private int day;
    private int month;
    private int year;

    /**
     * Constructor that sets the dates for day,
     * month, and year
     *
     * @param newMonth - new value for month
     * @param newDay   - new value for day
     * @param newYear  - new value for year
     */
    public Date(int newMonth, int newDay, int newYear) {
        setDay(newDay);
        setMonth(newMonth);
        setYear(newYear);
    }

    /**
     * Copy constructor that calls the
     * original constructor
     * @param newDate - Date to copy over
     */
    public Date(Date newDate) {
        this(newDate.getMonth(), newDate.getDay(), newDate.getYear());
    }

    /**
     * Clone method that returns a copy of the
     * current Date instance
     *
     * @return Object
     */
    public Object clone() {
        return new Date(getMonth(), getDay(), getYear());
    }

    /**
     * Compare to method that returns a positive number
     * if the current Date is after the input Date, returns
     * zero if they are the same date, and returns a negative
     * integer if the current Date is before the input
     *
     * @param o - Object to compare to current Date
     * @return int
     */
    public int compareTo(Object o) {
        if(o == null || !(o instanceof Date)) {             // Check to see if the input is null or not an
            throw new RuntimeException("Bad input!");       // instance of Date, if so, throw an exception
        }
        Date that = (Date)o;
        if(this.getYear() - that.getYear() != 0) {          // If the two years are not equal
            return this.getYear() - that.getYear();         // return the difference of the years
        } else if(this.getYear() - that.getYear() == 0 && this.getMonth() != that.getMonth()) {
            return this.getMonth() - that.getMonth();       // If the years are equal and the months are not
        } else {                                            // return the difference in the months
            return this.getDay() - that.getDay();           // Otherwise return the difference in the days
        }
    }

    /**
     * Getter for day
     * @return int
     */
    public int getDay() {
        return day;
    }

    /**
     * Getter for month
     * @return int
     */
    public int getMonth() {
        return month;
    }

    /**
     * Getter for year
     * @return int
     */
    public int getYear() {
        return year;
    }

    /**
     * Setter for day, ensure day is set
     * between 1-31
     * @param newDay - new value for date
     */
    public void setDay(int newDay) {
        if(newDay >=1 && newDay <= 31) {
            this.day = newDay;
        } else {
            throw new IllegalArgumentException("Day must be between 1-31 inclusive");
        }
    }

    /**
     * Setter for month, ensure month
     * is set between 1-12
     * @param newMonth - new value for month
     */
    public void setMonth(int newMonth) {
        if(newMonth > 0 && newMonth < 13) {
            this.month = newMonth;
        } else {
            throw new IllegalArgumentException("Months must be between 1-12 inclusive");
        }
    }

    /**
     * Setter for year
     * @param newYear - new value for year
     */
    public void setYear(int newYear) {
        this.year = newYear;
    }

    /**
     * Equals method that return true if the
     * instance Date is equal to the input object
     *
     * @param o - Object to compare to Date
     * @return boolean
     */
    public boolean equals(Object o) {
        if(o == null || !(o instanceof Date)) {             // Checks to see if input is null or not an
            return false;                                   // instance of Date, if so, it returns false
        }
        Date that = (Date)o;
        return this.getDay() == that.getDay() && this.getMonth() == that.getMonth()
                && this.getYear() == that.getYear();
    }

    /**
     * Method returns a String representation of
     * the current Date Object (MM,DD,YYYY)
     *
     * @return String
     */
    public String toString() {
        String retVal = getMonth() + "/" + getDay() + "/" + getYear();
        return retVal;
    }
}

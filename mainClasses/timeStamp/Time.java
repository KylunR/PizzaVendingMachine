package mainClasses.timeStamp;

import mainClasses.PizzaException;

/**
 * This is a simple Time class that holds
 * the values for hours, minutes, and seconds
 *
 * @author Kylun Robbins
 */
public class Time {
    private int hour;
    private int minute;
    private int second;

    /**
     * Constructor to set hour, minute,
     * and second
     *
     * @param newHour   - value for hour
     * @param newMinute - value for minute
     * @param newSecond - value for second
     */
    public Time(int newHour, int newMinute, int newSecond) {
        setHour(newHour);
        setMinute(newMinute);
        setSecond(newSecond);
    }

    /**
     * Copy constructor that calls
     * original constructor
     * @param newTime - Time object to copy
     */
    public Time(Time newTime) {
        this(newTime.getHour(), newTime.getMinute(), newTime.getSecond());
    }

    /**
     * Setter for hour, ensures that hour
     * is set between 0 and 23, inclusive
     * @param newHour - new value for hour
     */
    public void setHour(int newHour) {
        if(newHour >= 0 && newHour <= 23) {
            hour = newHour;
        } else {
            throw new PizzaException("Hour must be from 0-23.");
        }
    }

    /**
     * Setter for minute, ensures that
     * minute is set between 0 and 59,
     * inclusive
     * @param newMinute - new value for minute
     */
    public void setMinute(int newMinute) {
        if(newMinute >= 0 && newMinute <= 59) {
            minute = newMinute;
        } else {
            throw new PizzaException("Minutes must be from 0-59.");
        }
    }

    /**
     * Setter for second, ensures that
     * second is set between 0 and 59,
     * inclusive
     * @param newSecond - new value for second
     */
    public void setSecond(int newSecond) {
        if(newSecond >= 0 && newSecond <= 59) {
            minute = newSecond;
        } else {
            throw new PizzaException("Seconds must be from 0-59.");
        }
    }

    /**
     * Getter for hour
     * @return int
     */
    public int getHour() {
        return hour;
    }

    /**
     * Getter for minute
     * @return int
     */
    public int getMinute() {
        return minute;
    }

    /**
     * Getter for second
     * @return int
     */
    public int getSecond() {
        return second;
    }
}

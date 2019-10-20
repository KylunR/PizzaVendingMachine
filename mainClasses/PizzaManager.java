package mainClasses;

import java.util.Scanner;
import java.util.Stack;
import java.util.Calendar;
import mainClasses.timeStamp.Date;
import mainClasses.timeStamp.Time;

/**
 * PizzaManager is the class in which we put most of
 * the PizzaManager classes together to test. PizzaManager
 * is a subclass of PizzaManager, which is the main driver
 * for all the classes, PizzaManager overrides the methods
 * in PizzaManager so that they actually perform what they
 * are intended to.
 *
 * @author Kylun Robbins
 * @version 06/06/2019
 */
public class PizzaManager {
    private ArrayList<Pizza> list = new ArrayList<Pizza>();

    public final static void main(String[] args) {
        PizzaManager manager = new PizzaManager();
        manager.start();
    }

    /**
     * Interface for the Pizza Vending Machine
     * Uses switch to read inputs from user
     */
    public final void start() {
        while(true) {
            displayAllPizzas();
            displayInstructions();
            switch(getNextChar()) {
                case 'A':   case 'a':   addRandomPizza();
                                        break;
                case 'H':   case 'h':	addOneHundredPizzas();
                                        break;
                case 'E':   case 'e':	eatSomePizza();
                                        break;
                case 'P':   case 'p': 	quickSortByPrice();
                                        break;
                case 'S':   case 's': 	quickSortBySize();
                                        break;
                case 'C':   case 'c':   quickSortByCalories();
                                        break;
                case 'L':   case 'l':   System.out.println("What day are you looking for?");
                                        linearSearchByDay(getNextInt());
                                        break;
                case 'D':   case 'd':   removeDayOldPizzas();
                                        break;
                case 'B':   case 'b':	System.out.println("What calorie count are you looking for?");
                                        binarySearchByCalories(getNextInt());
                                        break;
                case 'R':   case 'r':   reversePizzasWithStack();
                                        break;
                case 'Q':    case 'q':	System.out.println("(Q)uitting...");
                                        System.exit(0);
                                        break;
                default:				System.out.println("Unrecognized input - try again");
            }
        }
    }

    /**
     * String that is used to present instructions
     * the the user
     */
    protected static final String instructions = "-----------------------\nWelcome to PizzaManager\n-----------------------\n" +
                                                 "(A)dd a random pizza\nAdd a (H)undred random pizzas\n(E)at a fraction of a pizza" +
                                                 "\nQuickSort pizzas by (P)rice\nQuickSort pizzas by (S)ize\nQuickSort pizzas by (C)alories\n" +
                                                 "(B)inary Search pizzas by calories\n(L)inear search pizzas by day\n" +
                                                 "(R)everse order of pizzas with a stack\nRemove (D)ay-old pizzas\n(Q)uit\n";

    /**
     * Method to print out the instructions
     */
    protected void displayInstructions() {
        System.out.println(instructions);
    }

    /**
     * Returns the current date
     */
    public static Date getCurrentDate() {
        Calendar cal = Calendar.getInstance();
        return new Date(cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.YEAR));
    }

    /**
     * Returns the current time
     */
    public static Time getCurrentTime() {
        Calendar cal = Calendar.getInstance();
        return new Time(cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
    }

    /**
     * Adds 100 pizzas to the array list
     */
    public void addOneHundredPizzas() {
        System.out.println("Adding one hundred random pizzas to the ArrayList<Pizza>.");
        for(int i = 0; i < 99; i++) {
            addRandomPizza();
        }
    }

    /**
     * Gets the next char, used for
     * reading user input for making
     * selection on what to do in
     * PizzaManager
     *
     * @return char
     */
    protected char getNextChar() {
        char[] options = {'A', 'H', 'E', 'P', 'S', 'C', 'B', 'L', 'R', 'D', 'Q',        // All char options
                            'a', 'h', 'e', 'p', 's', 'c', 'b', 'l', 'r', 'd', 'q'};     // for user
        Scanner keyboard = new Scanner(System.in);                                      // Create Scanner
        char retVal = keyboard.next().charAt(0);                                        // Store char in retVal
        for(int i = 0; i < options.length; i++) {                                       // If char is equal
            if(options[i] == retVal) {                                                  // to any of the options
                return retVal;                                                          // return the char
            }
        }
        throw new PizzaException("Not an option!");                                     // Throws exception if char is not option
    }

    /**
     * Gets the next int from user input
     * @return int
     */
    protected int getNextInt() {
        Scanner scanner = new Scanner(System.in);      // Create scanner
        int retVal = scanner.nextInt();                // stores next int to retVal
        return retVal;                                 // Return retVal
    }

    /**
     * Prints all the Pizza Objects
     * in the list
     */
    protected void displayAllPizzas() {
        System.out.println(list.toString());
    }

    /**
     * Method is used to eat a fraction
     * of a pizza object
     */
    protected void eatSomePizza() {
        Scanner sc = new Scanner(System.in);                                            // Scanner to read input
        System.out.println("At what index is the pizza you would like to eat?");        // Ask which pizza you want to eat from
        int index = sc.nextInt();                                                       // Read the input

        if(index >= list.size()) {                                                      // Checks to see if input is within range
            throw new PizzaException("Invalid index");                                  // If not throw exception
        }

        System.out.println("How much do you want to eat (fraction)?");                  // Ask how much they want to eat
        String fraction = sc.next();                                                    // Read input as String
        String[] fractionToEat = fraction.split("/");                             // Split input to get numerator and denominator
        int numerator = Integer.parseInt(fractionToEat[0]);                             // Parse int for numerator
        int denominator = Integer.parseInt(fractionToEat[1]);                           // Parse int for denominator
        Fraction toEat = new Fraction(numerator, denominator);                          // Create new fraction of amount to eat

        list.get(index).eatSomePizza(toEat);                                            // Call eatSomePizza method from Pizza class
        if(list.get(index).getRemainingFraction().getNumerator() == 0) {                // If remaining pizza is 0
            System.out.println("You ate all the remaining pizza!");                     // Tell user they ate all the pizza
            list.remove(index);                                                         // Remove pizza from list
        } else {                                                                        // If there is some left
            System.out.println("Remaining Pizza: " +
                    list.get(index).getRemainingFraction());                            // Print remaining pizza
        }
    }

    /**
     * Adds a random pizza to the list
     */
    protected void addRandomPizza() {
        list.insert(new Pizza());
    }

    /**
     * Outer method which calls the
     * recursiveQuickSortByPrice method,
     * this sorts the list by price, using
     * the quick sort algorithm
     */
    protected void quickSortByPrice() {
        recursiveQuickSortByPrice(0, list.size() - 1);      // Call facade method with first and last index
    }

    /**
     * Calls pivot value to obtain a pivot
     * value and then recursively calls
     * itself if low is less than pivot
     * and high is greater than pivot
     *
     * @param low   - index to start sort
     * @param high  - index to end sort
     */
    private void recursiveQuickSortByPrice(int low, int high) {
        int pivotValue = pivotValuePrice(low, high);                // Call pivot value method to get pivotValue
        if(low < pivotValue - 1) {                                  // If low is less than pivot
            recursiveQuickSortByPrice(low, pivotValue - 1);   // recursively call with new high of pivot -1
        }
        if(high > pivotValue) {                                     // If high is greater than pivot
            recursiveQuickSortByPrice(pivotValue, high);            // recursively call with new low of pivot
        }
    }

    /**
     * Method chooses a pivot value in between
     * the arguments high and low then compares
     * that pivot's value to every element in the
     * list and swaps any that are out of order
     *
     * @param low   - index to start swapping
     * @param high  - index to end swapping
     * @return int - where we left off
     */
    public int pivotValuePrice(int low, int high) {
        int pivotIndex = low;                                           // Stores a pivot halfway between low and high
        Pizza retVal = list.get(pivotIndex);                            // Stores the Pizza object of the pivot
        while(low <= high) {                                            // While low is less than or equal to high
            while(list.get(low).compareTo(retVal) < 0) {                // If low's cost is less than pivot's
                low++;                                                  // increase low
            }
            while(list.get(high).compareTo(retVal) > 0) {               // If high's cost is greater than pivot's
                high--;                                                 // decrease high
            }
            if(low <= high) {                                           // If low is less than or equal to high
                list.swap(low++, high--);                               // Swap the two
            }
        }
        return low;                                                     // Return where we left off
    }


    /**
     * Outer method which calls the
     * recursiveQuickSortBySize method,
     * this sorts the list by area/size, using
     * the quick sort algorithm
     */
    protected void quickSortBySize() {
        recursiveQuickSortBySize(0, list.size() - 1);      // Call facade method with first and last index
    }

    /**
     * Calls pivot value to obtain a pivot
     * value and then recursively calls
     * itself if low is less than pivot
     * and high is greater than pivot
     *
     * @param low   - index to start sort
     * @param high  - index to end sort
     */
    private void recursiveQuickSortBySize(int low, int high) {
        int pivotValue = pivotValueSize(low, high);                 // Call pivot value method to get pivotValue
        if(low < pivotValue - 1) {                                  // If low is less than pivot
            recursiveQuickSortBySize(low, pivotValue - 1);    // recursively call with new high of pivot -1
        }
        if(high > pivotValue) {                                     // If high is greater than pivot
            recursiveQuickSortBySize(pivotValue, high);             // recursively call with new low of pivot
        }
    }

    /**
     * Method chooses a pivot value in between
     * the arguments high and low then compares
     * that pivot's value to every element in the
     * list and swaps any that are out of order
     *
     * @param low   - index to start swapping
     * @param high  - index to end swapping
     * @return int - where we left off
     */
    public int pivotValueSize(int low, int high) {
        int pivotIndex = low;                                           // Stores a pivot halfway between low and high
        Pizza retVal = list.get(pivotIndex);                            // Stores the Pizza object of the pivot
        while(low <= high) {                                            // While low is less than or equal to high
            while(list.get(low).compareToBySize(retVal) < 0) {          // If low's area is less than pivot's
                low++;                                                  // increase low
            }
            while(list.get(high).compareToBySize(retVal) > 0) {         // If high's area is greater than pivot's
                high--;                                                 // decrease high
            }
            if(low <= high) {                                           // If low is less than or equal to high
                list.swap(low++, high--);                               // Swap the two
            }
        }
        return low;                                                     // Return where we left off
    }

    /**
     * Outer method which calls the
     * recursiveQuickSortByCalories method,
     * this sorts the list by the amount
     * of calories, using the quick sort algorithm
     */
    protected void quickSortByCalories() {
        recursiveQuickSortByCalories(0, list.size() - 1);      // Call facade method with first and last index
    }

    /**
     * Calls pivot value to obtain a pivot
     * value and then recursively calls
     * itself if low is less than pivot
     * and high is greater than pivot
     *
     * @param low   - index to start sort
     * @param high  - index to end sort
     */
    private void recursiveQuickSortByCalories(int low, int high) {
        int pivotValue = pivotValueCalories(low, high);                 // Call pivot value method to get pivotValue
        if(low < pivotValue - 1) {                                      // If low is less than pivot
            recursiveQuickSortByCalories(low, pivotValue - 1);    // recursively call with new high of pivot -1
        }
        if(high > pivotValue) {                                         // If high is greater than pivot
            recursiveQuickSortByCalories(pivotValue, high);             // recursively call with new low of pivot
        }
    }

    /**
     * Method chooses a pivot value in between
     * the arguments high and low then compares
     * that pivot's value to every element in the
     * list and swaps any that are out of order
     *
     * @param low   - index to start swapping
     * @param high  - index to end swapping
     * @return int - where we left off
     */
    public int pivotValueCalories(int low, int high) {
        int pivotIndex = low;                                           // Stores a pivot halfway between low and high
        Pizza retVal = list.get(pivotIndex);                            // Stores the Pizza object of the pivot
        while(low <= high) {                                            // While low is less than or equal to high
            while(list.get(low).compareToByCalories(retVal) < 0) {      // If low's calories is less than pivot's
                low++;                                                  // increase low
            }
            while(list.get(high).compareToByCalories(retVal) > 0) {     // If high's calories is greater than pivot's
                high--;                                                 // decrease high
            }
            if(low <= high) {                                           // If low is less than or equal to high
                list.swap(low++, high--);                               // Swap the two
            }
        }
        return low;                                                     // Return where we left off
    }

    /**
     * Searches for a pizza with a specific
     * calorie value, using the binary
     * search, returns the index of the
     * pizza with calorie amount, and returns
     * -1 if there is no pizza with calorie amount
     *
     * @param cals - calorie amount to compare
     * @return int
     */
    protected int binarySearchByCalories(int cals) {
        quickSortByCalories();                                                   // Sorts array for binary search
        return recursiveBinarySearch(cals, 0 , list.size() - 1);
    }

    /**
     * Completes the binary search
     * algorithm recursively, this
     * method is an inner method for
     * the binarySearchByCalories method
     *
     * @param cals - calorie target
     * @param low  - starting index to search
     * @param high - ending index to search
     * @return int
     */
    private int recursiveBinarySearch(int cals, int low, int high) {
        if(low > high) {                                                // If low > high
            return -1;                                                  // index not found, return -1
        }
        int mid = (low + high) / 2;                                     // Stores middle index
        int midCalorieValue = list.get(mid).getCalories();              // Stores middle value
        if(midCalorieValue == cals) {                                   // If middle value = target
            System.out.println("Found at " + mid);
            return mid;                                                 // return index
        } else if(midCalorieValue < cals) {                             // If value is less than target
            return recursiveBinarySearch(cals, mid + 1, high);     // recurse with mid + 1 and high
        } else {                                                        // If value is greater than target
            return recursiveBinarySearch(cals, low, mid);               // recurse with low and mid index
        }
    }

    /**
     * Checks to see if there is a pizza
     * made on a given day, returns the index
     * of the pizza made on that day, if there
     * is no pizza made on the day, returns -1
     *
     * @param day - day to compare
     * @return int
     */
    protected int linearSearchByDay(int day) {
        for(int i = 0; i < list.size(); i++) {              // Iterates over every pizza
            if(list.get(i).getMadeDate().getDay() == day) { // If pizza made date is equal to argument day
                System.out.println("Pizza at index " + i    // Print message stating index that has
                        + " matches day");                  // matching date
                return i;                                   // return the index
            }
        }
        System.out.println("No pizzas made on given day."); // If not found print message
        return -1;                                          // and return -1
    }

    /**
     * Removes day old pizzas from the list
     */
    protected void removeDayOldPizzas() {
        for(int i = 0; i < list.size(); i++) {                                          // Check every pizza in the list
            if(getCurrentDate().getDay() - list.get(i).getMadeDate().getDay() >= 1) {   // If current day - made day is greater than 1
                list.remove(i);                                                         // Remove pizza
            }
        }
    }

    /**
     * Method reverses the pizza list by
     * adding all the elements to a Stack, then
     * removing them from the stack and adding
     * them back to the list
     */
    protected void reversePizzasWithStack() {
        Stack stack = new Stack();                  // Create stack
        for(int i = 0; i > list.size(); i++) {      // Add each element to stack
            stack.push(list.remove(i));             // and remove from list
        }
        while(stack.isEmpty() == false) {           // While stack is not empty
            list.insert((Pizza)stack.pop());        // Pop them back into the list
        }
    }
}
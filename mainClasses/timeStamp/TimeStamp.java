package mainClasses.timeStamp;

/**
 * This class IS a Date and HAS a time
 * You can call the getters for either, but no setters
 * Also a good candidate for a class with final data items.
 *
 * @author Kylun Robbins
 */
public class TimeStamp extends Date {    
	private Time time;
	

	public TimeStamp(Date newDate, Time newTime) {
		super(newDate);
		time = new Time(newTime);
	}
	
	public Time getTime() { 
		return new Time(time);
	}

	public Date getDate() {
		return new Date(this);
	}
	
	public String toString() {
		return "timeStamp at: " + time.getHour() + ":" + time.getMinute()+":"
				+ time.getSecond() + " and " + super.toString();
	}
}

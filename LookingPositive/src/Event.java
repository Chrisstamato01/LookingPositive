import java.time.*;
import java.util.ArrayList;
public class Event {
	
	private LocalDate date;
	private String place;
	private ArrayList<Profiles> profiles;
	private int counter = 0;
	//private ArrayList<Event> events = new ArrayList<>();
	
	
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public Event(LocalDate datetime ,String place ,ArrayList<Profiles> profiles) {
		this.date = datetime;
		this.place = place;
		this.profiles = profiles;
		counter++;
		//events.add(this);
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public ArrayList<Profiles> getProfiles() {
		return profiles;
	}

	public void setProfiles(ArrayList<Profiles> profiles) {
		this.profiles = profiles;
	}
	@Override
	public String toString() {
		return "Γεγονός -> Ημερομηνία: "+date+"Μέρος: "+place+"Άτομ: "+profiles+".";
	}


}

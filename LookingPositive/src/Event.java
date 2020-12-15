import java.time.*;
import java.util.ArrayList;
public class Event {
	
	private LocalDate date;
	private String place;
	private ArrayList<Profiles> profiles;
	//ΚΑΤΑΣΚΕΥΑΣΤΗΣ ΤΩΝ EVENTS
	public Event(LocalDate datetime ,String place ,ArrayList<Profiles> profiles) {
		this.date = datetime;
		this.place = place;
		this.profiles = profiles;
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

package LookingPositive.LookingPositive;

import java.time.*;
import java.util.ArrayList;

public class Event {

  private LocalDate date;
  private Geography place;
  private ArrayList<Profile> profiles;

  // ΚΑΤΑΣΚΕΥΑΣΤΗΣ ΤΩΝ EVENTS
  public Event(LocalDate datetime, Geography place,
      ArrayList<Profile> profiles) {
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

  public Geography getPlace() {
    return place;
  }

  public void setPlace(Geography place) {
    this.place = place;
  }

  public ArrayList<Profile> getProfiles() {
    return profiles;
  }

  public void setProfiles(ArrayList<Profile> profiles) {
    this.profiles = profiles;
  }

  @Override
  public String toString() {
    return "Γεγονός -> Ημερομηνία: " + date + "Μέρος: " + place + "Άτομ: "
        + profiles + ".";
  }

}

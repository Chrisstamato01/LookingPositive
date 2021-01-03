package LookingPositive.LookingPositive;

import java.time.LocalDate;
import java.util.ArrayList;

public class Event {
  /**
   * date has the date of the event.
   */
  private LocalDate date;
  /**
   * place has the place of the event.
   */
  private Geography place;
  /**
   * profiles the people he/she will meet.
   */
  private ArrayList<Profile> profiles;

  //
  /**
   * This method is an event constructor.
   *
   * @param dateTime         the date of the event
   * @param placeOfTheEvent  the place of the event
   * @param peopleHeWillMeet the people he/she will meet
   */
  public Event(final LocalDate dateTime, final Geography placeOfTheEvent,
      final ArrayList<Profile> peopleHeWillMeet) {
    date = dateTime;
    place = placeOfTheEvent;
    profiles = peopleHeWillMeet;
  }

  /**
   * This method returns the date of the event.
   *
   * @return the date of the event
   */
  public final LocalDate getDate() {
    return date;
  }

  /**
   * This method modify the date of the event.
   *
   * @param newDate is the renewed date of the event.
   */
  public final void setDate(final LocalDate newDate) {
    date = newDate;
  }

  /**
   * This method returns the place of the event.
   *
   * @return the place of the event
   */
  public final Geography getPlace() {
    return place;
  }

  /**
   * This method modifies the place of the event.
   *
   * @param newPlace is the renewed place of the event
   */
  public final void setPlace(final Geography newPlace) {
    place = newPlace;
  }

  /**
   * This method returns the people he/she will meet.
   *
   * @return the people he/she will meet
   */
  public final ArrayList<Profile> getProfiles() {
    return profiles;
  }

  /**
   * This method modifies the people he/she will meet.
   *
   * @param newProfiles is the renewed profiles
   */
  public final void setProfiles(final ArrayList<Profile> newProfiles) {
    profiles = newProfiles;
  }

  @Override
  public final String toString() {
    return "Γεγονός -> Ημερομηνία: " + date + "Μέρος: " + place + "Άτομ: "
        + profiles + ".";
  }

}

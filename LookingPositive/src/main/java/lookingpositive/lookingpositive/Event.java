package lookingpositive.lookingpositive;

import java.time.LocalDate;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

/**
 *This class makes events.
 */
public final class Event {
  /**
   * date has the date of the event.
   */
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  @JsonDeserialize(using = LocalDateDeserializer.class)
  @JsonSerialize(using = LocalDateSerializer.class)
  private LocalDate date;
  /**
   * place has the place of the event.
   */
  private Geography place;
  /**
   * profiles the people he/she will meet.
   */
  private ArrayList<Profile> profiles;

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
   * Default constructor.
   */
  public Event() {
  }

  /**
   * This method returns the date of the event.
   *
   * @return the date of the event
   */
  public LocalDate getDate() {
    return date;
  }

  /**
   * This method modifies the date of the event.
   *
   * @param newDate is the renewed date of the event.
   */
  public void setDate(final LocalDate newDate) {
    date = newDate;
  }

  /**
   * This method returns the place of the event.
   *
   * @return the place of the event
   */
  public Geography getPlace() {
    return place;
  }

  /**
   * This method modifies the place of the event.
   *
   * @param newPlace is the renewed place of the event
   */
  public void setPlace(final Geography newPlace) {
    place = newPlace;
  }

  /**
   * This method returns the people he/she will meet.
   *
   * @return the people he/she will meet
   */
  public ArrayList<Profile> getProfiles() {
    return profiles;
  }

  /**
   * This method modifies the people he/she will meet.
   *
   * @param newProfiles is the renewed profiles
   */
  public void setProfiles(final ArrayList<Profile> newProfiles) {
    profiles = newProfiles;
  }
  /*
   * (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Event [date=" + date + ", place=" + place + ", profiles=" + profiles
        + "]";
  }

}

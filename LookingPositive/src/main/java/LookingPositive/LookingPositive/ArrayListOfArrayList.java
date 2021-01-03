package LookingPositive.LookingPositive;

import java.util.ArrayList;

/**
 * The class ArraylistofArraylist creates a two dimensional ArrayList and
 * process it.
 */
public class ArrayListOfArrayList {
/**
 * This field is an ArrayList which contains the ArrayLists
 * of the Events for each user.
 */
  private ArrayList<ArrayList<Event>> eventList
  = new ArrayList<ArrayList<Event>>();
  // Creates a list of Events and adds them to the instance's eventLst.

  /**
   * This method creates for each user a list that is added to the eventList.
   */
  public void createarraylistofevents() {
    ArrayList<Event> usereventlist = new ArrayList<Event>();
    eventList.add(usereventlist);
  }

  //ΜΠΟΡΕΙ ΝΑ ΜΗΝ ΜΑΣ ΧΡΕΙΑΣΤΕΙ ΓΤ ΔΕΝ ΞΕΡΟΥΜΕ ΠΩ΅ΝΑ ΤΟ ΧΡΗΣΙΜΟΠΟΙΗΣΟΥΜΕ.
  /**
   * This method returns the eventList.
   * @return the eventList
   */
  public ArrayList<ArrayList<Event>> getEventList() {
    return eventList;
  }

  /**
   * This method modify the eventList.
   * @param newEventList is the renewed eventList of the event.
   */
  public void setEventList(final ArrayList<ArrayList<Event>> newEventList) {
    eventList = newEventList;
  }

  // Copies the Events from toCopy to the instance's eventList.
  /**
   * This method copies the content of a type ArraylistofArraylist object to
   * another.
   *
   * @param tocopy the object ArraylistofArraylist which will be copied
   */
  public void copydoublearralist(final ArrayListOfArrayList tocopy) {
    for (int i = 0; i < tocopy.eventList.size(); i++) {
      for (int j = 0; j < tocopy.eventList.get(i).size(); j++) {
        eventList.get(i).add(tocopy.eventList.get(i).get(j));
      }
    }
  }
  // This method deletes the content from a two dimensional list.

  /**
   * This method removes every Event object from every user's list.
   */
  public void deleteevent() {
    for (int i = 0; i < eventList.size(); i++) {
      for (int j = eventList.get(i).size() - 1; j >= 0; j--) {
        eventList.get(i).remove(j);
      }
    }
  }

  // This method prints all the Event objects from the eventList.
  /**
   * This method prints every event from a user's list.
   */
  public void printcheck() {
    for (int i = 0; i < eventList.size(); i++) {
      for (int j = 0; j < eventList.get(i).size(); j++) {
        System.out.println(eventList.get(i).get(j));
      }
    }
  }

/**
 * This method adds an event to a specific user's list of the eventList.
 * @param userId is a specific user
 * @param ev the is the new event
 */
  public void addEventToUsersList(final int userId, final Event ev) {
    eventList.get(userId).add(ev);
  }
  /**
   * This method returns the size of the eventList.
   * @return the size of the evenList
   */
  public int getEventListsSize() {
    return eventList.size();
  }
  /**
   * This method returns the size of the list of events
   * for the specific row of eventList.
   * @param rowCounter is the specific row
   * @return the number of the events of the user
   */
  public int getUsersEventListsSize(final int rowCounter) {
    return eventList.get(rowCounter).size();
  }
  /**
   * This method returns a specific event.
   * @param rowCounter the row with the events of a user
   * @param eventCounter the number of the event of a user
   * @return a specific event
   */
  public Event getCurrentEvent(final int rowCounter, final int eventCounter) {
    return eventList.get(rowCounter).get(eventCounter);
  }
  /**
   * This method removes a specific event.
   * @param rowCounter the user's calendar where the event is
   * @param eventCounter the event we want to remove
   */
  public void removeCurrentEvent(final int rowCounter, final int eventCounter) {
    eventList.get(rowCounter).remove(eventCounter);
  }
}
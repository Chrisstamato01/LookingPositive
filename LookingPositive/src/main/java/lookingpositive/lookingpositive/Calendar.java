package lookingpositive.lookingpositive;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Calendar {

//The class can't be initialized.
  private Calendar() {
  }

  /**
   * This field contains an integer which is the days Covid-Sars-19 lasts.
   */
  private static final int DAYS_COVID_LASTS = 14;
  /**
   * This field contains a table which contains the ArrayListOfArrayList
   * day1,day2,...,day14 on each cell.
   */
  private static ArrayListOfArrayList[] fourteenDays = new ArrayListOfArrayList[DAYS_COVID_LASTS];
  /**
   * This field contains the events for each user on the current day.
   */
  private static ArrayListOfArrayList today = new ArrayListOfArrayList();
  /**
   * This field contains the events for each user on the future.
   */
  private static ArrayListOfArrayList future = new ArrayListOfArrayList();
  /**
   * This field contains the events for each user one day before the last user
   * signed in.
   */
  private static ArrayListOfArrayList day1 = new ArrayListOfArrayList();
  /**
   * This field contains the events for each user two day before the last user
   * signed in.
   */
  private static ArrayListOfArrayList day2 = new ArrayListOfArrayList();
  /**
   * This field contains the events for each user three day before the last user
   * signed in.
   */
  private static ArrayListOfArrayList day3 = new ArrayListOfArrayList();
  /**
   * This field contains the events for each user four day before the last user
   * signed in.
   */
  private static ArrayListOfArrayList day4 = new ArrayListOfArrayList();
  /**
   * This field contains the events for each user five day before the last user
   * signed in.
   */
  private static ArrayListOfArrayList day5 = new ArrayListOfArrayList();
  /**
   * This field contains the events for each user six day before the last user
   * signed in.
   */
  private static ArrayListOfArrayList day6 = new ArrayListOfArrayList();
  /**
   * This field contains the events for each user seven day before the last user
   * signed in.
   */
  private static ArrayListOfArrayList day7 = new ArrayListOfArrayList();
  /**
   * This field contains the events for each user eight day before the last user
   * signed in.
   */
  private static ArrayListOfArrayList day8 = new ArrayListOfArrayList();
  /**
   * This field contains the events for each user nine day before the last user
   * signed in.
   */
  private static ArrayListOfArrayList day9 = new ArrayListOfArrayList();
  /**
   * This field contains the events for each user ten day before the last user
   * signed in.
   */
  private static ArrayListOfArrayList day10 = new ArrayListOfArrayList();
  /**
   * This field contains the events for each user eleven day before the last
   * user signed in.
   */
  private static ArrayListOfArrayList day11 = new ArrayListOfArrayList();
  /**
   * This field contains the events for each user twelve day before the last
   * user signed in.
   */
  private static ArrayListOfArrayList day12 = new ArrayListOfArrayList();
  /**
   * This field contains the events for each user thirteen day before the last
   * user signed in.
   */
  private static ArrayListOfArrayList day13 = new ArrayListOfArrayList();
  /**
   * This field contains the events for each user fourteen day before the last
   * user signed in.
   */
  private static ArrayListOfArrayList day14 = new ArrayListOfArrayList();

  // na sviso to localdate today gt to
  // xrisimopoioumne gia ton sxediasmo kanonika.
  // sigrinoume tin simerini hmerominia
  // Η ΜΕΘΟΔΟΣ ΕΠΙΛΕΓΕΙ ΑΝ ΘΑ ΤΟΠΟΘΕΤΗΣΕΙ ΤΑ EVENT ΣΤΟΝ TODAY Η ΣΤΟΝ FUTURE
  /**
   * This method adds a new Event on the calendar of user.
   *
   * @param ev     is the event
   * @param userId is the user's id
   * @param x      ΠΡΕΠΕΙ ΝΑ ΣΒΗΣΤΕΙ ΚΑΙ ΜΠΕΙ ΗΜ/ΜΗΝΙΑ ΣΤΗΝ ΘΕΣΗ ΤΟΥ
   * @return a string that registration was completed successfully
   */
  public static String addToCalendar(final Event ev, final int userId,
      final int x) {

    if (x == 1) {
      today.addEventToUsersList(userId, ev);
    } else {
      future.addEventToUsersList(userId, ev);
    }
    return "Καταχωρήθηκε η εκδήλωση σας " + ev;
  }

  /**
   * This method renews the events because day/days have passed.
   *
   * @param newDate the current date that the last user has singed in
   * @param oldDate the date that the previews user had signed in
   */
  public static void deleteExpiredEvents(final LocalDate newDate,
      final LocalDate oldDate) {
    // ΒΡΙΣΚΟΥΜΕ ΤΗΝ ΔΙΑΦΟΡΑ ΜΕΤΑΞΥ ΤΩΝ ΗΜΕΡΟΜΗΝΙΩΝ
    long differenceOfDays = oldDate.until(newDate, ChronoUnit.DAYS);
    LocalDate replicaOldDate;
    System.out.println(differenceOfDays);
    // ΔΗΜΙΟΘΡΓΙΑ ΒΡΟΓΧΟΥ ΓΙΑ ΤΗΝ ΔΙΑΧΕΙΡΗΣΗ ΔΕΔΟΜΕΝΩΝ ΠΟΥ ΑΠΕΧΟΥΝ ΠΟΛΛΕΣ ΜΕΡΕΣ
    // ΜΕΤΑΞΥ ΤΟΥΣ
    for (int counter = 0; counter < differenceOfDays; counter++) {

      // ΣΕ ΠΕΡΙΠΤΩΣΗ ΠΟΥ Ο ΧΡΗΣΤΗΣ ΜΠΑΙΝΕΙ ΚΑΘΕ ΜΕΡΑ
      System.out.println(counter);

      day14.deleteEvent();
      day14.copyDoubleArraList(day13);
      day13.deleteEvent();
      day13.copyDoubleArraList(day12);
      day12.deleteEvent();
      day12.copyDoubleArraList(day11);
      day11.deleteEvent();
      day11.copyDoubleArraList(day10);
      day10.deleteEvent();
      day10.copyDoubleArraList(day9);
      day9.deleteEvent();
      day9.copyDoubleArraList(day8);
      day8.deleteEvent();
      day8.copyDoubleArraList(day7);
      day7.deleteEvent();
      day7.copyDoubleArraList(day6);
      day6.deleteEvent();
      day6.copyDoubleArraList(day5);
      day5.deleteEvent();
      day5.copyDoubleArraList(day4);
      day4.deleteEvent();
      day4.copyDoubleArraList(day3);
      day3.deleteEvent();
      day3.copyDoubleArraList(day2);
      day2.deleteEvent();
      day2.copyDoubleArraList(day1);
      day1.deleteEvent();
      day1.copyDoubleArraList(today);

      System.out.println("Beginfourteen cell[0]");
      fourteenDays[0].printcheck();
      System.out.println("ENDfourteen cell[0]");
      // ΔΙΑΓΡΑΦΗ ΤΟΥ ΠΕΡΙΕΧΟΜΕΝΟΥ ΤΟΥ TODAY
      today.deleteEvent();

      System.out.println("Begintoday");
      today.printcheck();
      System.out.println("ENDtoday");
      // ΔΙΑΧΕΙΡΗΣΕΙ ΤΩΝ ΗΜΕΡΟΜΙΝΙΩΝ ΜΕΣΩ ΤΟΥ REPLICAOLDDATE
      replicaOldDate = oldDate.plusDays(counter + 1);
      System.out.println(replicaOldDate);

      // ΓΕΜΙΣΜΑ ΤΟΥ TODAY ΜΕ ΤΑ ΑΝΑΝΕΟΜΕΝΑ ΣΤΟΙΧΕΙΑ ΤΗΣ ΕΠΟΜΕΝΗΣ
      // ΜΕΡΑΣ ΠΟΥ ΒΡΙΣΚΟΝΤΑΙ
      // ΣΤΟΝ FUTURE
      System.out.println("filling today");
      for (int i = 0; i < future.getEventListsSize(); i++) {
        for (int j = 0; j < future.getUsersEventListsSize(i); j++) {
          if (replicaOldDate
              .isEqual((future.getCurrentEvent(i, j).getDate()))) {
            // today.eventList.get(i).add(future.eventList.get(i).get(j));
            today.addEventToUsersList(i, future.getCurrentEvent(i, j));
            // System.out.println(today.eventlist.get(i).get(j));
          }
        }
      }
      System.out.println("end filling today");
      // ΔΙΑΓΡΑΦΗ ΤΩΝ ΣΤΟΙΧΕΙΩΝ ΠΟΥ ΜΠΗΚΑΝ ΣΤΟΝ TODAY ΑΡΑ Η ΗΜΕΡΟΜΗΝΙΑ ΤΟΥΣ ΔΕΝ
      // ΑΝΟΙΚΕΙ ΠΛΕΟΝ ΣΤΟ ΜΕΛΛΟΝ
      System.out.println("removing future of day");
      for (int i = 0; i < future.getEventListsSize(); i++) {
        for (int j = future.getUsersEventListsSize(i) - 1; j >= 0; j--) {
          if (replicaOldDate
              .isEqual((future.getCurrentEvent(i, j).getDate()))) {
            System.out.println(future.getUsersEventListsSize(i) + "before");
            // future.eventlist.get(i).remove(j);
            future.removeCurrentEvent(i, j);
            System.out.println(future.getUsersEventListsSize(i) + "after");
          }
        }
      }

      System.out.println("Afterrefilltoday");
      today.printcheck();
      System.out.println("Afterrefilltoday");

    }
  }

  /**
   * This method returns the Events of all users of today.
   *
   * @return ArrayListOfArrayList object
   */
  public static ArrayListOfArrayList getToday() {
    return today;
  }

  /**
   * This method returns the Events of all users of future.
   *
   * @return ArrayListOfArrayList object
   */
  public static ArrayListOfArrayList getFuture() {
    return future;
  }

  // ΝΑ ΤΗΝ ΒΑΛΟΥΜΕ ΣΤΗΝ ΚΛΑΣΗ ΤΟΥ ΧΡΗΣΤΟΥ.
  /**
   * This method initialize every ArrayListOfArrayList object for each user.
   */
  public static void daysInitializer() {
    today.createarraylistofevents();
    future.createarraylistofevents();
    day1.createarraylistofevents();
    day2.createarraylistofevents();
    day3.createarraylistofevents();
    day4.createarraylistofevents();
    day5.createarraylistofevents();
    day6.createarraylistofevents();
    day7.createarraylistofevents();
    day8.createarraylistofevents();
    day9.createarraylistofevents();
    day10.createarraylistofevents();
    day11.createarraylistofevents();
    day12.createarraylistofevents();
    day13.createarraylistofevents();
    day14.createarraylistofevents();
  }

  public static ArrayListOfArrayList getFourteenDaysCell(final int cell) {
    return fourteenDays[cell];
  }
}

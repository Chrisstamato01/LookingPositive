package lookingpositive.lookingpositive;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.type.TypeReference;


public final class Calendar {

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
  private static ArrayListOfArrayList[] fourteenDays
  = new ArrayListOfArrayList[DAYS_COVID_LASTS];
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

  /**
   * This method adds a new Event on the calendar of user.
   *
   * @param ev     is the event
   * @param userId is the user's id
   * @return a string that registration was completed successfully
   */
  public static String addToCalendar(final Event ev, final int userId) {

    if (ev.getDate().equals(LocalDate.now())) {
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

    // System.out.println(differenceOfDays);
    // ΔΗΜΙΟΘΡΓΙΑ ΒΡΟΓΧΟΥ ΓΙΑ ΤΗΝ ΔΙΑΧΕΙΡΗΣΗ ΔΕΔΟΜΕΝΩΝ ΠΟΥ ΑΠΕΧΟΥΝ ΠΟΛΛΕΣ ΜΕΡΕΣ
    // ΜΕΤΑΞΥ ΤΟΥΣ
    for (int counter = 0; counter < differenceOfDays; counter++) {

      // ΣΕ ΠΕΡΙΠΤΩΣΗ ΠΟΥ Ο ΧΡΗΣΤΗΣ ΜΠΑΙΝΕΙ ΚΑΘΕ ΜΕΡΑ
      // System.out.println(counter);

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

      // System.out.println("Beginfourteen cell[0]");
      // fourteenDays[0].printcheck();
      // System.out.println("ENDfourteen cell[0]");
      // ΔΙΑΓΡΑΦΗ ΤΟΥ ΠΕΡΙΕΧΟΜΕΝΟΥ ΤΟΥ TODAY
      today.deleteEvent();

      // System.out.println("Begintoday");
      // today.printcheck();
      // System.out.println("ENDtoday");
      // ΔΙΑΧΕΙΡΗΣΕΙ ΤΩΝ ΗΜΕΡΟΜΙΝΙΩΝ ΜΕΣΩ ΤΟΥ REPLICAOLDDATE
      replicaOldDate = oldDate.plusDays(counter + 1);
      // System.out.println(replicaOldDate);

      // ΓΕΜΙΣΜΑ ΤΟΥ TODAY ΜΕ ΤΑ ΑΝΑΝΕΟΜΕΝΑ ΣΤΟΙΧΕΙΑ ΤΗΣ ΕΠΟΜΕΝΗΣ
      // ΜΕΡΑΣ ΠΟΥ ΒΡΙΣΚΟΝΤΑΙ
      // ΣΤΟΝ FUTURE
      // System.out.println("filling today");
      for (int i = 0; i < future.giveEventListsSize(); i++) {
        for (int j = 0; j < future.getUsersEventListsSize(i); j++) {
          if (replicaOldDate
              .isEqual((future.getCurrentEvent(i, j).getDate()))) {
            // today.eventList.get(i).add(future.eventList.get(i).get(j));
            today.addEventToUsersList(i, future.getCurrentEvent(i, j));
            // System.out.println(today.eventlist.get(i).get(j));
          }
        }
      }
      // System.out.println("end filling today");
      // ΔΙΑΓΡΑΦΗ ΤΩΝ ΣΤΟΙΧΕΙΩΝ ΠΟΥ ΜΠΗΚΑΝ ΣΤΟΝ TODAY ΑΡΑ Η ΗΜΕΡΟΜΗΝΙΑ ΤΟΥΣ ΔΕΝ
      // ΑΝΟΙΚΕΙ ΠΛΕΟΝ ΣΤΟ ΜΕΛΛΟΝ
      // System.out.println("removing future of day");
      for (int i = 0; i < future.giveEventListsSize(); i++) {
        for (int j = future.getUsersEventListsSize(i) - 1; j >= 0; j--) {
          if (replicaOldDate
              .isEqual((future.getCurrentEvent(i, j).getDate()))) {
            // System.out.println(future.getUsersEventListsSize(i) + "before");
            // future.eventlist.get(i).remove(j);
            future.removeCurrentEvent(i, j);
            // System.out.println(future.getUsersEventListsSize(i) + "after");
          }
        }
      }

      // System.out.println("Afterrefilltoday");
      // today.printcheck();
      // System.out.println("Afterrefilltoday");

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

  /**
   * This method returns a chosen cell of fourteenDays table.
   * @param cell is one out of fourteen cells of fourteenDays
   * @return an ArrayListOfArrayList object
   */
  public static ArrayListOfArrayList getFourteenDaysCell(final int cell) {
    return fourteenDays[cell];
  }
  /**
   * Saves Events to JSON file.
   */
  public static void eventSaver() {
    ObjectMapper objectMapper = new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    try {
      File file1 = new File("calendar\\today.json").getAbsoluteFile();
      File file2 = new File("calendar\\future.json").getAbsoluteFile();

      File file3 = new File("calendar\\day1.json").getAbsoluteFile();
      File file4 = new File("calendar\\day2.json").getAbsoluteFile();
      File file5 = new File("calendar\\day3.json").getAbsoluteFile();
      File file6 = new File("calendar\\day4.json").getAbsoluteFile();
      File file7 = new File("calendar\\day5.json").getAbsoluteFile();
      File file8 = new File("calendar\\day6.json").getAbsoluteFile();
      File file9 = new File("calendar\\day7.json").getAbsoluteFile();
      File file10 = new File("calendar\\day8.json").getAbsoluteFile();
      File file11 = new File("calendar\\day9.json").getAbsoluteFile();
      File file12 = new File("calendar\\day10.json").getAbsoluteFile();
      File file13 = new File("calendar\\day11.json").getAbsoluteFile();
      File file14 = new File("calendar\\day12.json").getAbsoluteFile();
      File file15 = new File("calendar\\day13.json").getAbsoluteFile();
      File file16 = new File("calendar\\day14.json").getAbsoluteFile();

      objectMapper.writeValue(file1, today);
      objectMapper.writeValue(file2, future);
      objectMapper.writeValue(file3, day1);
      objectMapper.writeValue(file4, day2);
      objectMapper.writeValue(file5, day3);
      objectMapper.writeValue(file6, day4);
      objectMapper.writeValue(file7, day5);
      objectMapper.writeValue(file8, day6);
      objectMapper.writeValue(file9, day7);
      objectMapper.writeValue(file10, day8);
      objectMapper.writeValue(file11, day9);
      objectMapper.writeValue(file12, day10);
      objectMapper.writeValue(file13, day11);
      objectMapper.writeValue(file14, day12);
      objectMapper.writeValue(file15, day13);
      objectMapper.writeValue(file16, day14);
    } catch (IOException e) {
      System.out.println("ioexception:" + e);
    } catch (Exception e) {
      System.out.println("exception:" + e);
    }
  }
  /**
   * Retrieves Events from JSON file.
   */
  public static void eventRetriever() {
    ObjectMapper objectMapper = new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    try {
      File file1 = new File("calendar\\today.json").getAbsoluteFile();
      File file2 = new File("calendar\\future.json").getAbsoluteFile();

      File file3 = new File("calendar\\day1.json").getAbsoluteFile();
      File file4 = new File("calendar\\day2.json").getAbsoluteFile();
      File file5 = new File("calendar\\day3.json").getAbsoluteFile();
      File file6 = new File("calendar\\day4.json").getAbsoluteFile();
      File file7 = new File("calendar\\day5.json").getAbsoluteFile();
      File file8 = new File("calendar\\day6.json").getAbsoluteFile();
      File file9 = new File("calendar\\day7.json").getAbsoluteFile();
      File file10 = new File("calendar\\day8.json").getAbsoluteFile();
      File file11 = new File("calendar\\day9.json").getAbsoluteFile();
      File file12 = new File("calendar\\day10.json").getAbsoluteFile();
      File file13 = new File("calendar\\day11.json").getAbsoluteFile();
      File file14 = new File("calendar\\day12.json").getAbsoluteFile();
      File file15 = new File("calendar\\day13.json").getAbsoluteFile();
      File file16 = new File("calendar\\day14.json").getAbsoluteFile();

      today = objectMapper.readValue(file1, ArrayListOfArrayList.class);
      future = objectMapper.readValue(file2, ArrayListOfArrayList.class);
      day1 = objectMapper.readValue(file3, ArrayListOfArrayList.class);
      day2 = objectMapper.readValue(file4, ArrayListOfArrayList.class);
      day3 = objectMapper.readValue(file5, ArrayListOfArrayList.class);
      day4 = objectMapper.readValue(file6, ArrayListOfArrayList.class);
      day5 = objectMapper.readValue(file7, ArrayListOfArrayList.class);
      day6 = objectMapper.readValue(file8, ArrayListOfArrayList.class);
      day7 = objectMapper.readValue(file9, ArrayListOfArrayList.class);
      day8 = objectMapper.readValue(file10, ArrayListOfArrayList.class);
      day9 = objectMapper.readValue(file11, ArrayListOfArrayList.class);
      day10 = objectMapper.readValue(file12, ArrayListOfArrayList.class);
      day11 = objectMapper.readValue(file13, ArrayListOfArrayList.class);
      day12 = objectMapper.readValue(file14, ArrayListOfArrayList.class);
      day13 = objectMapper.readValue(file15, ArrayListOfArrayList.class);
      day14 = objectMapper.readValue(file16, ArrayListOfArrayList.class);
    } catch (IOException e) {
      System.out.println("ioexception:" + e);
    } catch (Exception e) {
      System.out.println("exception:" + e);
    }
  }
}

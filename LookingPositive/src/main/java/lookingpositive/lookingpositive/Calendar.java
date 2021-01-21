package lookingpositive.lookingpositive;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 *This class handles every user's events when days pass.
 */
public final class Calendar {

//The class can't be initialized.
  /**
   * This is the private default constructor.
   */
  private Calendar() {
  //This class can not be initialized.
  }

  /**
   * This field contains an integer which is the days Covid-Sars-19 lasts.
   */
  private static final int DAYS_COVID_LASTS = 14;
  /**
   * This field contains a table which contains the ArrayListOfArrayList
   * day1,day2,...,day14 on each cell.
   */
  private static ArrayListOfArrayList[] fourteenDays =
      new ArrayListOfArrayList[DAYS_COVID_LASTS];
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
   * This method is used to fill fourteenDays.
   */
  public static void fillingFourteenDays() {
    final int dayOne = 0;
    final int dayTwo = 1;
    final int dayThree = 2;
    final int dayFour = 3;
    final int dayFive = 4;
    final int daySix = 5;
    final int daySeven = 6;
    final int dayEight = 7;
    final int dayNine = 8;
    final int dayTen = 9;
    final int dayEleven = 10;
    final int dayTwelve = 11;
    final int dayThirteen = 12;
    final int dayFourteen = 13;
    fourteenDays[dayOne] = day1;
    fourteenDays[dayTwo] = day2;
    fourteenDays[dayThree] = day3;
    fourteenDays[dayFour] = day4;
    fourteenDays[dayFive] = day5;
    fourteenDays[daySix] = day6;
    fourteenDays[daySeven] = day7;
    fourteenDays[dayEight] = day8;
    fourteenDays[dayNine] = day9;
    fourteenDays[dayTen] = day10;
    fourteenDays[dayEleven] = day11;
    fourteenDays[dayTwelve] = day12;
    fourteenDays[dayThirteen] = day13;
    fourteenDays[dayFourteen] = day14;
  }

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
      rearrangingFourteenDays();

      // System.out.println("Beginfourteen cell[0]");
      // fourteenDays[0].printCheck();
      // System.out.println("ENDfourteen cell[0]");
      // ΔΙΑΓΡΑΦΗ ΤΟΥ ΠΕΡΙΕΧΟΜΕΝΟΥ ΤΟΥ TODAY
      today.deleteAllEvents();

      // System.out.println("Begintoday");
      // today.printCheck();
      // System.out.println("ENDtoday");
      // ΔΙΑΧΕΙΡΗΣΕΙ ΤΩΝ ΗΜΕΡΟΜΙΝΙΩΝ ΜΕΣΩ ΤΟΥ REPLICAOLDDATE
      replicaOldDate = oldDate.plusDays(counter + 1);
      // System.out.println(replicaOldDate);

      // ΓΕΜΙΣΜΑ ΤΟΥ TODAY ΜΕ ΤΑ ΑΝΑΝΕΟΜΕΝΑ ΣΤΟΙΧΕΙΑ ΤΗΣ ΕΠΟΜΕΝΗΣ
      // ΜΕΡΑΣ ΠΟΥ ΒΡΙΣΚΟΝΤΑΙ
      // ΣΤΟΝ FUTURE
      // System.out.println("filling today");
      updatingToday(replicaOldDate);
      // System.out.println("end filling today");
      // ΔΙΑΓΡΑΦΗ ΤΩΝ ΣΤΟΙΧΕΙΩΝ ΠΟΥ ΜΠΗΚΑΝ ΣΤΟΝ TODAY ΑΡΑ Η ΗΜΕΡΟΜΗΝΙΑ ΤΟΥΣ ΔΕΝ
      // ΑΝΟΙΚΕΙ ΠΛΕΟΝ ΣΤΟ ΜΕΛΛΟΝ
      // System.out.println("removing future of day");
      clearingFutureFromTodaysEvents(replicaOldDate);

      // System.out.println("Afterrefilltoday");
      // today.printcheck();
      // System.out.println("Afterrefilltoday");

    }
  }

  /**
   * This method clears the future list from old dates.
   *
   * @param replicaOldDate date which is compared with future's dates.
   */
  private static void clearingFutureFromTodaysEvents(
      final LocalDate replicaOldDate) {
    for (int i = 0; i < future.giveEventListsSize(); i++) {
      for (int j = future.getUsersEventListsSize(i) - 1; j >= 0; j--) {
        if (replicaOldDate.isEqual((future.getCurrentEvent(i, j).getDate()))) {
          // System.out.println(future.getUsersEventListsSize(i) + "before");
          // future.eventlist.get(i).remove(j);
          future.removeCurrentEvent(i, j);
          // System.out.println(future.getUsersEventListsSize(i) + "after");
        }
      }
    }
  }

  /**
   * This method updates the today's list for each user with the current events.
   *
   * @param replicaOldDate date which is compared with future's dates
   */
  private static void updatingToday(final LocalDate replicaOldDate) {
    for (int i = 0; i < future.giveEventListsSize(); i++) {
      for (int j = 0; j < future.getUsersEventListsSize(i); j++) {
        if (replicaOldDate.isEqual((future.getCurrentEvent(i, j).getDate()))) {
          // today.eventList.get(i).add(future.eventList.get(i).get(j));
          today.addEventToUsersList(i, future.getCurrentEvent(i, j));
          // System.out.println(today.eventlist.get(i).get(j));
        }
      }
    }
  }

  /**
   * This method moves the Events of the last 14 days because one day pasted.
   */
  private static void rearrangingFourteenDays() {
    day14.deleteAllEvents();
    day14.copyDoubleArrayList(day13);
    day13.deleteAllEvents();
    day13.copyDoubleArrayList(day12);
    day12.deleteAllEvents();
    day12.copyDoubleArrayList(day11);
    day11.deleteAllEvents();
    day11.copyDoubleArrayList(day10);
    day10.deleteAllEvents();
    day10.copyDoubleArrayList(day9);
    day9.deleteAllEvents();
    day9.copyDoubleArrayList(day8);
    day8.deleteAllEvents();
    day8.copyDoubleArrayList(day7);
    day7.deleteAllEvents();
    day7.copyDoubleArrayList(day6);
    day6.deleteAllEvents();
    day6.copyDoubleArrayList(day5);
    day5.deleteAllEvents();
    day5.copyDoubleArrayList(day4);
    day4.deleteAllEvents();
    day4.copyDoubleArrayList(day3);
    day3.deleteAllEvents();
    day3.copyDoubleArrayList(day2);
    day2.deleteAllEvents();
    day2.copyDoubleArrayList(day1);
    day1.deleteAllEvents();
    day1.copyDoubleArrayList(today);
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
    today.createArrayListOfEvents();
    future.createArrayListOfEvents();
    day1.createArrayListOfEvents();
    day2.createArrayListOfEvents();
    day3.createArrayListOfEvents();
    day4.createArrayListOfEvents();
    day5.createArrayListOfEvents();
    day6.createArrayListOfEvents();
    day7.createArrayListOfEvents();
    day8.createArrayListOfEvents();
    day9.createArrayListOfEvents();
    day10.createArrayListOfEvents();
    day11.createArrayListOfEvents();
    day12.createArrayListOfEvents();
    day13.createArrayListOfEvents();
    day14.createArrayListOfEvents();
  }

  /**
   * This method returns a chosen cell of fourteenDays table.
   *
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
      objectMapper
          .writeValue(new File("src\\main\\resources\\calendar\\today.json")
              .getAbsoluteFile(), today);
      objectMapper
          .writeValue(new File("src\\main\\resources\\calendar\\future.json")
              .getAbsoluteFile(), future);
      objectMapper
          .writeValue(new File("src\\main\\resources\\calendar\\day1.json")
              .getAbsoluteFile(), day1);
      objectMapper
          .writeValue(new File("src\\main\\resources\\calendar\\day2.json")
              .getAbsoluteFile(), day2);
      objectMapper
          .writeValue(new File("src\\main\\resources\\calendar\\day3.json")
              .getAbsoluteFile(), day3);
      objectMapper
          .writeValue(new File("src\\main\\resources\\calendar\\day4.json")
              .getAbsoluteFile(), day4);
      objectMapper
          .writeValue(new File("src\\main\\resources\\calendar\\day5.json")
              .getAbsoluteFile(), day5);
      objectMapper
          .writeValue(new File("src\\main\\resources\\calendar\\day6.json")
              .getAbsoluteFile(), day6);
      objectMapper
          .writeValue(new File("src\\main\\resources\\calendar\\day7.json")
              .getAbsoluteFile(), day7);
      objectMapper
          .writeValue(new File("src\\main\\resources\\calendar\\day8.json")
              .getAbsoluteFile(), day8);
      objectMapper
          .writeValue(new File("src\\main\\resources\\calendar\\day9.json")
              .getAbsoluteFile(), day9);
      objectMapper
          .writeValue(new File("src\\main\\resources\\calendar\\day10.json")
              .getAbsoluteFile(), day10);
      objectMapper
          .writeValue(new File("src\\main\\resources\\calendar\\day11.json")
              .getAbsoluteFile(), day11);
      objectMapper
          .writeValue(new File("src\\main\\resources\\calendar\\day12.json")
              .getAbsoluteFile(), day12);
      objectMapper
          .writeValue(new File("src\\main\\resources\\calendar\\day13.json")
              .getAbsoluteFile(), day13);
      objectMapper
          .writeValue(new File("src\\main\\resources\\calendar\\day14.json")
              .getAbsoluteFile(), day14);
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
      today = objectMapper
          .readValue(streamToString("calendar/today.json"),
              ArrayListOfArrayList.class);
      future = objectMapper
          .readValue(streamToString("calendar/future.json"), ArrayListOfArrayList.class);
      day1 = objectMapper
          .readValue(new File("src\\main\\resources\\calendar\\day1.json")
              .getAbsoluteFile(), ArrayListOfArrayList.class);
      day2 = objectMapper
          .readValue(new File("src\\main\\resources\\calendar\\day2.json")
              .getAbsoluteFile(), ArrayListOfArrayList.class);
      day3 = objectMapper
          .readValue(new File("src\\main\\resources\\calendar\\day3.json")
              .getAbsoluteFile(), ArrayListOfArrayList.class);
      day4 = objectMapper
          .readValue(new File("src\\main\\resources\\calendar\\day4.json")
              .getAbsoluteFile(), ArrayListOfArrayList.class);
      day5 = objectMapper
          .readValue(new File("src\\main\\resources\\calendar\\day5.json")
              .getAbsoluteFile(), ArrayListOfArrayList.class);
      day6 = objectMapper
          .readValue(new File("src\\main\\resources\\calendar\\day6.json")
              .getAbsoluteFile(), ArrayListOfArrayList.class);
      day7 = objectMapper
          .readValue(new File("src\\main\\resources\\calendar\\day7.json")
              .getAbsoluteFile(), ArrayListOfArrayList.class);
      day8 = objectMapper
          .readValue(new File("src\\main\\resources\\calendar\\day8.json")
              .getAbsoluteFile(), ArrayListOfArrayList.class);
      day9 = objectMapper
          .readValue(new File("src\\main\\resources\\calendar\\day9.json")
              .getAbsoluteFile(), ArrayListOfArrayList.class);
      day10 = objectMapper
          .readValue(new File("src\\main\\resources\\calendar\\day10.json")
              .getAbsoluteFile(), ArrayListOfArrayList.class);
      day11 = objectMapper
          .readValue(new File("src\\main\\resources\\calendar\\day11.json")
              .getAbsoluteFile(), ArrayListOfArrayList.class);
      day12 = objectMapper
          .readValue(new File("src\\main\\resources\\calendar\\day12.json")
              .getAbsoluteFile(), ArrayListOfArrayList.class);
      day13 = objectMapper
          .readValue(new File("src\\main\\resources\\calendar\\day13.json")
              .getAbsoluteFile(), ArrayListOfArrayList.class);
      day14 = objectMapper
          .readValue(new File("src\\main\\resources\\calendar\\day14.json")
              .getAbsoluteFile(), ArrayListOfArrayList.class);
    } catch (IOException e) {
      System.out.println("ioexception:" + e);
    } catch (Exception e) {
      System.out.println("exception:" + e);
    }
  }
  /**
   * This is method.
   * @param path name
   * @return str
   */
  private static String streamToString(final String path) {
   ClassLoader cl = Thread.currentThread().getContextClassLoader();
   StringBuffer sb = new StringBuffer();
   try {
     InputStream in = cl.getResourceAsStream(path);
     //Creating a Scanner object
     Scanner sc = new Scanner(in);
     //Reading line by line from scanner to StringBuffer

     while (sc.hasNext()) {
        sb.append(sc.nextLine());
     }
     System.out.println(sb.toString());
   } catch (Exception e) {
     System.out.println("exception:" + e);
   }
   return sb.toString();
  }
}

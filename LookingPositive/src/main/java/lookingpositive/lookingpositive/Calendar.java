package lookingpositive.lookingpositive;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class handles the storing of users' events.
 */
public final class Calendar {

//The class can't be initialized.
  /**
   * This is the private default constructor.
   */
  private Calendar() {
    // This class can not be initialized.
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
   * This method adds a new Event on the calendar of the user.
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
    return "Your event has been registered." + ev;
  }

  /**
   * This method relocates the events because day/days have passed.
   *
   * @param newDate the current date that the user has singed in
   * @param oldDate the date that the previews user had signed in
   */
  public static void deleteExpiredEvents(final LocalDate newDate,
      final LocalDate oldDate) {

    long differenceOfDays = oldDate.until(newDate, ChronoUnit.DAYS);
    LocalDate replicaOldDate;

    for (int counter = 0; counter < differenceOfDays; counter++) {

      rearrangingFourteenDays();

      today.deleteAllEvents();

      replicaOldDate = oldDate.plusDays(counter + 1);

      updatingToday(replicaOldDate);

      clearingFutureFromTodaysEvents(replicaOldDate);

    }
  }

  /**
   * This method clears the future list from old events.
   *
   * @param replicaOldDate date which is compared with future's dates.
   */
  private static void clearingFutureFromTodaysEvents(
      final LocalDate replicaOldDate) {
    for (int i = 0; i < future.giveEventListsSize(); i++) {
      for (int j = future.getUsersEventListsSize(i) - 1; j >= 0; j--) {
        if (replicaOldDate.isEqual((future.getCurrentEvent(i, j).getDate()))) {
          future.removeCurrentEvent(i, j);
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
          today.addEventToUsersList(i, future.getCurrentEvent(i, j));
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
   * This method returns the future Events of all users.
   *
   * @return ArrayListOfArrayList object
   */
  public static ArrayListOfArrayList getFuture() {
    return future;
  }

  /**
   * This method initialises every ArrayListOfArrayList object for each new
   * user.
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
   * @param cell the number of the cell
   * @return an ArrayListOfArrayList object
   */
  public static ArrayListOfArrayList getFourteenDaysCell(final int cell) {
    return fourteenDays[cell];
  }

  /**
   * Saves Events to JSON file.
   */
  public static void eventSaver() {
    objectSaver("today", today);
    objectSaver("future", future);
    objectSaver("day1", day1);
    objectSaver("day2", day2);
    objectSaver("day3", day3);
    objectSaver("day4", day4);
    objectSaver("day5", day5);
    objectSaver("day6", day6);
    objectSaver("day7", day7);
    objectSaver("day8", day8);
    objectSaver("day9", day9);
    objectSaver("day10", day10);
    objectSaver("day11", day11);
    objectSaver("day12", day12);
    objectSaver("day13", day13);
    objectSaver("day14", day14);
  }

  /**
   * This method saves the new data to the local file for each date.
   *
   * @param day  the day we want to save as String
   * @param days the events we want to save
   */
  private static void objectSaver(final String day,
      final ArrayListOfArrayList days) {
    ObjectMapper objectMapper = new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    try {
      objectMapper.writeValue(new File(FileManager.getHomePath()
          + "/LookingPositiveAppData/" + day + ".json"), days);
    } catch (JsonMappingException e) {
      e.printStackTrace();
    } catch (JsonGenerationException e) {
      e.printStackTrace();
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

    today = objectRetriever("today");
    future = objectRetriever("future");
    day1 = objectRetriever("day1");
    day2 = objectRetriever("day2");
    day3 = objectRetriever("day3");
    day4 = objectRetriever("day4");
    day5 = objectRetriever("day5");
    day6 = objectRetriever("day6");
    day7 = objectRetriever("day7");
    day8 = objectRetriever("day8");
    day9 = objectRetriever("day9");
    day10 = objectRetriever("day10");
    day11 = objectRetriever("day11");
    day12 = objectRetriever("day12");
    day13 = objectRetriever("day13");
    day14 = objectRetriever("day14");
  }

  /**
   * This method retrieves from the file one day's events.
   *
   * @param day the day we want to retrieve
   * @return an ArrayListOfArrayList object
   */
  private static ArrayListOfArrayList objectRetriever(final String day) {
    ObjectMapper objectMapper = new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    try {
      return objectMapper.readValue(FileManager.streamToString(day + ".json"),
          ArrayListOfArrayList.class);
    } catch (JsonMappingException e) {
      e.printStackTrace();
    } catch (JsonGenerationException e) {
      e.printStackTrace();
    } catch (IOException e) {
      System.out.println("ioexception:" + e);
    } catch (Exception e) {
      System.out.println("exception:" + e);
    }
    return null;
  }

  /**
   * Reads Events from the local directory the JSON files.
   */
  public static void eventReader() {
    today = objectReader("today");
    future = objectReader("future");
    day1 = objectReader("day1");
    day2 = objectReader("day2");
    day3 = objectReader("day3");
    day4 = objectReader("day4");
    day5 = objectReader("day5");
    day6 = objectReader("day6");
    day7 = objectReader("day7");
    day8 = objectReader("day8");
    day9 = objectReader("day9");
    day10 = objectReader("day10");
    day11 = objectReader("day11");
    day12 = objectReader("day12");
    day13 = objectReader("day13");
    day14 = objectReader("day14");
  }

  /**
   * This method reads from the local file one day's events.
   *
   * @param day the day we want to read
   * @return an ArrayListOfArrayList
   */
  private static ArrayListOfArrayList objectReader(final String day) {
    ObjectMapper objectMapper = new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    try {
      return objectMapper
          .readValue(
              new File(FileManager.getHomePath() + "/LookingPositiveAppData/"
                  + day + ".json").getAbsoluteFile(),
              ArrayListOfArrayList.class);
    } catch (JsonMappingException e) {
      e.printStackTrace();
    } catch (JsonGenerationException e) {
      e.printStackTrace();
    } catch (IOException e) {
      System.out.println("ioexception:" + e);
    } catch (Exception e) {
      System.out.println("exception:" + e);
    }
    return null;
  }
}

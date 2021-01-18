package lookingpositive.lookingpositive;

import java.time.LocalDate;
import java.util.ArrayList;

/*
 * This class is nickola's and anna's dummy main NicksAndAnnasMain.
 */
/**
 * This main is mine.
 *
 * @author nikgiann
 *
 */
public final class NicksAndAnnasMain {
  /**
   * This is the private default constructor.
   */
  private NicksAndAnnasMain() {
    // This class can not be initialized.
  }

  /**
   * shit.
   *
   * @param args more shit
   */
  public static void main(final String[] args) {
    Geography.fillTables();
    ArrayListOfArrayList expectedInitializerSize = new ArrayListOfArrayList();
    System.out.println(expectedInitializerSize.giveEventListsSize());
    ArrayList<Profile> list = new ArrayList<Profile>();
    System.out.println(list.size());
    Calendar.fillingFourteenDays();
    final int age1 = 44;
    final int age2 = 47;
    final int year = 2021;
    final int month = 2;
    final int day = 13;
    Profile pr1 = new Profile("elisavet", "exarxopoulou", "voula", age1, false,
        "pass1", "papadopoulos@gmail.com");
    Profile pr2 = new Profile("maria", "exarxopoulou", "glyfada", age2, false,
        "pass2", "papadakis@gmail.com");
    Event event1 = new Event(LocalDate.now(), Geography.getFacilitiesLine(0),
        list);
    Event event2 = new Event(LocalDate.of(year, month, day),
        Geography.getFacilitiesLine(0), list);

    System.out.println(Calendar.addToCalendar(event1, 0));
    System.out.println(Calendar.addToCalendar(event2, 0));

    Calendar.getToday().clearArrayListOfArrayList();
    Calendar.getFuture().clearArrayListOfArrayList();
    /*
     * for (int i = 0; i <= dayFourteen; i++) {
     * Calendar.getFourteenDaysCell(i).clearArrayListOfArrayList();; }
     */
    final int dayFourteen = 13;
    Profile.getProfiles().clear();
    Calendar.getToday().printAllEvents();
    Calendar.getFuture().printAllEvents();
    System.out.println(Calendar.getToday().giveEventListsSize());
    System.out.println(Calendar.getFuture().giveEventListsSize());
    for (int i = 0; i <= dayFourteen; i++) {
      Calendar.getFourteenDaysCell(i).clearArrayListOfArrayList();
    }
  }
}

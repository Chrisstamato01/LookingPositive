package lookingpositive.lookingpositive;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class CalendarTest {
  /**
   * Age.
   */
  static final int AGE = 19;
  /**
   * This .
   */
  private ArrayListOfArrayList expectedDayOneList = new ArrayListOfArrayList();
  /**
   * This.
   */
  private ArrayListOfArrayList expectedTodayList = new ArrayListOfArrayList();
  /**
   * This.
   */
  private ArrayListOfArrayList expectedDayTwoList = new ArrayListOfArrayList();

  /**
   * This method creates profiles for testing later.
   * @throws Exception
   */
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    new Profile("Άννα-Μαρία", "Πέτρου", "Γλυφάδα", AGE, false, "annamariacode1",
        "annamariapetrouu@gmail.com");
    new Profile("Χρήστος", "Σταματόπουλος", "Γλυφάδα", AGE, false,
        "chriscode22", "chrisstamatopoulos@gmail.com");
    new Profile("Ιάσων-Χαράλαμπος", "Γιαννίτσας", "Βάρη-Βούλα-Βουλιαγμένη", AGE,
        false, "jasoncode25", "jasongiann@gmail.gr");
    new Profile("Νικόλας", "Γιαννάτος", "Γλυφάδα", AGE, false, "nikolascode34",
        "nikgiann@gmail.com");
    new Geography("Σούπερ Μάρκετ", "ΑΒ Βασιλοπουλος", "3Β");
  }

  /**
   * This method .
   * @throws Exception
   */
  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  /**
   * This method .
   * @throws Exception
   */
  @Before
  public void setUp() throws Exception {
  }

  /**
   * This method .
   * @throws Exception
   */
  @After
  public void tearDown() throws Exception {
  }

  /**
   * This method checks if method addToCalendar is working as supposed.
   * @throws Exception
   */
  @Test
  public void testAddToCalendar() {
    ArrayList<Profile> list = new ArrayList<Profile>();

    list.add(Profile.profilesSaveLine(0));
    list.add(Profile.profilesSaveLine(1));
    list.add(Profile.profilesSaveLine(2));
    Event event1 = new Event(LocalDate.now(), Geography.getFacilitiesLine(0),
        list);
    Calendar.addToCalendar(event1, 0);

    ArrayList<Event> expectedTodayFirstUser = new ArrayList<Event>();
    expectedTodayFirstUser.add(event1);

    assertEquals(Calendar.getToday().getUsersEventListsSize(0),
        expectedTodayFirstUser.size());
    assertEquals(Calendar.getToday().getUserListOfEvents(0),
        expectedTodayFirstUser);
  }

  /**
   * This method checks if method addToCalendar is working as supposed.
   */
  @Test
  public  void testDeleteExpiredEvents() {
    ArrayList<Profile> list = new ArrayList<Profile>();
    list.add(Profile.profilesSaveLine(0));
    list.add(Profile.profilesSaveLine(1));
    list.add(Profile.profilesSaveLine(2));
    final int year = 2021;
    final int month = 01;
    final int toDate = 14;
    final int futureDateOne = 17;// day2
    final int futureDateTwo = 19;// today
    final int futureDateThree = 25;
    final int futureDateFour = 16;
    final int futureDateFive = 20;
    final int futureDateSix = 15;
    final int futureDateSeven = 21;
    final int userId = 3;
    Calendar.getToday().addEventToUsersList(0,
        new Event(LocalDate.of(year, month, toDate),
            Geography.getFacilitiesLine(0), list));
    Calendar.getToday().addEventToUsersList(0,
        new Event(LocalDate.of(year, month, toDate),
            Geography.getFacilitiesLine(0), list));
    Calendar.getToday().addEventToUsersList(1,
        new Event(LocalDate.of(year, month, toDate),
            Geography.getFacilitiesLine(0), list));
    Calendar.getToday().addEventToUsersList(2,
        new Event(LocalDate.of(year, month, toDate),
            Geography.getFacilitiesLine(0), list));
    Calendar.getToday().addEventToUsersList(userId,
        new Event(LocalDate.of(year, month, toDate),
            Geography.getFacilitiesLine(0), list));
    Calendar.getToday().addEventToUsersList(userId,
        new Event(LocalDate.of(year, month, toDate),
            Geography.getFacilitiesLine(0), list));
    Calendar.getFuture().addEventToUsersList(0,
        new Event(LocalDate.of(year, month, futureDateOne),
            Geography.getFacilitiesLine(0), list));
    Calendar.getFuture().addEventToUsersList(0,
        new Event(LocalDate.of(year, month, futureDateTwo),
            Geography.getFacilitiesLine(0), list));
    expectedDayOneList.createArrayListOfEvents();
    expectedDayOneList.addEventToUsersList(0,
        new Event(LocalDate.of(year, month, toDate),
            Geography.getFacilitiesLine(0), list));
    expectedDayOneList.addEventToUsersList(0,
        new Event(LocalDate.of(year, month, toDate),
            Geography.getFacilitiesLine(0), list));
    expectedDayOneList.createArrayListOfEvents();
    expectedDayOneList.addEventToUsersList(1,
        new Event(LocalDate.of(year, month, toDate),
            Geography.getFacilitiesLine(0), list));
    expectedDayOneList.createArrayListOfEvents();
    expectedDayOneList.addEventToUsersList(2,
        new Event(LocalDate.of(year, month, toDate),
            Geography.getFacilitiesLine(0), list));
    expectedDayOneList.createArrayListOfEvents();
    expectedDayOneList.addEventToUsersList(userId,
        new Event(LocalDate.of(year, month, toDate),
            Geography.getFacilitiesLine(0), list));
    expectedDayOneList.addEventToUsersList(userId,
        new Event(LocalDate.of(year, month, toDate),
            Geography.getFacilitiesLine(0), list));
    Calendar.deleteExpiredEvents(LocalDate.of(year, month, futureDateSix),
        LocalDate.of(year, month, toDate));
    assertEquals(Calendar.getFourteenDaysCell(0), expectedDayOneList);
    expectedDayOneList.createArrayListOfEvents();
    expectedTodayList.addEventToUsersList(0,
        new Event(LocalDate.of(year, month, futureDateTwo),
            Geography.getFacilitiesLine(0), list));
    expectedDayOneList.createArrayListOfEvents();
    expectedDayTwoList.addEventToUsersList(1,
        new Event(LocalDate.of(year, month, futureDateOne),
            Geography.getFacilitiesLine(1), list));
    Calendar.deleteExpiredEvents(LocalDate.of(year, month, futureDateTwo),
        LocalDate.of(year, month, toDate));
    assertEquals(Calendar.getFourteenDaysCell(1), expectedDayTwoList);
    assertEquals(Calendar.getFourteenDaysCell(0), expectedTodayList);
  }

  /**
   * This method.
   */
  @Ignore
  @Test
  public void testDaysInitializer() {
    fail("Not yet implemented");
  }

}

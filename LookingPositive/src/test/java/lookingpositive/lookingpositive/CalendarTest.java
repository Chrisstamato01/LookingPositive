package lookingpositive.lookingpositive;

import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalendarTest {
  /**
   * Age.
   */
  static final int AGE = 19;

  /**
   * This method creates profiles for testing later.
   *
   * @throws Exception
   */
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    Calendar.fillingFourteenDays();
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
   *
   * @throws Exception
   */
  @Before
  public void setUp() throws Exception {
  }

  /**
   * This method .
   *
   * @throws Exception
   */
  @After
  public void tearDown() throws Exception {
  }

  /**
   * This method checks if method addToCalendar is working as supposed.
   *
   * @throws Exception
   */
  @Test
  public void testAddToCalendar() {
    ArrayList<Profile> list = new ArrayList<Profile>();
    list.add(Profile.profilesLine(0));
    list.add(Profile.profilesLine(1));
    list.add(Profile.profilesLine(2));
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
  public void testDeleteExpiredEvents() {
    final int magicNumber = 3;
    Calendar.fillingFourteenDays();

    ArrayList<Profile> list = new ArrayList<Profile>();
    list.add(Profile.profilesLine(0));
    list.add(Profile.profilesLine(1));
    list.add(Profile.profilesLine(2));

    ArrayListOfArrayList expectedDayOneList = new ArrayListOfArrayList();
    ArrayListOfArrayList expectedDayTwoList = new ArrayListOfArrayList();
    ArrayListOfArrayList expectedDayThreeList = new ArrayListOfArrayList();
    ArrayListOfArrayList expectedDayFourList = new ArrayListOfArrayList();

    Event event1 = new Event(LocalDate.now(), Geography.getFacilitiesLine(0),
        list);
    Calendar.getToday().addEventToUsersList(0, event1);
    Calendar.getToday().addEventToUsersList(1, event1);
    Calendar.getToday().addEventToUsersList(2, event1);
    Calendar.getToday().addEventToUsersList(magicNumber, event1);

    expectedDayOneList.createArrayListOfEvents();
    expectedDayOneList.createArrayListOfEvents();
    expectedDayOneList.createArrayListOfEvents();
    expectedDayOneList.createArrayListOfEvents();
    expectedDayOneList.addEventToUsersList(0, event1);
    expectedDayOneList.addEventToUsersList(1, event1);
    expectedDayOneList.addEventToUsersList(2, event1);
    expectedDayOneList.addEventToUsersList(magicNumber, event1);

    Calendar.deleteExpiredEvents(LocalDate.now().plusDays(1), LocalDate.now());
    assertEquals(Calendar.getFourteenDaysCell(0).getUserListOfEvents(0),
        expectedDayOneList.getUserListOfEvents(0));
    assertEquals(Calendar.getFourteenDaysCell(0).getUserListOfEvents(1),
        expectedDayOneList.getUserListOfEvents(1));
    assertEquals(Calendar.getFourteenDaysCell(0).getUserListOfEvents(2),
        expectedDayOneList.getUserListOfEvents(2));
    assertEquals(
        Calendar.getFourteenDaysCell(0).getUserListOfEvents(magicNumber),
        expectedDayOneList.getUserListOfEvents(magicNumber));

    expectedDayTwoList.createArrayListOfEvents();
    expectedDayTwoList.createArrayListOfEvents();
    expectedDayTwoList.createArrayListOfEvents();
    expectedDayTwoList.createArrayListOfEvents();
    expectedDayTwoList.addEventToUsersList(0, event1);
    expectedDayTwoList.addEventToUsersList(1, event1);
    expectedDayTwoList.addEventToUsersList(2, event1);
    expectedDayTwoList.addEventToUsersList(magicNumber, event1);

    Calendar.deleteExpiredEvents(LocalDate.now().plusDays(2),
        LocalDate.now().plusDays(1));
    assertEquals(Calendar.getFourteenDaysCell(1).getUserListOfEvents(0),
        expectedDayTwoList.getUserListOfEvents(0));
    assertEquals(Calendar.getFourteenDaysCell(1).getUserListOfEvents(1),
        expectedDayTwoList.getUserListOfEvents(1));
    assertEquals(Calendar.getFourteenDaysCell(1).getUserListOfEvents(2),
        expectedDayTwoList.getUserListOfEvents(2));
    assertEquals(
        Calendar.getFourteenDaysCell(1).getUserListOfEvents(magicNumber),
        expectedDayTwoList.getUserListOfEvents(magicNumber));

    expectedDayThreeList.createArrayListOfEvents();
    expectedDayThreeList.createArrayListOfEvents();
    expectedDayThreeList.createArrayListOfEvents();
    expectedDayThreeList.createArrayListOfEvents();
    expectedDayThreeList.addEventToUsersList(0, event1);
    expectedDayThreeList.addEventToUsersList(1, event1);
    expectedDayThreeList.addEventToUsersList(2, event1);
    expectedDayThreeList.addEventToUsersList(magicNumber, event1);

    Calendar.deleteExpiredEvents(LocalDate.now().plusDays(magicNumber),
        LocalDate.now().plusDays(2));
    assertEquals(Calendar.getFourteenDaysCell(2).getUserListOfEvents(0),
        expectedDayThreeList.getUserListOfEvents(0));
    assertEquals(Calendar.getFourteenDaysCell(2).getUserListOfEvents(1),
        expectedDayThreeList.getUserListOfEvents(1));
    assertEquals(Calendar.getFourteenDaysCell(2).getUserListOfEvents(2),
        expectedDayThreeList.getUserListOfEvents(2));
    assertEquals(
        Calendar.getFourteenDaysCell(2).getUserListOfEvents(magicNumber),
        expectedDayThreeList.getUserListOfEvents(magicNumber));

    expectedDayFourList.createArrayListOfEvents();
    expectedDayFourList.createArrayListOfEvents();
    expectedDayFourList.createArrayListOfEvents();
    expectedDayFourList.createArrayListOfEvents();
    expectedDayFourList.addEventToUsersList(0, event1);
    expectedDayFourList.addEventToUsersList(1, event1);
    expectedDayFourList.addEventToUsersList(2, event1);
    expectedDayFourList.addEventToUsersList(magicNumber, event1);

    Calendar.deleteExpiredEvents(LocalDate.now().plusDays(magicNumber),
        LocalDate.now().plusDays(2));
    assertEquals(
        Calendar.getFourteenDaysCell(magicNumber).getUserListOfEvents(0),
        expectedDayFourList.getUserListOfEvents(0));
    assertEquals(
        Calendar.getFourteenDaysCell(magicNumber).getUserListOfEvents(1),
        expectedDayFourList.getUserListOfEvents(1));
    assertEquals(
        Calendar.getFourteenDaysCell(magicNumber).getUserListOfEvents(2),
        expectedDayFourList.getUserListOfEvents(2));
    assertEquals(Calendar.getFourteenDaysCell(magicNumber).getUserListOfEvents(
        magicNumber), expectedDayFourList.getUserListOfEvents(magicNumber));

  }

  /**
   * This method.
   */
  @Test
  public void testDaysInitializer() {
    ArrayListOfArrayList expectedInitializerSize = new ArrayListOfArrayList();
    expectedInitializerSize.createArrayListOfEvents();
    expectedInitializerSize.createArrayListOfEvents();
    expectedInitializerSize.createArrayListOfEvents();
    expectedInitializerSize.createArrayListOfEvents();
    Calendar.fillingFourteenDays();
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
    assertEquals(expectedInitializerSize.giveEventListsSize(),
        Calendar.getToday().giveEventListsSize());
    assertEquals(Calendar.getFuture().giveEventListsSize(),
        expectedInitializerSize.giveEventListsSize());
    assertEquals(Calendar.getFourteenDaysCell(dayOne).giveEventListsSize(),
        expectedInitializerSize.giveEventListsSize());
    assertEquals(Calendar.getFourteenDaysCell(dayTwo).giveEventListsSize(),
        expectedInitializerSize.giveEventListsSize());
    assertEquals(Calendar.getFourteenDaysCell(dayThree).giveEventListsSize(),
        expectedInitializerSize.giveEventListsSize());
    assertEquals(Calendar.getFourteenDaysCell(dayFour).giveEventListsSize(),
        expectedInitializerSize.giveEventListsSize());
    assertEquals(Calendar.getFourteenDaysCell(dayFive).giveEventListsSize(),
        expectedInitializerSize.giveEventListsSize());
    assertEquals(Calendar.getFourteenDaysCell(daySix).giveEventListsSize(),
        expectedInitializerSize.giveEventListsSize());
    assertEquals(Calendar.getFourteenDaysCell(daySeven).giveEventListsSize(),
        expectedInitializerSize.giveEventListsSize());
    assertEquals(Calendar.getFourteenDaysCell(dayEight).giveEventListsSize(),
        expectedInitializerSize.giveEventListsSize());
    assertEquals(Calendar.getFourteenDaysCell(dayNine).giveEventListsSize(),
        expectedInitializerSize.giveEventListsSize());
    assertEquals(Calendar.getFourteenDaysCell(dayTen).giveEventListsSize(),
        expectedInitializerSize.giveEventListsSize());
    assertEquals(Calendar.getFourteenDaysCell(dayEleven).giveEventListsSize(),
        expectedInitializerSize.giveEventListsSize());
    assertEquals(Calendar.getFourteenDaysCell(dayTwelve).giveEventListsSize(),
        expectedInitializerSize.giveEventListsSize());
    assertEquals(Calendar.getFourteenDaysCell(dayThirteen).giveEventListsSize(),
        expectedInitializerSize.giveEventListsSize());
    assertEquals(Calendar.getFourteenDaysCell(dayFourteen).giveEventListsSize(),
        expectedInitializerSize.giveEventListsSize());
  }

  /**
   * This method .
   *
   * @throws Exception
   */
  @AfterClass
  public static void tearDownAfterClass() throws Exception {
    final int dayFourteen = 13;
    Calendar.getToday().clearArrayListOfArrayList();
    Calendar.getFuture().clearArrayListOfArrayList();
    for (int i = 0; i <= dayFourteen; i++) {
      Calendar.getFourteenDaysCell(i).clearArrayListOfArrayList();
    }
    Profile.getProfiles().clear();
  }

}

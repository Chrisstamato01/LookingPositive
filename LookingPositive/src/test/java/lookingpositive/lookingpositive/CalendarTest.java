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

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    new Profile("Άννα-Μαρία","Πέτρου","Γλυφάδα",19,false,"annamariacode1","annamariapetrouu@gmail.com");
    new Profile("Χρήστος","Σταματόπουλος","Γλυφάδα",19,false,"chriscode22","chrisstamatopoulos@gmail.com");
    new Profile("Ιάσων-Χαράλαμπος","Γιαννίτσας","Βάρη-Βούλα-Βουλιαγμένη",19,false,"jasoncode25","jasongiann@gmail.gr");
    new Profile("Νικόλας","Γιαννάτος","Γλυφάδα",18,false,"nikolascode34","nikgiann@gmail.com");
    new Geography("Σούπερ Μάρκετ", "ΑΒ Βασιλοπουλος", "3Β");
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testAddToCalendar() {
    ArrayList<Profile> list = new ArrayList<Profile>();
    
    list.add(Profile.profilesSaveLine(0));
    list.add(Profile.profilesSaveLine(1));
    list.add(Profile.profilesSaveLine(2));
    Event event1= new Event(LocalDate.now(),Geography.getFacilitiesLine(0),list);
    Calendar.addToCalendar(event1, 0);
    
    ArrayList<Event> expectedTodayFirstUser = new ArrayList<Event>();
    expectedTodayFirstUser.add(event1);
    
    assertEquals(Calendar.getToday().getUsersEventListsSize(0),expectedTodayFirstUser.size());
    assertEquals(Calendar.getToday().getUserListOfEvents(0),expectedTodayFirstUser);
  }

  @Ignore
  @Test
  public void testDeleteExpiredEvents() {
    
  }
  @Ignore
  @Test
  public void testDaysInitializer() {
    fail("Not yet implemented");
  }

}

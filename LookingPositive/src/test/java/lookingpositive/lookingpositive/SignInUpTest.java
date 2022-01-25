/**
 * This class belongs to package lookingpositive.lookingpositive.
 */
package lookingpositive.lookingpositive;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class SignInUpTest {
  /**
   * This method creates profiles for testing later.
   *
   * @throws Exception
   */
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    Calendar.fillingFourteenDays();
    final int year = 2001;
    final int month = 02;
    final int day = 04;

    final LocalDate date = LocalDate.of(year, month, day);
    new Profile("Anna-Maria", "Petrou", "1", date, false,
        "111122223", "anna.maria@gmail.com");
  }
/**
 *
 */
  @Test
  public void checkUserTest() {
    final String mail = "nomail@gmail.com";
    final String pass = "11112222";
    assertEquals(SignInUp.checkUser(mail, pass), -1);
    final String annaMariaMail = "anna.maria@gmail.com";
    final String annaMariaPass = "111122223";
    assertEquals(SignInUp.checkUser(annaMariaMail, annaMariaPass), 0);
  }
  /**
   * This method .
   *
   * @throws Exception
   */
  @AfterClass
  public static void tearDownAfterClass() throws Exception {
      Calendar.fillingFourteenDays();
     Profile.getProfiles().clear();
     final int dayFourteen = 13;
     Calendar.getToday().clearArrayListOfArrayList();
     Calendar.getFuture().clearArrayListOfArrayList();
     for (int i = 0; i <= dayFourteen; i++) {
       Calendar.getFourteenDaysCell(i).clearArrayListOfArrayList();
     }
   }
}

/**
 * This class belongs to package lookingpositive.lookingpositive.
 */
package lookingpositive.lookingpositive;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddUserTest {

  /**
   *
   * @throws Exception
   */
  @Before
  public void setUp() throws Exception {
  }

  /**
   *
   * @throws Exception
   */
  @After
  public void tearDown() throws Exception {
  }

  /**
   * Test for alphabetCheck.
   */
  @Test
  public void alphabetCheckTest() {
    assertEquals(AddUser.alphabetCheck("Iasonas"), true);
    assertEquals(AddUser.alphabetCheck("Ιάσων"), false);
    assertEquals(AddUser.alphabetCheck("Anna-Maria"), true);
    assertEquals(AddUser.alphabetCheck("Anna Maria"), true);
    assertEquals(AddUser.alphabetCheck("Chr1stos"), false);
    assertEquals(AddUser.alphabetCheck("Vassiliki66#-3."), false);
  }
  /**
   * Test for passwordCheck.
   */
  public void passwordCheckTest() {
    assertEquals(AddUser.alphabetCheck("IasonasCode"), true);
    assertEquals(AddUser.alphabetCheck("Anna-MariaCode"), true);
    assertEquals(AddUser.alphabetCheck("Anna Maria"), false);
    assertEquals(AddUser.alphabetCheck("Chr1stos"), true);
    assertEquals(AddUser.alphabetCheck("Vassiliki66#-3."), true);
    assertEquals(AddUser.alphabetCheck("New$$Code"), true);
    assertEquals(AddUser.alphabetCheck("Κωδικος"), false);
  }

}

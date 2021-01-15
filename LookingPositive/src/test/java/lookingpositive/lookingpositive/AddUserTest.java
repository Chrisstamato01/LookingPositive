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
   *
   */
  @Test
  public void alphabetCheckTest() {
    assertEquals(AddUser.alphabetCheck("Iasonas"), true);
    assertEquals(AddUser.alphabetCheck("Anna-Maria"), true);
    assertEquals(AddUser.alphabetCheck("Anna Maria"), true);
    assertEquals(AddUser.alphabetCheck("Chr1stos"), false);
    assertEquals(AddUser.alphabetCheck("Vassiliki66#-3."), false);
  }

}

package lookingpositive.lookingpositive;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SignInUpTest {
/**
 *
 * @throws Exception
 */
  @Before
  public void setUp() throws Exception {
    final int nineteen = 19;
    new Profile("Anna-Maria", "Petrou", "1", nineteen, false,
        "111122223", "anna.maria@gmail.com");
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
  public void checkUserTest() {
    final String mail = "nomail@gmail.com";
    final String pass = "11112222";
    assertEquals(SignInUp.checkUser(mail, pass), -1);
    final String annaMariaMail = "anna.maria@gmail.com";
    final String annaMariaPass = "111122223";
    assertEquals(SignInUp.checkUser(annaMariaMail, annaMariaPass), 0);
  }
}

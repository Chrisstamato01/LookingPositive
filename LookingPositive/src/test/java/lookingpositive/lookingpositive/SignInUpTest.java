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
    final String pass = "1111";
    assertEquals(SignInUp.checkUser(mail, pass), -1);
  }

}

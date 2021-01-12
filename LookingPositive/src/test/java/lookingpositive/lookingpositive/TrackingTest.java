package lookingpositive.lookingpositive;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TrackingTest {

  /**
   * @throws Exception
   */
  @Before
  public void setUp() throws Exception {
  }

  /**
   * @throws Exception
   */
  @After
  public void tearDown() throws Exception {
  }

  /**
   *Remove Duplicates from an ArrayList.
   */
  @Test
  public void testRemoveDuplicates() {
    ArrayList<String> actual = new ArrayList<String>();
    actual.add("a");
    actual.add("b");
    actual.add("b");
    actual.add("c");
    ArrayList<String> expected = new ArrayList<String>();
    expected.add("a");
    expected.add("b");
    expected.add("c");
    assertEquals(Tracking.removeDuplicates(actual), expected);
  }

}

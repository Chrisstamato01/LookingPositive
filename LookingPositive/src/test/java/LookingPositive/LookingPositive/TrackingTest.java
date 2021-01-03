package LookingPositive.LookingPositive;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TrackingTest {

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class TestUtil {
  Util c;

  @Before
  public void setUp() { c = new Util(); }

  @Test
  public void example() { assertTrue(true); }

  @Test
  public void oneParam() {
  	assertFalse(c.compute(2));
  }

  @Test
  public void evenParams() {
  	assertFalse(c.compute(1, 2));
  }

  @Test(expected = RuntimeException.class)
  public void zero() {
  	c.compute(1, 2, 0);
  }

  @Test
  public void sumDivisible() {
  	assertTrue(c.compute(3, 2, 1));
  }
}
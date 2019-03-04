import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import org.mockito.internal.verification.Times;

import org.junit.Test;

public class TestCompute {
  Compute c;

  @Test
  public void example() {
    MessageQueue mq = mock(MessageQueue.class);
    c = new Compute(mq);
    assertTrue(true);
  }

  @Test
  public void zeroSize() {
  	MessageQueue mq = mock(MessageQueue.class);
  	c = new Compute(mq);
  	when(mq.size()).thenReturn(0);

  	assertEquals(-1, c.countNumberOfOccurrences("samet"));
  	verify(mq, new Times(1)).size();
  }

  @Test
  public void notContains() {
  	MessageQueue mq = mock(MessageQueue.class);
  	c = new Compute(mq);
  	when(mq.size()).thenReturn(1);
  	when(mq.contains(anyString())).thenReturn(false);

  	assertEquals(0, c.countNumberOfOccurrences("samet"));
  	verify(mq, new Times(1)).size();
  	verify(mq, new Times(1)).contains(anyString());
  }

  @Test
  public void oneOccurence() {
  	MessageQueue mq = mock(MessageQueue.class);
  	c = new Compute(mq);
  	when(mq.size()).thenReturn(2);
  	when(mq.contains("samet")).thenReturn(true);
  	when(mq.getAt(0)).thenReturn("samet");

  	assertEquals(1, c.countNumberOfOccurrences("samet"));
  	verify(mq, new Times(4)).size();
  	verify(mq, new Times(1)).contains(anyString());
  	verify(mq, new Times(2)).getAt(anyInt());
  }
}
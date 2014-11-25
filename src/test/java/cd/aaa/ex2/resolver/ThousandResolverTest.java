package cd.aaa.ex2.resolver;

import org.junit.Test;

import static org.junit.Assert.*;

import cd.aaa.ex2.resolver.Resolver;
import cd.aaa.ex2.resolver.ThousandResolver;


public class ThousandResolverTest {
  
  Resolver r = new ThousandResolver();
  
  @Test
  public void shouldReturn0WhenNumberIsLessThan1000() {
    assertEquals(0,  r.getUnits(14));
    assertEquals(0,  r.getUnits(123));
    assertEquals(0,  r.getUnits(999));
  }

  @Test
  public void shouldReturnNumberOfThousandsWhenNumberIsGreaterThan1000() {
    assertEquals(1,  r.getUnits(1000));
    assertEquals(1,  r.getUnits(1001));
    assertEquals(10,  r.getUnits(10000));
    assertEquals(0,  r.getUnits(100000));
  }
  
  @Test
  public void shouldReturnNumberOfThousandsEvenWhenNumberIsGreaterThan90000() {
    assertEquals(91,  r.getUnits(991000));
  }

  @Test
  public void shouldReturnThousandAsDenominationString() {
    assertEquals("thousand", r.getDenomination());
  }


}

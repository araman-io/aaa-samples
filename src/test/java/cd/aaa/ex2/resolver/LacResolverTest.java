package cd.aaa.ex2.resolver;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import cd.aaa.ex2.resolver.LacResolver;

public class LacResolverTest {
  
  LacResolver r = new LacResolver();
  
  @Test
  public void shouldReturn0WhenNumberIsLessThanLac() {
    assertEquals(0,  r.getUnits(14));
    assertEquals(0,  r.getUnits(123));
    assertEquals(0,  r.getUnits(11999));
  }

  
  @Test
  public void shouldReturnNumberAtLacsPlaceWhenNumberIsGreaterThanLac() {
    assertEquals(1,  r.getUnits(167543));
    assertEquals(20,  r.getUnits(2009876));
    assertEquals(56,  r.getUnits(5609876));
    assertEquals(99,  r.getUnits(9912345));
    assertEquals(0,  r.getUnits(10000000));

  }
  
  @Test
  public void shouldReturnNumberOfLacsEvenWhenNumberIsGreaterThan99Lacs() {
    assertEquals(0,  r.getUnits(10012345));
    assertEquals(76,  r.getUnits(877691000));
  }
  
  @Test
  public void shouldReturnLacAsDenominationString() {
    assertEquals("lac", r.getDenomination());
  }


}

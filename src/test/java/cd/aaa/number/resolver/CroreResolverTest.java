package cd.aaa.number.resolver;

import static org.junit.Assert.*;

import cd.aaa.number.resolver.CroreResolver;
import cd.aaa.number.resolver.Resolver;

import org.junit.Test;

public class CroreResolverTest {
  
  Resolver r = new CroreResolver();

  @Test
  public void shouldNotReturnAnyValueForNumbersLessThanCrore() {
    
    assertEquals(0,  r.getUnits(34)); 
    assertEquals(0,  r.getUnits(1000));
    assertEquals(0,  r.getUnits(10000));
    assertEquals(0,  r.getUnits(1000000));
    assertEquals(0,  r.getUnits(9999999));
  }
  
  @Test
  public void shouldReturnValueAtCroreForNumbersMoreThanCrore() {
    
    assertEquals(1,  r.getUnits(10000000));
    assertEquals(51,  r.getUnits(510000000));
    assertEquals(99,  r.getUnits(999999999));
  }
  
  @Test
  public void shouldStillReturnValueAtCroreForNumbersMoreThanCrore() {
    
    assertEquals(0,  r.getUnits(1000000000));
  }
  
  @Test
  public void shouldReturnCroreAsDenominationString() {
    assertEquals("crore", r.getDenomination());
  }
  
  
}

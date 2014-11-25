package cd.aaa.ex2.resolver;

import org.junit.Test;

import static org.junit.Assert.*;

import cd.aaa.ex2.resolver.Resolver;
import cd.aaa.ex2.resolver.TensAndUnitsResolver;
import cd.aaa.ex2.resolver.TensResolver;

public class TensAndUnitsResolverTest {

  Resolver r = new TensAndUnitsResolver();

  @Test
  public void shouldOnlyReturnNumberOfTensAndUnitsWhenInputIsLessThan20() {

    assertEquals(19, r.getUnits(19));
    assertEquals(17, r.getUnits(17));
    assertEquals(0, r.getUnits(20));

    assertEquals(19, r.getUnits(119));
  }

  @Test
  public void shouldOnlyReturnZeroOfTensAndUnitsWhenInputIsGreaterThan20() {

    assertEquals(0, r.getUnits(20));
    assertEquals(0, r.getUnits(21));

    assertEquals(0, r.getUnits(1197));
    assertEquals(0, r.getUnits(11176));
  }

  @Test
  public void shouldReturnEmptyStringAsDenominationString() {
    assertEquals("", r.getDenomination());
  }
  
  
  @Test
  public void shouldReturnTrueWhenSameResolversAreCompared() {
    assertEquals(new TensAndUnitsResolver(), new TensAndUnitsResolver());
  }
  
  @Test
  public void shouldReturnFalseWhenDissimilarResolversAreCompared() {
    assertNotEquals(new TensAndUnitsResolver(), new TensResolver());
  }
  
}

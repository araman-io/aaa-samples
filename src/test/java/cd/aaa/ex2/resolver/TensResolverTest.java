package cd.aaa.ex2.resolver;

import org.junit.Test;

import static org.junit.Assert.*;

import cd.aaa.ex2.resolver.Resolver;
import cd.aaa.ex2.resolver.TensResolver;

public class TensResolverTest {

  Resolver r = new TensResolver();

  @Test
  public void shouldOnlyReturnZeroWhenInputIsLessThan20() {

    assertEquals(0, r.getUnits(19));
    assertEquals(0, r.getUnits(17));

    assertEquals(0, r.getUnits(119));
  }

  @Test
  public void shouldOnlyReturnNumberOfTensAndUnitsWhenInputIsGreaterThan20() {

    assertEquals(20, r.getUnits(20));
    assertEquals(21, r.getUnits(21));

    assertEquals(97, r.getUnits(1197));
    assertEquals(76, r.getUnits(11176));
  }


  @Test
  public void shouldReturnEmptyStringAsDenominationString() {
    assertEquals("", r.getDenomination());
  }

}

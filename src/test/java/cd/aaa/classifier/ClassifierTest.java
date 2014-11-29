package cd.aaa.classifier;

import static org.junit.Assert.*;

import cd.aaa.classifier.Classifier;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class ClassifierTest {
  
  @Test
  public void shouldAlwaysHaveOneAsTheFactor() {
    Classifier c = new Classifier(6);
    assertTrue("doesnt contain one as the factor" , c.getFactors().contains(new Integer(1)));
  }

  @Test
  public void verifyNumberWillAlwaysBeAFactor() {
    Classifier c = new Classifier(6);
    assertTrue("doesnt contain one as the factor" , c.getFactors().contains(new Integer(6)));
  }
  
  @Test
  public void verifyFactorsFor6() {
    Classifier c = new Classifier(6);
    Set<Integer> expectedFactors = expectedFactorSet(1, 2, 3, 6);
    assertEquals(expectedFactors, c.getFactors());
  }

  @Test
  public void verifyFactorsFor27() {
    Classifier c = new Classifier(27);
    Set<Integer> expectedFactors = expectedFactorSet(1, 3, 9, 27);
    assertEquals(expectedFactors, c.getFactors());
  }


  @Test
  public void verifyFactorsFor28() {
    Classifier c = new Classifier(28);
    Set<Integer> expectedFactors = expectedFactorSet(1, 2, 14, 4, 7, 28);
    assertEquals(expectedFactors, c.getFactors());
  }
  
  @Test
  public void verify6IsPerfect() {
    Classifier c = new Classifier(6);
    assertTrue("number isnt perfect", c.isPerfect());
  }
  
  @Test 
  public void verify16IsntPerfect() {
    Classifier c = new Classifier(16);
    System.err.println(c.sumFactors());
    assertFalse(c.isPerfect());
  }
  
  private Set<Integer> expectedFactorSet(Integer... numbers) {
    
    List<Integer> asList = Arrays.asList(numbers);
    
    return new HashSet<Integer>(asList);
  }


}

package cd.aaa.number;

import static org.junit.Assert.*;

import cd.aaa.number.SpellMap;

import org.junit.Test;

public class SpellMapTest {
  
  SpellMap dictionary = new SpellMap();

  @Test
  public void shouldSpellNumberInUnitsButBelowTens() {
    assertEquals("one", dictionary.getSpellingFor(1));
    
    assertEquals("two", dictionary.getSpellingFor(2));

    assertEquals("nine", dictionary.getSpellingFor(9));
  }
  
  @Test
  public void shouldSpellNumberInTensButBelowTwenty() {
    assertEquals("ten", dictionary.getSpellingFor(10));
    assertEquals("fourteen", dictionary.getSpellingFor(14));
    assertEquals("nineteen", dictionary.getSpellingFor(19));
  }
  
  @Test
  public void shouldSpellNumbersBetween20And99() {
    assertEquals("twenty four", dictionary.getSpellingFor(24));
    assertEquals("ninety nine", dictionary.getSpellingFor(99));
    assertEquals("eighty", dictionary.getSpellingFor(80));
    assertEquals("seventy", dictionary.getSpellingFor(70));
  }
  
  
}

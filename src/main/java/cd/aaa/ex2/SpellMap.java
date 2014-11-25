package cd.aaa.ex2;

import java.util.HashMap;
import java.util.Map;

public class SpellMap {

  Map<Integer, String> spellings = new HashMap<Integer, String>();

  public SpellMap() {
    spellings.put(0, "");
    spellings.put(1, "one");
    spellings.put(2, "two");
    spellings.put(3, "three");
    spellings.put(4, "four");
    spellings.put(5, "five");
    spellings.put(6, "six");
    spellings.put(7, "seven");
    spellings.put(8, "eight");
    spellings.put(9, "nine");
    spellings.put(10, "ten");
    spellings.put(11, "eleven");
    spellings.put(12, "twelve");
    spellings.put(13, "thirteen");
    spellings.put(14, "fourteen");
    spellings.put(15, "fifteen");
    spellings.put(16, "sixteen");
    spellings.put(17, "seventeen");
    spellings.put(18, "eighteen");
    spellings.put(19, "nineteen");
    spellings.put(20, "twenty");
    spellings.put(30, "thirty");
    spellings.put(40, "fourty");
    spellings.put(50, "fifty");
    spellings.put(60, "sixty");
    spellings.put(70, "seventy");
    spellings.put(80, "eighty");
    spellings.put(90, "ninety");
  }

  public String getSpellingFor(int number) {
    String result = null;
    StringBuilder tempResult = null;


    if (number <= 20) {

      result = spellings.get(number);

    } else {

      int tens = (number / 10) * 10;
      int units = number % 10;

      tempResult = new StringBuilder().append(spellings.get(tens));
      if (units > 0) {
        tempResult.append(" ").append(spellings.get(units));
      }

      result = tempResult.toString();
    }

    return result;
  }

}

package cd.aaa.ex3;

import java.util.ArrayList;
import java.util.List;

public abstract class Frame {

  List<Integer> chances = new ArrayList<Integer>();

  public void roll(int fallenPins) {
    chances.add(fallenPins);
  }

  public Integer frameTotal() {

    int result = 0;

    for (int i : chances) {
      result += i;
    }

    return result;
  }

  public abstract int sumOfTwoThrows();

  public boolean isSpare() {
    boolean spare = false;
    int total = 0;
    int index = 0;
    
    if ( this.isStrike())  {
      return spare;
    }
    
    for (int chance : chances) {
      if ( index < 2) {
        total += chance;
      }
      index++;
    }

    if (total == 10) {
      spare = true;
    }

    return spare;
  }

  public boolean isStrike() {
    boolean strike = false;

    if (chances.get(0) == 10) {
      strike = true;
    }

    return strike;
  }

  public int getFirstThrow() {
    return chances.get(0);
  }


}

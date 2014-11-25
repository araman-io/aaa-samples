package cd.aaa.ex3;

public class TenthFrame extends Frame {

  @Override
  public int sumOfTwoThrows() {
    int index = 0;
    int total = 0;

    for (int chance : chances) {
      if (index < 2) {
        total += chance;
      }
      index++;
    }
    
    return total;
  }

  @Override
  public void roll(int fallenPins) {
    if (chances.size() >= 3) {
      throw new IllegalArgumentException("cant roll more than thrice in the tenth frame");
    }

    super.roll(fallenPins);
  }


}

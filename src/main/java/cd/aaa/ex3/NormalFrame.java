package cd.aaa.ex3;

public class NormalFrame extends Frame {

  @Override
  public void roll(int fallenPins) {
    if (chances.size() >= 2) {
      throw new IllegalArgumentException("cant roll more than twice in a normal frame");
    }

    super.roll(fallenPins);
  }

  @Override
  public int sumOfTwoThrows() {
    return this.frameTotal();
  }

}

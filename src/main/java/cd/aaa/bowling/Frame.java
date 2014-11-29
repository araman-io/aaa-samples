package cd.aaa.bowling;

public class Frame {

	int[] chances = new int[2];

	public Frame() {
	}

	public Frame withPins(int... pins) {
		if (pins.length != 2) {
			throw new IllegalArgumentException("the number of pins should be exactly 2");
		}
		chances = pins;
		return this;
	}
	
	public int[] getPins() {
		return this.chances;
	}

	public int frameScore() {
		int result = 0;
		for (int i : chances) {
			result += i;
		}
		return result;
	}

	public boolean isSpare() {
		boolean spare = false;
		if (!this.isStrike() && frameScore() == 10) {
			spare = true;
		}
		return spare;
	}

	public boolean isStrike() {
		boolean strike = false;
		if (chances[0] == 10) {
			strike = true;
		}
		return strike;
	}

}

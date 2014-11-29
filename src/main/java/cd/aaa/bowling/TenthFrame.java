package cd.aaa.bowling;

public class TenthFrame extends Frame {

	int thirdChance = 0;

	public TenthFrame() {
		super();
	}

	public Frame withPins(int... pins) {
		if (pins.length > 3 || pins.length < 2) {
			throw new IllegalArgumentException("invalid input");
		}

		super.withPins(pins[0], pins[1]);

		if (pins.length == 3) {
			this.thirdChance = pins[2];
		}

		return this;
	}

	@Override
	public int[] getPins() {
		int[] result = new int[] {super.getPins()[0], super.getPins()[1], thirdChance};
		return result;
	}

	@Override
	public int frameScore() {
		return super.frameScore() + this.thirdChance;
	}

}

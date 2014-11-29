package cd.aaa.bowling;

public class ProceduralBowlingGame {

	int[] pins = new int[21];
	int LAST_FRAME_INDEX = 9;
	int LAST_PIN_INDEX = 20;

	public ProceduralBowlingGame(int... input) {
		for (int i = 0; i < input.length; i++) {
			this.pins[i] = input[i];
		}
	}

	public int score() {
		return this.cumulativeScoreUpto(LAST_FRAME_INDEX);
	}
	
	protected int cumulativeScoreUpto(int uptoFrame) {
		int score = 0;
		for (int frame = 0; frame <= uptoFrame; frame++) {
			score += this.scoreInFrame(frame);

			if (frameIsSpare(frame)) {
				score += bonusForSpare(frame);
			}

			if (frameIsStrike(frame)) {
				score += this.bonusForStrike(frame);
			}
		}
		return score;
	}

	protected boolean frameIsSpare(int frame) {
		boolean result = false;
		int[] framePins = this.pinsInFrame(frame);
		if (framePins[0] != 10 && this.scoreInFrame(frame) == 10) {
			result = true;
		}
		return result;
	}

	protected boolean frameIsStrike(int frame) {
		boolean result = false;
		int[] framePins = this.pinsInFrame(frame);
		if (framePins[0] == 10 && this.scoreInFrame(frame) == 10) {
			result = true;
		}
		return result;
	}

	protected int[] pinsInFrame(int frame) {
		return new int[] { this.pins[frame * 2], this.pins[frame * 2 + 1] };
	}

	protected int scoreInFrame(int frame) {
		return this.pins[frame * 2] + this.pins[frame * 2 + 1];
	}

	protected int bonusForSpare(int frame) {
		int bonus = 0;
		if ( frame == LAST_FRAME_INDEX ) {
			bonus = getLastPin();
		} else { 
			bonus = this.pins[(frame + 1) * 2];
		}
		return bonus;
	}

	protected int bonusForStrike(int frame) {
		int nextFrame = frame + 1;
		int bonus = 0;
		if (frame == LAST_FRAME_INDEX) {
			bonus = getLastPin();
		} else if (frameIsStrike(nextFrame)) {
			bonus = scoreInFrame(nextFrame) + this.bonusForStrike(nextFrame);
		} else {
			bonus = scoreInFrame(nextFrame);
		}

		return bonus;
	}
	
	protected int getLastPin() {
		return this.pins[LAST_PIN_INDEX];
	}

}

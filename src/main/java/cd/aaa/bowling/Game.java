package cd.aaa.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {

	public static int LAST_FRAME_INDEX = 9;
	List<Frame> playedFrames = new ArrayList<Frame>();
	Frame EMPTY_FRAME = new Frame().withPins(0, 0);

	public Game(int... pins) {
		int fIndex = 0;
		int numFrames = pins.length / 2;

		while (fIndex < numFrames) {
			Frame f = FrameFactory.getFrameFor(fIndex);
			f.withPins(pins[fIndex * 2], pins[fIndex * 2 + 1]);
			if (fIndex == LAST_FRAME_INDEX && pins.length == 21) {
				f.withPins(pins[fIndex * 2], pins[fIndex * 2 + 1], pins[fIndex * 2 + 2]);
			}
			playedFrames.add(f);
			fIndex++;
		}
	}

	public int score() {
		return cumulativeScore(playedFrames.size() - 1);
	}

	protected int cumulativeScore(int lastIndex) {
		int score = 0;

		for (int frameIndex = 0; frameIndex <= lastIndex; frameIndex++) {
			Frame f = playedFrames.get(frameIndex);
			score += f.frameScore();

			if (f.isSpare()) {
				score += bonusForSpareFrameAt(frameIndex);
			}

			if (f.isStrike()) {
				score += bonusForStrikeFrameAt(frameIndex);
			}
		}
		return score;
	}

	protected int bonusForStrikeFrameAt(int frameIndex) {
		int bonus = 0;
		Frame nextFrame = null;

		int nextFrameIndex = frameIndex + 1;
		nextFrame = safelyGetFrameAt(nextFrameIndex);

		if (nextFrame instanceof TenthFrame) {
			bonus = bonusStrikePoints((TenthFrame) nextFrame);
		} else {
			bonus = bonusStrikePoints(nextFrameIndex, nextFrame);
		}

		return bonus;
	}

	protected int bonusStrikePoints(int frameIndex, Frame nextFrame) {
		int bonus;
		if (nextFrame.isStrike()) {
			bonus = nextFrame.frameScore() + safelyGetFrameAt(frameIndex + 1).getPins()[0];
		} else {
			bonus = nextFrame.frameScore();
		}
		return bonus;
	}

	protected int bonusStrikePoints(TenthFrame frame) {
		int bonus;
		if (frame.isStrike()) {
			bonus = frame.getPins()[0] + frame.getPins()[2];
		} else {
			bonus = frame.getPins()[0] + frame.getPins()[1];
		}
		return bonus;
	}

	protected int bonusForSpareFrameAt(int frameIndex) {
		return safelyGetFrameAt(frameIndex + 1).getPins()[0];
	}

	private boolean pastLastFrame(int frameIndex) {
		return frameIndex >= playedFrames.size();
	}

	public List<Frame> getFrames() {
		return playedFrames;
	}

	protected Frame safelyGetFrameAt(int index) {
		if (pastLastFrame(index)) {
			return EMPTY_FRAME;
		}
		return playedFrames.get(index);
	}

}

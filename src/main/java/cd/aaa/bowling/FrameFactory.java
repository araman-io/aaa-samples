package cd.aaa.bowling;

public class FrameFactory {

	public static Frame getFrameFor(int frameIndex) {

		if (frameIndex < 0 || frameIndex > Game.LAST_FRAME_INDEX) {
			throw new IllegalArgumentException("illegal frame index " + frameIndex);
		}
		
		if (frameIndex == Game.LAST_FRAME_INDEX) {
			return new TenthFrame();
		} else {
			return new Frame();
		}

	}

}

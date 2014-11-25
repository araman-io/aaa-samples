package cd.aaa.ex3;



public class Game {

  Frame[] playedFrames = new Frame[10];

  public void roll(int frame, int fallenPins) {
    Frame rolledFrame = null;
    int adjustedFrame = frame - 1;

    rolledFrame = this.getFrameFor(adjustedFrame);
    rolledFrame.roll(fallenPins);
  }


  protected Frame getFrameFor(int frame) {

    if (playedFrames[frame] == null) {
      playedFrames[frame] = FrameFactory.getFrameFor(frame);
    }

    return playedFrames[frame];
  }


  public int framesPlayed() {
    int count = 0;
    for (Frame f : playedFrames) {
      if (f != null) {
        count++;
      }
    }
    return count;
  }


  public int gameTotal() {
    int score = 0;
    Frame currentFrame = null;
    Frame nextFrame = null;

    for (int i = 0; i < playedFrames.length; i++) {
      currentFrame = playedFrames[i];
      nextFrame = getNextFrame(i);

      if (currentFrame == null) {
        break;
      }

      score += currentFrame.frameTotal();

      if (currentFrame.isSpare() && nextFrame != null) {
        score += nextFrame.getFirstThrow();
      }

      if (currentFrame.isStrike() && nextFrame != null) {
        score += nextFrame.sumOfTwoThrows();
      }

      System.out.println("Cumulative score at frame " + i + " is " + score);

    }

    return score;
  }

  protected Frame getNextFrame(int i) {
    Frame nextFrame = null;
    if (i < playedFrames.length - 1) {
      nextFrame = playedFrames[i + 1];
    }

    return nextFrame;
  }



}

package cd.aaa.bowling;



public class FrameFactory {

  public static Frame getFrameFor(int frame) {

    if (frame < 0 || frame > 9) {
      throw new IllegalArgumentException("invalid frame " + frame);
    }
    
    if (frame == 9) {
      return new TenthFrame();
    } else {
      return new NormalFrame();
    }
    
  }

}

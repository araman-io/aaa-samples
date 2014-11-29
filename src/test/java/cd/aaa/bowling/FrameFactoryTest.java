package cd.aaa.bowling;

import org.junit.Test;

import static org.junit.Assert.*;

import cd.aaa.bowling.Frame;
import cd.aaa.bowling.FrameFactory;
import cd.aaa.bowling.NormalFrame;
import cd.aaa.bowling.TenthFrame;

public class FrameFactoryTest {
  
  @Test
  public void should_return_instance_of_normalframe_for_first_frame() {
    Frame f = FrameFactory.getFrameFor(1);
    
    assertTrue(f instanceof NormalFrame);
  }

  @Test
  public void should_return_instance_of_tenthframe_for_tenth_frame() {
    Frame f = FrameFactory.getFrameFor(9);
    
    assertTrue(f instanceof TenthFrame);
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void should_only_return_frames_for_range_1_10_upper_bound_condition() {
    FrameFactory.getFrameFor(10);
  }
  

}

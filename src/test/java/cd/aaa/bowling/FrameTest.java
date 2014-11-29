package cd.aaa.bowling;

import org.junit.Test;

import static org.junit.Assert.*;

import cd.aaa.bowling.Frame;
import cd.aaa.bowling.NormalFrame;
import cd.aaa.bowling.TenthFrame;

public class FrameTest {

  @Test
  public void frame_should_record_number_of_fallen_pins() {
    Frame f = new NormalFrame();
    f.roll(5);
    f.roll(4);

    assertEquals("count of throws doesnt match", f.frameTotal(), new Integer(9));

  }

  @Test
  public void normal_frame_should_allow_maximum_of_2_throws() {
    Frame f = new NormalFrame();
    f.roll(1);
    f.roll(3);

    assertEquals("count of throws doesnt match", f.frameTotal(), new Integer(4));
  }


  @Test(expected = IllegalArgumentException.class)
  public void normal_frame_should_not_allow_more_than_2_throws() {
    Frame f = new NormalFrame();
    f.roll(1);
    f.roll(3);
    f.roll(5);
  }

  @Test
  public void tenth_frame_should_allow_maximum_of_3_throws() {
    Frame f = new TenthFrame();
    f.roll(1);
    f.roll(3);
    f.roll(5);

    assertEquals("count of throws doesnt match", f.frameTotal(), new Integer(9));
  }

  @Test(expected = IllegalArgumentException.class)
  public void tenth_frame_should_not_allow_more_than_3_throws() {
    Frame f = new TenthFrame();
    f.roll(1);
    f.roll(3);
    f.roll(5);

    f.roll(2);
  }

  @Test
  public void frame_is_spare_when_player_knocks_all_pins_within_two_throws() {
    Frame f = new NormalFrame();
    f.roll(4);
    f.roll(6);
    assertTrue(f.isSpare());
    
    Frame tf = new TenthFrame();
    tf.roll(4);
    tf.roll(6);
    tf.roll(6);
    assertTrue(tf.isSpare());
  }
  
  @Test
  public void frame_isnt_spare_when_player_doesnt_knock_all_pins() {
    Frame f = new NormalFrame();
    f.roll(4);
    f.roll(5);
    assertFalse(f.isSpare());
  }
  
  @Test
  public void frame_is_strike_when_player_knocks_all_pins_in_first_throw() {
    Frame f = new NormalFrame();
    f.roll(10);
    assertTrue(f.isStrike());
    assertFalse(f.isSpare());
    
    Frame tf = new TenthFrame();
    tf.roll(10);
    tf.roll(4);
    tf.roll(1);
    assertTrue(tf.isStrike());    
  }
  
  @Test
  public void frame_isnt_strike_when_player_doesnt_knock_all_pins_in_first_throw() {
    Frame f = new NormalFrame();
    f.roll(4);
    f.roll(6);
    assertFalse(f.isStrike());
    
    Frame tf = new TenthFrame();
    tf.roll(4);
    tf.roll(6);
    tf.roll(6);
    assertFalse(tf.isStrike());
  }  
  
  
}

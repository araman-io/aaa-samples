package cd.aaa.bowling;

import static org.junit.Assert.*;

import org.junit.Test;

public class FrameTest {

	@Test
	public void frame_should_record_number_of_fallen_pins() {
		Frame f = new Frame().withPins(5, 4);
		assertEquals("count of throws doesnt match", f.frameScore(), 9);
	}

	@Test
	public void frame_is_spare_when_player_knocks_all_pins_within_two_throws() {
		Frame f = new Frame().withPins(4, 6);
		assertTrue(f.isSpare());
	}

	@Test
	public void frame_is_spare_even_when_player_knocks_all_pins_in_the_second_throw() {
		Frame f = new Frame().withPins(4, 6);
		assertTrue(f.isSpare());
	}

	@Test
	public void frame_isnt_spare_when_player_doesnt_knock_all_pins() {
		Frame f = new Frame().withPins(4, 5);
		assertFalse(f.isSpare());
	}

	@Test
	public void frame_is_strike_when_player_knocks_all_pins_in_first_throw() {
		Frame f = new Frame().withPins(10, 0);
		assertTrue(f.isStrike());
		assertFalse(f.isSpare());
	}

	@Test
	public void frame_isnt_strike_when_player_doesnt_knock_all_pins_in_first_throw() {
		Frame f = new Frame().withPins(0, 10);
		assertFalse(f.isStrike());
	}

	@Test(expected = IllegalArgumentException.class)
	public void frameThrowThrowExceptionWhenTryingToSetMoreThan2Pins() {
		new Frame().withPins(1, 2, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void frameThrowThrowExceptionWhenTryingToSetOnly1Pin() {
		new Frame().withPins(1);
	}

	@Test
	public void frameWillOnlyAllow2PinsToBeSet() {
		Frame f = new Frame().withPins(1, 6);
		assertEquals(7, f.frameScore());
	}

}

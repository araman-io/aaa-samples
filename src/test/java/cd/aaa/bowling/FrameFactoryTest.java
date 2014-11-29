package cd.aaa.bowling;

import static org.junit.Assert.*;

import org.junit.Test;

public class FrameFactoryTest {

	@Test
	public void should_return_instance_of_frame_for_first_frame() {
		Frame f = FrameFactory.getFrameFor(1).withPins(4, 4);
		assertTrue(f instanceof Frame);
		assertEquals(8, f.frameScore());
	}

	@Test
	public void should_return_instance_of_tenthframe_for_tenth_frame() {
		Frame f = FrameFactory.getFrameFor(9).withPins(3, 4);
		assertTrue(f instanceof TenthFrame);
		assertEquals(7, f.frameScore());
	}

	@Test
	public void should_return_instance_of_tenthframe_for_tenth_frame_with_3_pins() {
		Frame f = FrameFactory.getFrameFor(9).withPins(6, 4, 7);
		assertTrue(f instanceof TenthFrame);
		assertEquals(17, f.frameScore());
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_not_return_frame_if_index_is_past_max_frame_index() {
		FrameFactory.getFrameFor(10).withPins(1, 2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_not_return_frame_if_index_is_past_max_frame_index_with_3_pins() {
		FrameFactory.getFrameFor(10).withPins(1, 2, 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_not_return_frame_if_index_is_negative() {
		FrameFactory.getFrameFor(-1).withPins(1, 2);
	}

}

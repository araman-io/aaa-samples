package cd.aaa.bowling;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TenthFrameTest {

	@Test(expected = IllegalArgumentException.class)
	public void frameThrowThrowExceptionWhenTryingToSetMoreThan3Pins() {
		new TenthFrame().withPins(1, 2, 3, 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void frameThrowThrowExceptionWhenTryingToSetLessThan2Pins() {
		new TenthFrame().withPins(1);
	}

	@Test
	public void frameWillAllow2PinsToBeSet() {
		Frame f = new TenthFrame().withPins(1, 6);
		assertEquals(7, f.frameScore());
	}

	@Test
	public void frameWillAllowMax3PinsToBeSet() {
		Frame f = new TenthFrame().withPins(6, 4, 5);
		assertEquals(15, f.frameScore());
	}

}

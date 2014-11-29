package cd.aaa.bowling;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProceduralBowlingGameTest {

	@Test
	public void shouldReturnTheNumOfPinsFallenInANewGameWithASingleThrow() {
		ProceduralBowlingGame game = new ProceduralBowlingGame(1);
		assertEquals(1, game.score());
	}

	@Test
	public void shouldReturnTheNumOfPinsFallenInANewGameWithMultipleThrows() {
		ProceduralBowlingGame game = new ProceduralBowlingGame(1, 2, 3);
		assertEquals(6, game.score());
	}

	@Test
	public void shouldAddTheNextThrowToScoreWhenPlayerScoresASpareInAFrame() {
		ProceduralBowlingGame game = new ProceduralBowlingGame(1, 2, 6, 4, 7, 1);
		assertEquals(28, game.score());
	}

	@Test
	public void frameIsASpareWhenAllPinsFallsIn2ThrowsAndTheFirstThrowIsntAStrike() {
		ProceduralBowlingGame game = new ProceduralBowlingGame(1, 2, 6, 4, 7, 1);
		assertTrue(game.frameIsSpare(1));

		game = new ProceduralBowlingGame(1, 2, 0, 10, 7, 1);
		assertTrue(game.frameIsSpare(1));

		game = new ProceduralBowlingGame(1, 2, 10, 0, 7, 1);
		assertFalse(game.frameIsSpare(1));
	}

	@Test
	public void frameIsAStrikeWhenAllPinsFallsInTheFirstThrow() {
		ProceduralBowlingGame game = new ProceduralBowlingGame(1, 2, 6, 4, 7, 1);
		assertFalse(game.frameIsStrike(1));

		game = new ProceduralBowlingGame(1, 2, 0, 10, 7, 1);
		assertFalse(game.frameIsStrike(1));

		game = new ProceduralBowlingGame(1, 2, 10, 0, 7, 1);
		assertTrue(game.frameIsStrike(1));
	}

	@Test
	public void shouldAddTheNextThrowToScoreWhenPlayerScoresASpareInAFrameOnSecondAttempt() {
		ProceduralBowlingGame game = new ProceduralBowlingGame(1, 2, 0, 10, 7, 1);
		assertEquals(28, game.score());
	}

	@Test
	public void shouldAddTheNextTwoThrowsToScoreWhenPlayerScoresAStrikeInAFrame() {
		ProceduralBowlingGame game = new ProceduralBowlingGame(1, 2, 10, 0, 7, 1);
		assertEquals(29, game.score());
	}

	@Test
	public void bonusForStrikeFrameCanGoAcrossTwoFrames() {
		ProceduralBowlingGame game = new ProceduralBowlingGame(10, 0, 10, 0, 10, 0);

		// all frames are strikes
		assertEquals(10, game.scoreInFrame(0));
		assertEquals(20, game.bonusForStrike(0));

		assertEquals(10, game.scoreInFrame(1));
		assertEquals(10, game.bonusForStrike(1));

		assertEquals(10, game.scoreInFrame(2));
		assertEquals(0, game.bonusForStrike(2));

		assertEquals(60, game.score());
	}

	@Test
	public void scoreACompleteGameWhereLastFrameIsASpare() {
		ProceduralBowlingGame game = new ProceduralBowlingGame(1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 0, 1, 7, 3, 6, 4, 10, 0,
				2, 8, 6);
		assertTrue(game.frameIsSpare(9));
		assertEquals(10, game.scoreInFrame(9));
		assertEquals(6, game.bonusForSpare(9));
		assertEquals(133, game.score());
	}

	@Test
	public void scoreACompleteGameWhereLastFrameIsAStrike() {
		ProceduralBowlingGame game = new ProceduralBowlingGame(1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 0, 1, 7, 3, 6, 4, 10, 0,
				10, 0, 6);
		assertTrue(game.frameIsStrike(9));
		assertEquals(10, game.scoreInFrame(9));
		assertEquals(6, game.bonusForStrike(9));
		assertEquals(139, game.score());
	}

}

package cd.aaa.bowling;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	@Test
	public void shouldCreateGameWithASingleFrame() {
		Game g = new Game(1, 4);
		assertEquals(1, g.getFrames().size());
	}

	@Test
	public void shouldCreateGameWithMultipleFrames() {
		Game g = new Game(1, 4, 4, 5);
		assertEquals(2, g.getFrames().size());
	}

	@Test
	public void shouldCreateGameWithAll10FramesEachWithDoubleThrows() {
		Game g = new Game(1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 0, 1, 7, 3, 6, 4, 10, 0, 8, 1);
		assertEquals(10, g.getFrames().size());
		assertArrayEquals(new int[] { 8, 1, 0 }, g.getFrames().get(9).getPins());
	}

	@Test
	public void shouldCreateGameWithAll10FramesWithTheLastFrameHavingThreeThrows() {
		Game g = new Game(1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 0, 1, 7, 3, 6, 4, 10, 0, 8, 2, 7);
		assertEquals(10, g.getFrames().size());
		assertArrayEquals(new int[] { 8, 2, 7 }, g.getFrames().get(9).getPins());
	}

	@Test
	public void shouldScoreGamesWithASingleFrame() {
		Game g = new Game(1, 4);
		assertEquals(1, g.getFrames().size());
		assertEquals(5, g.score());
	}

	@Test
	public void shouldScoreGamesWithMultipleFrame() {
		Game g = new Game(1, 4, 4, 5, 6, 1);
		assertEquals(3, g.getFrames().size());
		assertEquals(21, g.score());
	}

	@Test
	public void shouldScoreGamesWithASpareFrame() {
		Game g = new Game(1, 4, 6, 4, 6, 1);
		assertEquals(3, g.getFrames().size());
		assertEquals(28, g.score());
	}

	@Test
	public void shouldScoreGamesWithAStrikeFrame() {
		Game g = new Game(1, 4, 10, 0, 6, 1);
		assertEquals(3, g.getFrames().size());
		assertEquals(29, g.score());
	}

	@Test
	public void shouldScoreGamesWith2ConsecutiveStrikes() {
		Game g = new Game(1, 4, 10, 0, 10, 0, 6, 1);
		assertEquals(4, g.getFrames().size());
		assertEquals(55, g.score());
	}

	@Test
	public void shouldScoreGamesWith3ConsecutiveStrikes() {
		Game g = new Game(10, 0, 10, 0, 10, 0, 7, 1);
		assertEquals(4, g.getFrames().size());
		assertEquals(83, g.score());
	}

	@Test
	public void shouldScoreGamesWithConsectutiveSpareFrame() {
		Game g = new Game(6, 4, 4, 6, 1, 0);
		assertEquals(3, g.getFrames().size());
		assertEquals(26, g.score());
	}

	@Test
	public void shouldScoreGamesEvenWhenLastFrameIsASpare() {
		Game g = new Game(1, 0, 6, 4);
		assertEquals(2, g.getFrames().size());
		assertEquals(11, g.score());
	}

	@Test
	public void shouldScoreGamesEvenWhenLastFrameIsAStrike() {
		Game g = new Game(1, 0, 10, 0);
		assertEquals(2, g.getFrames().size());
		assertEquals(11, g.score());
	}

	@Test
	public void test3ConsecutiveStrikes() {
		Game g = new Game(10, 0, 10, 0, 10, 0);
		assertEquals(3, g.getFrames().size());
		assertEquals(60, g.score());
	}

	@Test
	public void scoreACompleteGameWhereLastFrameIsASpare() {
		Game game = new Game(1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 0, 1, 7, 3, 6, 4, 10, 0, 2, 8, 6);
		assertEquals(10, game.getFrames().size());
		assertArrayEquals(new int[] { 2, 8, 6 }, game.getFrames().get(9).getPins());
		assertEquals(133, game.score());
	}

	@Test
	public void scoreACompleteGameWhereLastFrameIsAStrike() {
		Game game = new Game(1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 0, 1, 7, 3, 6, 4, 10, 0, 10, 0, 6);
		assertEquals(10, game.getFrames().size());
		assertEquals(139, game.score());
	}

}

package cd.aaa.ex3;

import org.junit.Test;

import static org.junit.Assert.*;

import cd.aaa.ex3.Game;

public class FullGameTest {

  @Test
  public void testFullGameScore() {

    Game g = new Game();
    g.roll(1, 1);
    g.roll(1, 4);
    g.roll(2, 4);
    g.roll(2, 5);
    g.roll(3, 6);
    g.roll(3, 4);
    g.roll(4, 5);
    g.roll(4, 5);
    g.roll(5, 10);
    g.roll(6, 0);
    g.roll(6, 1);
    g.roll(7, 7);
    g.roll(7, 3);
    g.roll(8, 6);
    g.roll(8, 4);
    g.roll(9, 10);
    g.roll(10, 2);
    g.roll(10, 8);
    g.roll(10, 6);

    assertEquals(133, g.gameTotal());

  }

}

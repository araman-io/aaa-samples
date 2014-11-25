package cd.aaa.ex3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import cd.aaa.ex3.Game;

public class GameTest {

  @Test
  public void should_record_frames() {
    Game g = new Game();
    g.roll(1, 3);
    g.roll(1, 4);

    assertEquals(1, g.framesPlayed());

    g = new Game();
    g.roll(1, 3);
    g.roll(1, 4);
    g.roll(2, 7);
    assertEquals(2, g.framesPlayed());
  }

  @Test
  public void should_return_0_frames_for_a_new_game() {
    Game g = new Game();
    assertEquals(0, g.framesPlayed());
  }

  @Test
  public void should_return_sum_of_all_frames_for_a_game_with_no_strike_or_spare() {

    Game g = new Game();

    g.roll(1, 3);
    g.roll(1, 4);

    g.roll(2, 7);
    g.roll(2, 1);

    g.roll(3, 1);
    g.roll(3, 1);

    assertEquals(3, g.framesPlayed());
    assertEquals(17, g.gameTotal());
  }
  
  @Test
  public void should_return_sum_of_adjancent_throw_for_a_game_with_a_spare() {

    Game g = new Game();

    g.roll(1, 3);
    g.roll(1, 7);

    g.roll(2, 7);
    g.roll(2, 1);

    assertEquals(2, g.framesPlayed());
    assertEquals(25, g.gameTotal());
  }
  

  
  @Test
  public void should_return_sum_of_adjancent_2_throws_for_a_game_with_a_strike() {

    Game g = new Game();

    g.roll(1, 10);

    g.roll(2, 7);
    g.roll(2, 1);
    
    g.roll(3, 4);
    g.roll(3, 5);

    assertEquals(3, g.framesPlayed());
    assertEquals(35, g.gameTotal());
  }
  
  @Test
  public void should_return_bonus_from_subsequent_frames() {
    Game g = new Game();

    g.roll(1, 10);
    g.roll(2, 10);
    g.roll(3, 1);
    g.roll(3, 2);
    
    assertEquals(3, g.framesPlayed());
    assertEquals(37, g.gameTotal());
    
  }
  
}

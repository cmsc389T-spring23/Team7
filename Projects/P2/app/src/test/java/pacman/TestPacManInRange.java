package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestPacManInRange extends TestCase {

  public void testPacManInRange() throws FileNotFoundException {
    NoFrame frame = new NoFrame();

    //in range
    Ghost ghost = frame.addGhost(new Location(1,1), "Billy", Color.BLUE);
    PacMan pacman = frame.addPacMan(new Location(2,1));
    assertTrue(pacman.is_ghost_in_range());
    
    // not in range
    frame = new NoFrame();
    ghost = frame.addGhost(new Location(6,1), "Billy", Color.BLUE);
    pacman = frame.addPacMan(new Location(2,1));
    assertFalse(pacman.is_ghost_in_range());
  }
}

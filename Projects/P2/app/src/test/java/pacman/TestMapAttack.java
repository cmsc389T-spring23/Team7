package pacman;
import junit.framework.*;
import java.io.*;
import java.awt.Color;

public class TestMapAttack extends TestCase {

  public void testMapAttack() throws FileNotFoundException {
        // in range
        NoFrame frame = new NoFrame();
        
        Ghost ghost = frame.addGhost(new Location(1,1), "Billy", Color.BLUE);
        PacMan pacman = frame.addPacMan(new Location(2,1));
        assertTrue(ghost.attack());
        assertTrue(frame.getMap().isGameOver());
    
        // not in range
        frame = new NoFrame(); 
        pacman = frame.addPacMan(new Location(2,1));
        ghost = frame.addGhost(new Location(6,1), "Billy", Color.BLUE);
        assertFalse(ghost.attack());
        assertFalse(frame.getMap().isGameOver());
  }
}

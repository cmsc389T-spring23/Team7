package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestGhostAttack extends TestCase {

  public void testGhostAttack() throws FileNotFoundException {
    
    NoFrame frame = new NoFrame(); 

    // They're within one of each other so pacman should be in range.
    Ghost blinky = frame.addGhost(new Location(1, 1), "blinky", Color.red); 
    PacMan pacman = frame.addPacMan(new Location(1, 2));

    assertTrue(blinky.attack());

    // Inky is nowhere near pacman so this would not work.
    Ghost inky = frame.addGhost(new Location(5, 5), "Inky", Color.CYAN); 
    assertFalse(inky.attack());
  }
}
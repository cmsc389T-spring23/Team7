package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestPacManInRange extends TestCase {

  public void testPacManInRange() throws FileNotFoundException {
    Map gameMap = new Map();

    Location pacManLoc = new Location(9, 12);
    Location ghostLoc = new Location(9, 11);
    PacMan pacMan = new PacMan(pacManLoc, gameMap);
    Ghost ghost = new Ghost(ghostLoc, gameMap, "clyde");

    gameMap.move("pacman", pacManLoc, Map.Type.PACMAN);
    gameMap.move("clyde", ghostLoc, Map.Type.GHOST);

    // Test if PacMan is in range of the ghost
    boolean result = ghost.is_pacman_in_range();
    assertTrue(result);

    //move
    Location newPacManLoc = new Location(10, 12);
    gameMap.move("pacman", newPacManLoc, Map.Type.PACMAN);
    pacMan.myLoc = newPacManLoc;

    // Test if PacMan is still in range of the ghost
    result = ghost.is_pacman_in_range();
    assertFalse(result);
  }
}

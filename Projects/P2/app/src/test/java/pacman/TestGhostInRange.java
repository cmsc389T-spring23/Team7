package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestGhostInRange extends TestCase {

  public void testGhostInRange() throws FileNotFoundException {
    Map gameMap = new Map();

    Location pacManLoc = new Location(9, 12);
    Location ghostLoc = new Location(9, 11);
    PacMan pacMan = new PacMan(pacManLoc, gameMap);
    Ghost ghost = new Ghost(ghostLoc, gameMap, "clyde");

    gameMap.move("pacman", pacManLoc, Map.Type.PACMAN);
    gameMap.move("clyde", ghostLoc, Map.Type.GHOST);

    boolean result = pacMan.is_ghost_in_range();
    assertTrue(result);

    Location newPacManLoc = new Location(10, 12);
    gameMap.move("pacman", newPacManLoc, Map.Type.PACMAN);
    pacMan.myLoc = newPacManLoc;

    result = pacMan.is_ghost_in_range();
    assertFalse(result);
  }
}

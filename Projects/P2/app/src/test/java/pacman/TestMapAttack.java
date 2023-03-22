package pacman;
import junit.framework.*;
import java.io.*;
import java.awt.Color;

public class TestMapAttack extends TestCase {

  public void testMapAttack() throws FileNotFoundException {
    Map gameMap = new Map();

    // Create PacMan and Ghost objects with their initial locations
    Location pacManLoc = new Location(9, 12);
    Location ghostLoc = new Location(9, 11);
    PacMan pacMan = new PacMan(pacManLoc, gameMap);
    Ghost ghost = new Ghost(ghostLoc, gameMap, "clyde");

    // Add PacMan and the Ghost to the map
    gameMap.move("pacman", pacManLoc, Map.Type.PACMAN);
    gameMap.move("clyde", ghostLoc, Map.Type.GHOST);

    // Test if ghost can attack PacMan
    boolean result = gameMap.attack("clyde");
    assertTrue(result);

    // Test if game is over after the attack
    assertTrue(gameMap.gameover);

    // Move PacMan to a new location
    Location newPacManLoc = new Location(10, 12);
    gameMap.move("pacman", newPacManLoc, Map.Type.PACMAN);
    pacMan.myLoc = newPacManLoc;
    gameMap.gameover = false;

    // Test if ghost can attack PacMan at the new location
    result = gameMap.attack("clyde");
    assertFalse(result);

    // Test if game is still running after the failed attack
    assertFalse(gameMap.gameover);
  }
}

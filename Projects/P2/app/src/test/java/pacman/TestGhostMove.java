package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestGhostMove extends TestCase {

  public void testGhostMove() throws FileNotFoundException {
    NoFrame frame = new NoFrame();

		Ghost ghost = frame.addGhost(new Location(1, 1), "enemy 1", Color.RED);
      Map map = frame.getMap();
      frame.startGame();
      ghost.move();
      assertEquals(true, map.getLoc(new Location(1, 2)).contains(Map.Type.GHOST) || map.getLoc(new Location(2, 1)).contains(Map.Type.GHOST));
    }
}

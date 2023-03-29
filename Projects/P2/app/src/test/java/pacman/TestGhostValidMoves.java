package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;
import java.util.ArrayList;

public class TestGhostValidMoves extends TestCase {

  public void testGhostValidMoves() throws FileNotFoundException {
    NoFrame frame = new NoFrame();
    Ghost ghost = frame.addGhost(new Location(9, 11), "name", Color.red);

    ArrayList<Location> answer=ghost.get_valid_moves();

    assertTrue(answer.contains(new Location(9,12)));
    assertFalse(answer.contains(new Location(2,2)));
    assertTrue(answer.contains(new Location(10,11)));
  }
}

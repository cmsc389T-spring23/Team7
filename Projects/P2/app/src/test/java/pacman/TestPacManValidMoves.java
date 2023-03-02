package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JComponent;

public class TestPacManValidMoves extends TestCase {

  //requires getLoc to be defined
  public void testPacManValidMoves() throws FileNotFoundException {
    PacMan pacman = new PacMan("pacman", new Location (9,11), new Map(30));
    ArrayList<Location> answer= pacman.get_valid_moves();

    assertTrue(answer.contains(new Location(9,12)));
    assertTrue(answer.contains(new Location(10,11)));
  }

}

package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestMapMove extends TestCase {

  public void testMapMove() throws FileNotFoundException {
  NoFrame frame= new NoFrame();
  PacMan pacman = frame.addPacMan(new Location(3, 5));
  Map myMap=frame.getMap();
  
  assertTrue(myMap.move("pacman", new Location (3,6), Map.Type.PACMAN));
  }
}

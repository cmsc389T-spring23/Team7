package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestMapGetLoc extends TestCase {

  public void testMapGetLoc() throws FileNotFoundException {
    NoFrame frame= null;
    try {
        frame = new NoFrame();
    } catch (FileNotFoundException e) {
        System.out.println(e);
    }

    frame.addGhost(new Location(5, 3), "enemy 1", Color.BLUE);
    frame.addPacMan(new Location(1, 1));
    Map map = frame.getMap();

    assertEquals(true, map.getLoc(new Location(5, 3)).contains(Map.Type.GHOST));
    assertEquals(true, map.getLoc(new Location(1, 1)).contains(Map.Type.PACMAN));
    }

}



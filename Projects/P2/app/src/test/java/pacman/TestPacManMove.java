package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestPacManMove extends TestCase {
  public void testPacManMove() throws FileNotFoundException {
    NoFrame frame = null;
			try {
				frame = new NoFrame();
				
			} catch (FileNotFoundException e) {
				System.out.println(e);
			}
			Map map = frame.getMap();

			PacMan pac = frame.addPacMan(new Location(1, 1));

			assertEquals(true, pac.move());
			assertEquals(true, pac.move());
			assertEquals(true, pac.move());

  }
}

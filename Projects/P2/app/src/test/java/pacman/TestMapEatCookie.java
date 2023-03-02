package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestMapEatCookie extends TestCase {

  public void testMapEatCookie() throws FileNotFoundException {
    NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

    //Creating Players
    PacMan pacman = frame.addPacMan(new Location(1, 1)); 
    CookieComponent cookie = new CookieComponent(1, 1, 0);

    frame.getMap().add("tok_x1_y1", new Location(1,1), cookie, Map.Type.COOKIE);

    // Make sure we actually eat the cookie
    assert frame.getMap().eatCookie("pacman").equals(cookie);

    // cookies var in the map was incremented
    assertEquals(frame.getMap().getCookies(), 1);
    

  }
}

package pacman;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

import javax.swing.JComponent;

import com.sun.jdi.Location;

public class PacMan {
  String myName;
  Location myLoc;
  Map myMap;
  Location shift;

  public PacMan(String name, Location loc, Map map) {
    this.myLoc = loc;
    this.myName = name;
    this.myMap = map;
  }

  public ArrayList<Location> get_valid_moves() {
   return null;
  }

  public boolean move() {
    ArrayList<Location> moves = this.get_valid_moves();
    if (moves.size() == 0) {
      return false;
    } else {
      loc = new Location(moves.get(0).x, moves.get(0).y);
      return myMap.move(myName, loc, Map.Type.PACMAN);
    }
    return true;
  }

  public boolean is_ghost_in_range() {
    return false;
  }

  public JComponent consume() {
    return null;
  }
}

package pacman;
import java.util.ArrayList;
import java.util.HashSet;

public class Ghost {
  String myName;
  Location myLoc;
  Map myMap;

  public Ghost(String name, Location loc, Map map) {
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
      myLoc = new Location(moves.get(0).x, moves.get(0).y);
      return myMap.move(myName, myLoc, Map.Type.GHOST);
    }
    return true;
  }

  public boolean is_pacman_in_range() {
    		//check above, to the right, below, and to the left of myLoc for a ghost
		if (myMap.getLoc(new Location(myLoc.x, myLoc.y + 1)).contains(Map.Type.PACMAN)
		|| myMap.getLoc(new Location(myLoc.x + 1, myLoc.y)).contains(Map.Type.PACMAN)
		|| myMap.getLoc(new Location(myLoc.x, myLoc.y - 1)).contains(Map.Type.PACMAN)
		|| myMap.getLoc(new Location(myLoc.x - 1, myLoc.y)).contains(Map.Type.PACMAN)) {
			return true;
		}

		return false;
  }

  public boolean attack() {
    if (is_pacman_in_range()) {
      return myMap.attack(myName);
    }

    return false;
  }
}

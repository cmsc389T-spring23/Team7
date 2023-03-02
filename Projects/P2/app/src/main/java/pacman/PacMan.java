package pacman;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JComponent;

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

  //Checks the 4 cardinal directions of PacMan's current locations.
  //A valid move is anything as long as we don't encounter a wall.
  public ArrayList<Location> get_valid_moves() {

    ArrayList<Location> listOfValidMoves= new ArrayList<Location>();
    
    //Checking East of current position
    if(!(myMap.getLoc(new Location (myLoc.x+1,myLoc.y))).contains(Map.Type.WALL)){
      listOfValidMoves.add(new Location(myLoc.x+1,myLoc.y));
    }

    //Checking West of current position
    if(!(myMap.getLoc(new Location (myLoc.x-1,myLoc.y))).contains(Map.Type.WALL)){
      listOfValidMoves.add(new Location(myLoc.x-1,myLoc.y));
    }
    
    //Checking North of current position
    if(!(myMap.getLoc(new Location (myLoc.x,myLoc.y+1))).contains(Map.Type.WALL)){
      listOfValidMoves.add(new Location(myLoc.x,myLoc.y+1));
    }
    
    //Checking South of current position
    if(!(myMap.getLoc(new Location (myLoc.x,myLoc.y-1))).contains(Map.Type.WALL)){
      listOfValidMoves.add(new Location(myLoc.x,myLoc.y-1));
    }

    return listOfValidMoves;
  }

  public boolean move() {
    ArrayList<Location> moves = this.get_valid_moves();
    if (moves.size() == 0) {
      return false;
    } else {
      myLoc = new Location(moves.get(0).x, moves.get(0).y);
      return myMap.move(myName, myLoc, Map.Type.PACMAN);
    }
    return true;
  }

  public boolean is_ghost_in_range() {
    Map.Type mynum = Map.Type.EMPTY;
    
		//check above, to the right, below, and to the left of myLoc for a ghost
		if (myMap.getLoc(new Location(myLoc.x, myLoc.y + 1)) != null && myMap.getLoc(new Location(myLoc.x, myLoc.y + 1)).contains(Map.Type.GHOST)
		|| myMap.getLoc(new Location(myLoc.x + 1, myLoc.y)) != null && myMap.getLoc(new Location(myLoc.x + 1, myLoc.y)).contains(Map.Type.GHOST)
		|| myMap.getLoc(new Location(myLoc.x, myLoc.y - 1)) != null && myMap.getLoc(new Location(myLoc.x, myLoc.y - 1)).contains(Map.Type.GHOST)
		|| myMap.getLoc(new Location(myLoc.x - 1, myLoc.y)) != null && myMap.getLoc(new Location(myLoc.x - 1, myLoc.y)).contains(Map.Type.GHOST)) {
			return true;
		}

		return false;
  }

  public JComponent consume() {
    return null;
  }
}

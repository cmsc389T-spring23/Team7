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

  /* 
  **Type**: `() -> ArrayList`
  **Description: This function is used to determine which spots next to PacMan are valid to move into.
  This function will return an ArrayList containing the possible options.

  This method returns all the valid moves that PacMan can make given his current position. You must
  take into account the fact that PacMan cannot move into a wall, nor should he be able to exit the
  bounds of the game. Though it would end the game, moving into a spot a ghost exists is a valid move.
  Any other decisions regarding PacMan's movements is up to you.
  */

  //*Notes for implementation */
  //Need to check the 4 directions from current location, if any of them are valid moves then we
  //add that to the arraylist. From looking at the Map file, it seems that
  //0 are walls?
  //1 are paths?
  //2 is respawn area for enemies?

  //NOTE: Need to check if the directions if PacMan can move diagonal

  //Example
  //pacman at location (9,11)
  //pacman.get_valid_moves() -> {(9,12), (10,11), (10,12)}
  public ArrayList<Location> get_valid_moves() {
    ArrayList<Location> listOfValidMoves= new ArrayList<Location>();
    
    //Checking East of current position
	//
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
    return false;
  }

  public boolean is_ghost_in_range() {
    return false;
  }

  public JComponent consume() {
    return null;
  }
}

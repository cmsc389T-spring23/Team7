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
    ArrayList<Location> listOfValidMoves= new ArrayList<Location>();
    
    int currentPositionX=this.myLoc.x;
    int currentPositionY=this.myLoc.y;

    //Note:I'm assuming that we start counting with 0 instead of 1 for the coordinates

    //Checking East of current position
    if(currentPositionX < 24 && !this.myMap.getLoc(new Location (currentPositionX+1,currentPositionY)).contains(Map.Type.WALL)){
      listOfValidMoves.add(new Location(currentPositionX+1,currentPositionY));
    }

    //Checking West of current position
    if(currentPositionX > 0 && !this.myMap.getLoc(new Location (currentPositionX-1,currentPositionY)).contains(Map.Type.WALL)){
      listOfValidMoves.add(new Location(currentPositionX-1,currentPositionY));
    }
    
    //Checking North of current position
    if(currentPositionY < 23 && !this.myMap.getLoc(new Location (currentPositionX,currentPositionY+1)).contains(Map.Type.WALL)){
      listOfValidMoves.add(new Location(currentPositionX,currentPositionY+1));
    }
    
    //Checking South of current position
    if(currentPositionY > 0 && !this.myMap.getLoc(new Location (currentPositionX,currentPositionY-1)).contains(Map.Type.WALL)){
      listOfValidMoves.add(new Location(currentPositionX,currentPositionY-1));
    }

    return listOfValidMoves;
  }

  public boolean move() {
    return false;
  }

  public boolean is_pacman_in_range() {
    return false;
  }

  public boolean attack() {
    return false;
  }
}

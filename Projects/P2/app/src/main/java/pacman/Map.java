package pacman;
import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JComponent;

public class Map {

  public enum Type {
    EMPTY,
    PACMAN,
    GHOST,
    WALL,
    COOKIE
  }

  private HashMap<Location, HashSet<Type>> field;
  private boolean gameOver;
  private int dim;

  private HashMap<String, Location> locations;
  private HashMap<String, JComponent> components;
  private HashSet<Type> emptySet;
  private HashSet<Type> wallSet;

  private int cookies = 0;

  public Map(int dim) {
    gameOver = false;
    locations = new HashMap<String, Location>();
    components = new HashMap<String, JComponent>();
    field = new HashMap<Location, HashSet<Type>>();

    emptySet = new HashSet<Type>();
    wallSet = new HashSet<Type>();
    emptySet.add(Type.EMPTY);
    wallSet.add(Type.WALL);
    this.dim = dim;
  }

  public void add(String name, Location loc, JComponent comp, Type type) {
    locations.put(name, loc);
    components.put(name, comp);
    if (!field.containsKey(loc)) field.put(loc, new HashSet<Type>());
    field.get(loc).add(type);
  }

  public int getCookies() {
    return cookies;
  }

  public boolean isGameOver() {
    return gameOver;
  }

  public boolean move(String name, Location loc, Type type) {
    Location previousSpot= locations.get(name);
    HashSet<Type> temp;

    if(type==Type.PACMAN){
      
      //Case 1, going to a valid spot (empty)
      if((getLoc(loc)).contains(Type.EMPTY)){
        //erasing previous location
        temp=getLoc(previousSpot);
        temp.remove(Type.PACMAN);
        field.put(previousSpot, temp);

        //updating PacMan's location and field
        temp=getLoc(loc);
        temp.add(Type.PACMAN);
        locations.put(name, loc);
        field.put(loc, temp);

        return true;

      //Case 2, going to a valid spot (ghost)
      }else if((getLoc(loc)).contains(Type.GHOST)){
        //erasing previous location
        temp=getLoc(previousSpot);
        temp.remove(Type.PACMAN);
        field.put(previousSpot, temp);

        //updating PacMan's location and field
        temp=getLoc(loc);
        temp.add(Type.PACMAN);
        locations.put(name, loc);
        field.put(loc, temp);

        return true;

        //Case 3, going to a valid spot (cookie)
      }else if((getLoc(loc)).contains(Type.COOKIE)){
        //erasing previous location
        temp=getLoc(previousSpot);
        temp.remove(Type.PACMAN);
        field.put(previousSpot, temp);

        //updating PacMan's location and field
        temp=getLoc(loc);
        temp.add(Type.PACMAN);
        locations.put(name, loc);
        field.put(loc, temp);

        components.put(name,eatCookie(name));

        return true;

        //going to an invalid spot(Wall)
      }else{
        return false;
      }

    }else{

      //Case 1, going to a valid spot (empty)
      if((getLoc(loc)).contains(Type.EMPTY)){
        //erasing previous location
        temp=getLoc(previousSpot);
        temp.remove(Type.GHOST);
        field.put(previousSpot, temp);

        //updating Ghost's location and field
        temp=getLoc(loc);
        temp.add(Type.GHOST);
        locations.put(name, loc);
        field.put(loc, temp);

        return true;

        //Case 2, going to a valid spot (pacman)
      }else if((getLoc(loc)).contains(Type.PACMAN)){
        //checking if the ghost's attack was successful
        if(attack(name)==true){
          //erasing previous location
          temp=getLoc(previousSpot);
          temp.remove(Type.GHOST);
          field.put(previousSpot, temp);
  
          //updating Ghost's location and field
          temp=getLoc(loc);
          temp.add(Type.GHOST);
          locations.put(name, loc);
          field.put(loc, temp);
        }
        return true;

        //Case 3, going to a valid spot (cookie)
      }else if((getLoc(loc)).contains(Type.COOKIE)){
        //erasing previous location
        temp=getLoc(previousSpot);
        temp.remove(Type.GHOST);
        field.put(previousSpot, temp);

        //updating Ghost's location and field
        temp=getLoc(loc);
        temp.add(Type.GHOST);
        locations.put(name, loc);
        field.put(loc, temp);

        return true;

        //Case 4, going to an invalid spot(Wall)
      }else{
        return false;
      }
    }
  }

  public HashSet<Type> getLoc(Location loc) {
    HashSet<Type> types = field.get(loc);
    if (types == null) {
        return emptySet;
    } else if (types.contains(Type.WALL)) {
        return wallSet;
    } else {
        return types;
    }
}



  public boolean attack(String Name) {
    Location ghost = locations.get(Name);
    if (ghost == null) {
      return false; //ghost dont exist
    } else {
      //ghost exists
      Location north = new Location(ghost.x, ghost.y -1);
      Location south = new Location(ghost.x, ghost.y +1);
      Location west = new Location(ghost.x - 1, ghost.y);
      Location east = new Location(ghost.x + 1, ghost.y);
      HashSet<Type> nTypes = this.getLoc(north);
      HashSet<Type> sTypes = this.getLoc(south);
      HashSet<Type> wTypes = this.getLoc(west);
      HashSet<Type> eTypes = this.getLoc(east);
      if (nTypes.contains(Map.Type.PACMAN) || sTypes.contains(Map.Type.PACMAN) || wTypes.contains(Map.Type.PACMAN)|| eTypes.contains(Map.Type.PACMAN)) {
        //pacman exists
        this.gameOver = true;
        return true;
      }
    }
    return false;
  }

  public JComponent eatCookie(String name) {
    // update locations, components, field, and cookies
    // the id for a cookie at (10, 1) is tok_x10_y1
    Location pacLoc = locations.get(name);
    HashSet<Type> pacField = field.get(pacLoc);

    if (pacField.contains(Type.COOKIE)) {
      String cookie_id = String.format("tok_x%d_y%d", pacLoc.x, pacLoc.y);
      pacField.remove(Type.COOKIE);
      locations.remove(cookie_id);
      cookies++;
      return components.remove(cookie_id);
    }

    return null;
  }
}

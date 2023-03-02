package pacman;
import java.util.HashMap;
import java.util.HashSet;

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
    //Case 1, going to a valid spot (empty)
    if((getLoc(loc)).contains(Type.EMPTY)){
      //finding and updating old location first
      for(Entry<Location>entry: field.keySet()){
        if(field.get(entry)== Type.PACMAN){
          field.put(entry, Type.EMPTY);
        }
      }

      //updating PacMan's location and field
      locations.put(name, loc);
      field.put(loc, Type.PACMAN);

      return true;

      //Case 2, going to a valid spot (ghost)
    }else if((getLoc(loc)).contains(Type.GHOST)){
      locations.put(name, loc);
      
      //checking if the ghost's attack failed, if so
      //PacMan won and we update PacMan position
      if(attack(name)==false){
        field.put(loc, Type.PACMAN);
      }

      return true;

      //Case 3, going to a valid spot (cookie)
    }else if((getLoc(loc)).contains(Type.COOKIE)){
      locations.put(name, loc);
      components.put(name,eatCookie(name));
      field.put(loc, Type.PACMAN);

      return true;

      //Case 4, going to an invalid spot(Wall)
    }else{
      return false;
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
    // update gameOver
    return false;
  }

  public JComponent eatCookie(String name) {
    // update locations, components, field, and cookies
    // the id for a cookie at (10, 1) is tok_x10_y1
    return null;
  }
}

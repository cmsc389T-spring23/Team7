
# PACMAN

The purpose of this project is to create a fully functioning pacman game, including ghosts 

## Authors
- [@ritviky](https://github.com/RitvikY)
- [@rishkar](https://github.com/rishkar)
- [@benjamin2jean](https://github.com/benjamin2jean)


## Demo

Insert gif or link to demo


## API

#### @rishkar functions :
- pacman - consume()
- ghost - attack()
- map - eatCookie()

#### @ritviky functions :
- pacman - move()
- ghost - move()
- map - getLoc()

#### @benjamin2jean functions :
- pacman - get_valid_moves()
- ghost - get_valid_moves()
- map - move()

#### @abhinavyedla functions :
- pacman - is_ghost_in_range()
- ghost - is_pacman_in_range()
- map - attack()

## Pacman class 
```http
  move()
```
This method will find the possible moves that the Pacman object can take using the **get_valid_moves** method. It will then choose one of these moves and adjust pacmans location accordingly
```http
  get_valid_moves()
```
This method provides a list of possible moves that PacMan can take in the 4 cardinal directions from current location of PacMan.



```java
Pacman.consume()
```
This method handles the pacman-side of things when pacman is eating a cookie. It first makes sure there's actually a cookie to be consumed, then eats it. This heavily relies on `Map.eatCookie()` to be working properly. It'll return the cookie component if the consume operation was successful.

## Pacman  Test class  
```http
  TestPacmanMove.java
```

This class will initialize a new pacman object and return true if pacman is able to move correctly in the game map
```http
  TestPacManValidMoves.java
```

This class will initialize a new Pacman object with a location and begin to test the valid possible moves. A valid move is any 1 space from the current location in the 4 cardinal directions that would not lead to a wall. 

```java
TestPacManConsume.java
```
Creates a NoFrame and initializes a cookie and pacman in the same location, then attempts to have the pacman eat the cookie.


## Ghost class 
```http
  move()
```
This method will find the possible moves that the Ghost object can take using the **get_valid_moves** method. It will then choose one of these moves and adjust ghosts location accordingly
```http
  get_valid_moves()
```
This method will find the possible moves that the Ghost object can take using the **get_valid_moves** method. It will then choose one of these moves and adjust ghosts location accordingly
```java
Ghost.attack()
```
This method will prompt the ghost to attack a pacman within the attack range. It heavily relies on the attack function in the Map class and will return a boolean depending on the success of the attack.

## Ghost  Test class  
```http
  TestGhostMove.java
```

This class will initialize a new ghost object and call the ***ghost.move()*** funtion. It will return true if a ghost is present on the correct location after ***ghost.move()*** is called
```http
  TestGhostValidMoves.java
```

This class will initialize a new Ghost object with a location and begin to test the valid possible moves. A valid move is any 1 space from the current location in the 4 cardinal directions that would not lead to a wall. 


```java
TestGhostAttack.java
```
Creates a NoFrame with a ghost and a pacman right next to it and ensures that the attack occurs successfully. Then, it creates a ghost farther away from (and therefore outside of the attack range of) the pacman, and ensures that the attack does not succeed this time.



## Map class 
```http
  getLoc()
```
 For the given location argument loc, returns the set of types currently at the location (Empty, Pacman, Cookie, Ghost, Wall).
```http
  move()
```
 This method tries to move the Objects on the board.

 ```java
Map.eatCookie()
```
This method handles the Map-side of things when pacman is eating a cookie. It will check first if pacman actually ate the cookie, then update the display accordingly by removing the cookie. It also updates an internal counter for the number of cookies eaten.

## Map  Test class  
```http
  TestMapGetLoc.java
```

This method will add a ghost and pacman object to the gameboard. It will return true if the method can correctly identify that a ghost or pacman object is present on the coordinates they were initialized on.
```http
  TestMapMove.java
```

This method will add a ghost and pacman object to the gameboard. It will return true if the method can correctly identify that a ghost or pacman object is present on the coordinates they were initialized on.

```java
TestMapEatCookie.java
```
Behaves similarly to Pacman's consume test function, creates a NoFrame and initializes a cookie and pacman in the same location, then attempts to have the pacman eat the cookie. Also ensures that the internal cookies eaten counter was updated properly.

## Run Locally
First, make sure gradle is installed locally on your computer. Then, starting from the root of the project, run the following command to start the game 

```bash
  gradle build
  gradle run
```

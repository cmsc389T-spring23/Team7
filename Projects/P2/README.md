
# PACMAN

The purpose of this project is to create a fully functioning pacman game, including ghosts 

## Authors

- [@benjamin2jean](https://github.com/benjamin2jean)

## Demo

Insert gif or link to demo


## API

#### @benjamin2jean functions :
- pacman - get_valid_moves()
- ghost - get_valid_moves()
- map - move()

## Pacman class 
```http
  get_valid_moves()
```
This method provides a list of possible moves that PacMan can take in the 4 cardinal directions from current location of PacMan.

## Pacman  Test class  
```http
  TestPacManValidMoves.java
```

This class will initialize a new Pacman object with a location and begin to test the valid possible moves. A valid move is any 1 space from the current location in the 4 cardinal directions that would not lead to a wall. 


## Ghost class 
```http
  get_valid_moves()
```
This method provides a list of possible moves that a Ghost can take in the 4 cardinal directions from current location of Ghost.
## Ghost  Test class  
```http
  TestGhostValidMoves.java
```

This class will initialize a new Ghost object with a location and begin to test the valid possible moves. A valid move is any 1 space from the current location in the 4 cardinal directions that would not lead to a wall. 




## Map class 
```http
  move()
```
 This method tries to move the Objects on the board.

## Map  Test class  
```http
  TestMapMove.java
```

 This class tries to test the move() of the Map class.
 
## Run Locally
First, make sure gradle is installed locally on your computer. 

On the terminal, run the following command to start the game 

```bash
  gradle build
  gradle run
```

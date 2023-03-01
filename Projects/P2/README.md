
# PACMAN

The purpose of this project is to create a fully functioning pacman game, including ghosts 

## Authors

- [@ritviky](https://github.com/RitvikY)





## Demo

Insert gif or link to demo


## API

#### @ritviky functions :
- pacman - move()
- ghost - move()
- map - getLoc()

## Pacman class 
```http
  move()
```
This method will find the possible moves that the Pacman object can take using the **get_valid_moves** method. It will then choose one of these moves and adjust pacmans location accordingly

## Pacman  Test class  
```http
  TestPacmanMove.java
```

This class will initialize a new pacman object and return true if pacman is able to move correctly in the game map


## Ghost class 
```http
  move()
```
This method will find the possible moves that the Ghost object can take using the **get_valid_moves** method. It will then choose one of these moves and adjust ghosts location accordingly
## Ghost  Test class  
```http
  TestGhostMove.java
```

This class will initialize a new ghost object and call the ***ghost.move()*** funtion. It will return true if a ghost is present on the correct location after ***ghost.move()*** is called



## Map class 
```http
  getLoc()
```
 For the given location argument loc, returns the set of types currently at the location (Empty, Pacman, Cookie, Ghost, Wall).

## Map  Test class  
```http
  TestMapGetLoc.java
```

This method will add a ghost and pacman object to the gameboard. It will return true if the method can correctly identify that a ghost or pacman object is present on the coordinates they were initialized on.
## Run Locally
First, make sure gradle is installed locally on your computer. 

On the terminal, run the following command to start the game 

```bash
  gradle build
  gradle run
```



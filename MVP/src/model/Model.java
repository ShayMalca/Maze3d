package model;

import java.util.ArrayList;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.SearchSolution;
import presenter.Properties;

public interface Model {
	 void generate(String mazeName);
	 Maze3d getMaze3d(String mazeName);
	 void getCrossSectionBy(String mazeName,String by, int index);
	 void saveMaze(String fileName);
	 void loadMaze(String fileName , String mazeName);
	 void mazeSize(String mazeName);
	 void fileSize(String mazeName);
	 void solveMaze(String mazeName);
	 SearchSolution<Position> getMazeSolution(String mazeName);
	 Object getUserCommand(String command);
	 void saveToZip();
	 void loadFromZip();
	 void exit();
	 void display(String mazeName);
	
	 void moveUp();
	 void moveDown();
	 void moveRight();
	 void moveLeft();
	 void moveForward();
	 void moveBackward();

	 Position getPositionFromHash(String mazeName);
	
	 void setProperties(Properties properties);
	 Properties getProperties();
}

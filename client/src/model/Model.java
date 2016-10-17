package model;


import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.SearchSolution;
import presenter.Properties;


/**
 * The Interface Model.
 */
public interface Model {
	 
 	/**
 	 * Generate.
 	 *
 	 * @param mazeName the maze name
 	 */
 	void generate(String mazeName);
	 
 	/**
 	 * Gets the maze 3 d.
 	 *
 	 * @param mazeName the maze name
 	 * @return the maze 3 d
 	 */
 	Maze3d getMaze3d(String mazeName);
	 
 	/**
 	 * Gets the cross section by.
 	 *
 	 * @param mazeName the maze name
 	 * @param by the by
 	 * @param index the index
 	 * @return the cross section by
 	 */
 	void getCrossSectionBy(String mazeName,String by, int index);
	 
 	/**
 	 * Save maze.
 	 *
 	 * @param fileName the file name
 	 */
 	void saveMaze(String fileName);
	 
 	/**
 	 * Load maze.
 	 *
 	 * @param fileName the file name
 	 * @param mazeName the maze name
 	 */
 	void loadMaze(String fileName , String mazeName);
	 
 	/**
 	 * Maze size.
 	 *
 	 * @param mazeName the maze name
 	 */
 	void mazeSize(String mazeName);
	 
 	/**
 	 * File size.
 	 *
 	 * @param mazeName the maze name
 	 */
 	void fileSize(String mazeName);
	 
 	/**
 	 * Solve maze.
 	 *
 	 * @param mazeName the maze name
 	 */
 	void solveMaze(String mazeName);
	 
 	/**
 	 * Gets the maze solution.
 	 *
 	 * @param mazeName the maze name
 	 * @return the maze solution
 	 */
 	SearchSolution<Position> getMazeSolution(String mazeName);
	 
 	/**
 	 * Gets the user command.
 	 *
 	 * @param command the command
 	 * @return the user command
 	 */
 	Object getUserCommand(String command);
	 
 	/**
 	 * Save to zip.
 	 */
 	void saveToZip();
	 
 	/**
 	 * Load from zip.
 	 */
 	void loadFromZip();
	 
 	/**
 	 * Exit.
 	 */
 	void exit();
	 
 	/**
 	 * Display.
 	 *
 	 * @param mazeName the maze name
 	 */
 	void display(String mazeName);
	
	 /**
 	 * Move up.
 	 */
// 	void moveUp();
//	 
// 	/**
// 	 * Move down.
// 	 */
// 	void moveDown();
//	 
// 	/**
// 	 * Move right.
// 	 */
// 	void moveRight();
//	 
// 	/**
// 	 * Move left.
// 	 */
// 	void moveLeft();
//	 
// 	/**
// 	 * Move forward.
// 	 */
// 	void moveForward();
//	 
// 	/**
// 	 * Move backward.
// 	 */
// 	void moveBackward();

	 /**
 	 * Gets the position from hash.
 	 *
 	 * @param mazeName the maze name
 	 * @return the position from hash
 	 */
 	Position getPositionFromHash(String mazeName);
	
	 /**
 	 * Sets the properties.
 	 *
 	 * @param properties the new properties
 	 */
 	void setProperties(Properties properties);
	 
 	/**
 	 * Gets the properties.
 	 *
 	 * @return the properties
 	 */
 	Properties getProperties();
}

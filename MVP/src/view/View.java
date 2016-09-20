package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.SearchSolution;
import presenter.Command;

public interface View  {
	
	/**
	 * V start.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void V_start() throws IOException;

	/**
	 * V display string array.
	 *
	 * @param args the args
	 */
	public void V_displayStringArray(String [] args);

	/**
	 * V display message.
	 *
	 * @param msg the msg
	 */
	public void V_displayMessage(String msg);

	/**
	 * V send commands.
	 *
	 * @param hash the hash
	 */
	public void V_setCommands(HashMap<String, Command> hash);

	/**
	 * V print maze 2 d.
	 *
	 * @param Maze2d the maze 2 d
	 */
	public void V_displayCrossSectionBy(int [][] Maze2d);

	/**
	 * V printdisplay solution.
	 *
	 * @param <T> the generic type
	 * @param posArray the pos array
	 */
	//public <T> void V_printdisplaySolution(ArrayList<SearchSolution<T>>posArray);
	public <T> void V_printdisplaySolution(ArrayList<Position> posArray);
	/**
	 * V print maze size.
	 *
	 * @param b the b
	 */
	public void V_printMazeSize(byte[] b);

	/**
	 * V print all maze.
	 *
	 * @param maze the maze
	 */
	public void V_printAllMaze(Maze3d maze);

	
	
	public void displayPosition(Position position);

	/**
	 * Exit.
	 */
	public void exit();
	









	
	

}

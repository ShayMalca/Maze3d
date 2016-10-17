package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.SearchSolution;
import presenter.Command;
import presenter.Properties;


/**
 * The Interface View.
 */
public interface View {
	
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
	 * V set commands.
	 *
	 * @param hash the hash
	 */
	public void V_setCommands(HashMap<String, Command> hash);
	
	/**
	 * V display cross section by.
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
	//public <T> void V_printdisplaySolution(ArrayList<SearchSolution<T>> posArray);
	public <T> void V_printdisplaySolution(SearchSolution<Position> posArray);
	
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
	
	/**
	 * V display position.
	 *
	 * @param position the position
	 */
	public void V_displayPosition(Position position);
	
	/**
	 * V set properties.
	 *
	 * @param prop the prop
	 */
	public void V_setProperties(Properties prop);
	
	/**
	 * Exit.
	 */
	public void exit();


}

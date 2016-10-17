package guiView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.SearchSolution;
import presenter.Command;
import presenter.Properties;
import view.AbstractView;

/**
 * The Class AbstractGuiView.
 */
public abstract class AbstractGuiView extends AbstractView {

	/**
	 * Instantiates a new abstract gui view.
	 *
	 * @param in the in
	 * @param out the out
	 */
	public AbstractGuiView(BufferedReader in, PrintWriter out) {
		super(in, out);
		// TODO Auto-generated constructor stub
	}
	
	
	public abstract void V_setProperties(Properties prop);
	public abstract void V_displayPosition(Position position);
	public abstract void V_start() throws IOException;
	public abstract void V_displayStringArray(String[] args);
	public abstract void V_displayMessage(String msg);
	public abstract void V_setCommands(HashMap<String, Command> command);
	public abstract void V_displayCrossSectionBy(int[][] Maze2d);
	public abstract <T> void V_printdisplaySolution(SearchSolution<Position> posArray);
	public abstract void V_printMazeSize(byte[] b);
	public abstract void V_printAllMaze(Maze3d maze);
	public abstract void exit();

}

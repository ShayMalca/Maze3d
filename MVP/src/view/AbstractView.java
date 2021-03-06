package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.SearchSolution;
import presenter.Command;
import presenter.Properties;

public abstract class AbstractView extends Observable implements View {

	protected BufferedReader in;
	protected PrintWriter out;
	protected HashMap<String, Command> hashStringCommand;
	protected HashMap<Command, Object> hashCommandObject;

	public AbstractView(BufferedReader in, PrintWriter out) {
		super();
		this.in = in;
		this.out = out;
		this.hashStringCommand = new HashMap<String, Command>();
		this.hashCommandObject = new HashMap<Command, Object>();
		
		
	}
	
	public abstract void V_start() throws IOException;
	public abstract void V_displayStringArray(String [] args);
	public abstract void V_displayMessage(String msg);
	public abstract void V_setCommands(HashMap<String, Command> command);
	public abstract void V_displayCrossSectionBy(int [][] Maze2d);
	public abstract <T> void V_printdisplaySolution(SearchSolution<Position> posArray);
	//public abstract <T> void V_printdisplaySolution(ArrayList<SearchSolution<T>>posArray);
	public abstract void V_printMazeSize(byte[] b);
	public abstract void V_printAllMaze(Maze3d maze);
	public abstract void exit();
	public abstract void V_setProperties(Properties prop);

}

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

public abstract class Abstruct_View extends Observable implements View {
	
	protected BufferedReader in;
	protected PrintWriter out;
	protected HashMap<String, Command> hashStringCommand;
	protected HashMap<Command, Object> hashCommandObject;
	
	public Abstruct_View(BufferedReader in, PrintWriter out) {
		super();
		this.in = in;
		this.out = out;
		this.hashStringCommand = new HashMap<String, Command>();
		this.hashCommandObject = new HashMap<Command, Object>();
	}



	@Override
	public abstract void V_start() throws IOException;

	@Override
	public abstract void V_displayStringArray(String[] args);

	@Override
	public abstract void V_displayMessage(String msg);

	@Override
	public abstract void V_setCommands(HashMap<String, Command> hash);

	@Override
	public abstract void V_displayCrossSectionBy(int[][] Maze2d);

	@Override
	public abstract <T> void V_printdisplaySolution(ArrayList<Position> posArray);
	
	//public abstract <T> void V_printdisplaySolution(ArrayList<SearchSolution<T>>posArray);
	
	@Override
	public abstract void V_printMazeSize(byte[] b);

	@Override
	public abstract void V_printAllMaze(Maze3d maze);

	@Override
	public abstract void exit();



	public void displayPosition(Position position) {
		// TODO Auto-generated method stub
		
	}

	  
}

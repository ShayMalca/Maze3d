package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.SearchSolution;
import presenter.Command;
import presenter.Properties;


public interface View {
	
	public void V_start() throws IOException;
	public void V_displayStringArray(String [] args);
	public void V_displayMessage(String msg);
	public void V_setCommands(HashMap<String, Command> hash);
	public void V_displayCrossSectionBy(int [][] Maze2d);
	//public <T> void V_printdisplaySolution(ArrayList<SearchSolution<T>> posArray);
	public <T> void V_printdisplaySolution(SearchSolution<Position> posArray);
	public void V_printMazeSize(byte[] b);
	public void V_printAllMaze(Maze3d maze);
	public void V_displayPosition(Position position);
	public void V_setProperties(Properties prop);
	public void exit();


}

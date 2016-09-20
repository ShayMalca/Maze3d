package GuiView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import presenter.Command;
import view.Abstruct_View;

public abstract class AbstractGuiView extends Abstruct_View {

	public AbstractGuiView(BufferedReader in, PrintWriter out) {
		super(in, out);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void V_start() throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void V_displayStringArray(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void V_displayMessage(String msg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void V_setCommands(HashMap<String, Command> hash) {
		// TODO Auto-generated method stub

	}

	@Override
	public void V_displayCrossSectionBy(int[][] Maze2d) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> void V_printdisplaySolution(ArrayList<Position> posArray) {
		// TODO Auto-generated method stub

	}

	@Override
	public void V_printMazeSize(byte[] b) {
		// TODO Auto-generated method stub

	}

	@Override
	public void V_printAllMaze(Maze3d maze) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub

	}

}

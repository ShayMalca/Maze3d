package View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import Controller.Command;
import Controller.Controller;
import algorihems.mazeGenerators.Maze3d;
import algorihems.mazeGenerators.Position;
import algorithms.search.SearchSolution;


/**
 * The Class MyView.
 */
public class MyView implements View {

	/** The cli. */
	private CLI cli;
	
	/** The c. */
	private Controller c;
	
	/** The in. */
	protected BufferedReader in;
	
	/** The out. */
	protected PrintWriter out;

	/** The commands. */
	protected HashMap<String,Command> commands;

	/**
	 * Instantiates a new my view.
	 *
	 * @param in the in
	 * @param out the out
	 */
	public MyView(BufferedReader in, PrintWriter out,HashMap<String,Command> commands ) {
		this.in=in;
		this.out=out;
		this.commands=commands;
	}


	/* (non-Javadoc)
	 * @see View.View#V_start()
	 */
	@Override
	public void V_start() {
		cli.start();
       
	}

	/* (non-Javadoc)
	 * @see View.View#V_displayStringArray(java.lang.String[])
	 */
	@Override
	public void V_displayStringArray(String[] args) {
		if(args!=null){
			out.println("The path is:");
			out.flush();
			for(int i=0;i<args.length;i++)
				out.write(args[i]+ "\n");
			out.flush();
			
		}
		else{
			out.println("This Array is empty");
			out.flush();
		}
	}

	/* (non-Javadoc)
	 * @see View.View#V_displayMessage(java.lang.String)
	 */
	@Override
	public void V_displayMessage(String msg) {
		out.write(msg);
		out.flush();

	}

	/* (non-Javadoc)
	 * @see View.View#V_sendCommands(java.util.HashMap)
	 */
	@Override
	public void V_sendCommands(HashMap<String, Command> hash) {
		this.cli=new CLI(in, out, hash);
	}

	/* (non-Javadoc)
	 * @see View.View#V_printMaze2d(int[][])
	 */
	@Override
	public void V_printMaze2d(int[][] Maze2d) {
		for (int i = 0; i < Maze2d[0].length; i++) {
			for (int j = 0; j < Maze2d.length; j++) {
				System.out.print(Maze2d[j][i]+" ");
			}
			System.out.println();
		}

	}

	/* (non-Javadoc)
	 * @see View.View#V_printdisplaySolution(java.util.ArrayList)
	 */
	@Override
	public <T> void V_printdisplaySolution(ArrayList<SearchSolution<T>> posArray) {
		if(posArray!=null){
			for(int i=0;i<posArray.size();i++){
				out.println(posArray.get(i)+" ");
			}
			out.flush();
		}
		else{
			out.print("The array is empty");
			out.flush();
		}
	}

	/* (non-Javadoc)
	 * @see View.View#V_printMazeSize(byte[])
	 */
	@Override
	public void V_printMazeSize(byte[] b) {
		out.println(b.length);
		out.flush();

	}

	/* (non-Javadoc)
	 * @see View.View#V_printAllMaze(algorihems.mazeGenerators.Maze3d)
	 */
	@Override
	public void V_printAllMaze(Maze3d maze) {
		maze.printMaze3d();

	}

	/* (non-Javadoc)
	 * @see View.View#V_printDir()
	 */
	@Override
	public void V_printDir() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see View.View#exit()
	 */
	@Override
	public void exit() {
		out.println("Bye Bye");
		out.flush();

	}


	/**
	 * Gets the cli.
	 *
	 * @return the cli
	 */
	public CLI getCli() {
		return cli;
	}


	/**
	 * Sets the cli.
	 *
	 * @param cli the new cli
	 */
	public void setCli(CLI cli) {
		this.cli = cli;
	}


	/**
	 * Gets the c.
	 *
	 * @return the c
	 */
	public Controller getC() {
		return c;
	}


	/**
	 * Sets the c.
	 *
	 * @param c the new c
	 */
	public void setC(Controller c) {
		this.c = c;
	}


	/**
	 * Gets the in.
	 *
	 * @return the in
	 */
	public BufferedReader getIn() {
		return in;
	}


	/**
	 * Sets the in.
	 *
	 * @param in the new in
	 */
	public void setIn(BufferedReader in) {
		this.in = in;
	}


	/**
	 * Gets the out.
	 *
	 * @return the out
	 */
	public PrintWriter getOut() {
		return out;
	}


	/**
	 * Sets the out.
	 *
	 * @param out the new out
	 */
	public void setOut(PrintWriter out) {
		this.out = out;
	}


	/**
	 * Gets the commands.
	 *
	 * @return the commands
	 */
	public HashMap<String, Command> getCommands() {
		return commands;
	}


	/**
	 * Sets the commands.
	 *
	 * @param commands the commands
	 */
	public void setCommands(HashMap<String, Command> commands) {
		this.commands = commands;
	}




}

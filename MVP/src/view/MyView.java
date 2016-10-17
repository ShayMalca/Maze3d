package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.SearchSolution;
import presenter.Command;
import presenter.Properties;


public class MyView extends AbstractView { 

	private ExecutorService threadPool;

	public MyView(BufferedReader in, PrintWriter out) {
		super(in, out);
		this.threadPool = Executors.newCachedThreadPool();
	}

	@Override
	public void V_start() throws IOException {
		new Thread(new Runnable() {

			@Override
			public void run() {
				
				try {
					out.println("please enter your command");
					out.flush();
					String command=in.readLine();
					while(!(command.equals("exit"))){
						setChanged();
						notifyObservers(command);
						try {
							threadPool.awaitTermination(2, TimeUnit.SECONDS);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						out.println("please enter your command");
						out.flush();
						command=in.readLine();
						
					}
					setChanged();
					notifyObservers(command);
					
				} catch (IOException e) {
			
					e.printStackTrace();
				}

			}
		}).start();

	}

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
			out.println("This Array is empty\n");
			out.flush();
		}

	}

	@Override
	public void V_displayMessage(String msg) {
		if (msg != null) {
			out.println(msg);
			out.flush();
		} else {
			out.println("no message!");
			out.flush();
		}

	}

	@Override
	public void V_displayCrossSectionBy(int[][] Maze2d) {
		for (int i = 0; i < Maze2d.length; i++) {
			for (int j = 0; j < Maze2d[i].length; j++) {
				out.print(Maze2d[i][j]);
			}
			out.println();
			out.flush();
		}

	}

	@Override
	public <T> void V_printdisplaySolution(SearchSolution<Position> posArray) {
		
		if(posArray!=null){
			for(int i=0;i<posArray.getSolution().size();i++){
				out.println(posArray.getSolution().get(i) +" ");
			}
			out.flush();
		}
		else{
			out.print("The array is empty\n");
			out.flush();
		}

	}
	

	@Override
	public void V_printMazeSize(byte[] b) {
		out.println(b.length);
		out.flush();

	}

	@Override
	public void V_printAllMaze(Maze3d maze) {
		maze.printMaze3d();

	}

	@Override
	public void exit() {
		out.println("Successfully closed\n");
		out.flush();

	}
	
	@Override
	public void V_setCommands(HashMap<String, Command> hash) {
		this.hashStringCommand=hash;
		
	}

	@Override
	public void V_displayPosition(Position position) {
		out.println(position);
		out.flush();
		
	}

	@Override
	public void V_setProperties(Properties prop) {
		if (!(prop.getChooseView().equals("Command line"))) {
			setChanged();
			notifyObservers("replaceUserInterface");
		}
	}



	

}

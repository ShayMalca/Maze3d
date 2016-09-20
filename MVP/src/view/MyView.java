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



public class MyView extends Abstruct_View {
	
	
	private ExecutorService threadPool;
	
	public MyView(BufferedReader in, PrintWriter out) {
		super(in,out);
		this.threadPool=Executors.newCachedThreadPool();
		
	}
	
	@Override
	public void V_start() throws IOException {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					out.println("please enter a command");
					out.flush();
					String command = in.readLine();
					while(!command.equals("exit")){
						setChanged();
						notifyObservers(command);
						try{
							threadPool.awaitTermination(2, TimeUnit.SECONDS);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						out.println("please enter a new command");
						out.flush();
						command = in.readLine();
					}
					setChanged();
					notifyObservers(command);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	public void V_displayMessage(String msg){
		if(msg!=null){
			out.println(msg);
			out.flush();
		}else{
			out.println("no message!");
			out.flush();
		}
	}
	
	
	public void V_displayStringArray(String[] args){
		if(args!=null){
			for (String s : args) {
				out.println(s);
			}
			out.flush();
		}else {
			out.println("the arry is null");
			out.flush();
		}
		
	}
	
	public void V_setCommands(HashMap<String, Command> hash){
		this.hashStringCommand=hash;
	}
	
	public void V_displayCrossSectionBy(int[][] Maze2d)
	{
		for (int i = 0; i < Maze2d.length; i++) {
			for (int j = 0; j < Maze2d[i].length; j++) {
				out.print(Maze2d[i][j]);
			}
			out.println();
			out.flush();
		}
	}
	
	public <T> void V_printdisplaySolution(ArrayList<Position> posArray) {
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
	
	@Override
	public void V_printAllMaze(Maze3d maze) {
		maze.printMaze3d();
	}
	
	@Override
	public void displayPosition(Position position) {
		out.println(position);
		out.flush();
	}
	
	
	
	@Override
	public void exit() {
		out.println("Successfully closed");
		out.flush();
	}

	@Override
	public void V_printMazeSize(byte[] b) {
		out.println(b.length);
		out.flush();
		
	}




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
					}



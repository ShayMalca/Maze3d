package Model;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import Controller.Controller;
import algorihems.mazeGenerators.GrowingTreeGeneraor;
import algorihems.mazeGenerators.Maze3d;
import algorihems.mazeGenerators.Position;
import algorihems.mazeGenerators.StackPop;
import algorithems.demo.MazeDomain;
import algorithms.search.BFSSearcher;
import algorithms.search.DFSsearcher;
import algorithms.search.SearchSolution;
import algorithms.search.Searchable;
import algorithms.search.Searcher;
import algorithms.search.Solution;
import algorithms.search.State;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;


/**
 * The Class MyModel.
 */
public class MyModel implements Model {

	/** The c. */
	private Controller c;

	/** The mazes. */
	private HashMap<String, Maze3d> mazes;

	/** The solutions. */
	private HashMap<String,SearchSolution<Position>> solutions;

	/** The threads. */
	private ArrayList<Thread> threads;

	/** The files. */
	private ArrayList<File> files;


	private StringBuilder stringBuilder;

	/**
	 * Instantiates a new my model.
	 */
	public MyModel() {
		this.mazes=new HashMap<String,Maze3d>();
		this.solutions=new HashMap<String,SearchSolution<Position>>();
		this.threads=new ArrayList<Thread>();
		this.files=new ArrayList<File>();
		this.stringBuilder=new StringBuilder();
	}



	/* (non-Javadoc)
	 * @see Model.Model#M_dir(java.lang.String)
	 */
	@Override
	public void M_dir(String path) {

		File file=new File(path.toString());
		if(file.isFile())
			c.C_displayMessage(file.toString());	

		else{
				for (File f : file.listFiles())
				{
					c.C_displayMessage(f.toString());
				}
		
			}
	}

	

	/* (non-Javadoc)
	 * @see Model.Model#M_generate3dMaze(java.lang.String, int, int, int)
	 */
	@Override
	public void M_generate3dMaze(String mazeName, int x, int y, int z) {
		Thread thread=new Thread(new Runnable() {

			@Override
			public void run() {
				Position p=new Position(x,y,z);
				Maze3d maze=new Maze3d(p);
				maze=new GrowingTreeGeneraor(new StackPop()).generate(p);
				mazes.put(mazeName, maze);
				c.C_displayMessage("maze "+ mazeName+ " is ready\n");

			}
		});
		thread.start();
		threads.add(thread);

	}

	/* (non-Javadoc)
	 * @see Model.Model#M_display(java.lang.String)
	 */
	@Override
	public void M_display(String mazeName) {

		if(!mazes.containsKey(mazeName))
		{
			c.C_displayMessage("there is no such maze in this name");

		}	
		else{
			Maze3d maze= mazes.get(mazeName);
			maze.printMaze3d();

		}
	}

	/* (non-Javadoc)
	 * @see Model.Model#M_displayCrossSectionByXYZ(java.lang.String, java.lang.String, int)
	 */
	@Override
	public void M_displayCrossSectionByXYZ(String xyz, String mazeName, int index) {
		Maze3d maze3d = mazes.get(mazeName);
		int[][] maze2d=null;
		if (maze3d==null){
			c.C_displayMessage("Maze " + mazeName + " is not exist");
			return;
		}
		try{
			switch (xyz){
			case "x":
			case "X": 
				maze2d = maze3d.getCrossSectionByX(index);
				break;
			case "y":
			case "Y":
				maze2d = maze3d.getCrossSectionByY(index);
				break;
			case "z":
			case "Z":
				maze2d = maze3d.getCrossSectionByZ(index);
				break;
			default: this.c.C_displayMessage("Invalid input!");
			}
		}catch (IndexOutOfBoundsException e){
			c.C_displayMessage("Invalid Index!");
			return;
		}
		String maze2dPrint = "";
		for (int i=0;i<maze2d.length;i++){
			for(int j=0;j<maze2d[i].length;j++){
				maze2dPrint = maze2dPrint + String.valueOf(maze2d[i][j]+ " ");
			}
			maze2dPrint = maze2dPrint + "\n";
		}
		c.C_displayMessage(maze2dPrint);
	}




	/* (non-Javadoc)
	 * @see Model.Model#M_saveMaze(java.lang.String, java.lang.String)
	 */
	@Override
	public void M_saveMaze(String mazeName, String file) {
		if(!mazes.containsKey(mazeName)){
			c.C_displayMessage("there is no such maze in this name");

		}

		else{
			try{
				Maze3d maze=mazes.get(mazeName);
				OutputStream out= new MyCompressorOutputStream(new FileOutputStream(file));
				out.write(maze.toByteArray());
				out.close();
				c.C_displayMessage("The maze " + mazeName+ " is saved successfully in the file " + file+"\n");
			}
			catch (FileNotFoundException	 e) {
				this.c.C_displayMessage("The " + file + " isn't exist\n");
			}
			catch (IOException e) {

				this.c.C_displayMessage("this maze isn't success to save\n");
			}
		}

	}

	/* (non-Javadoc)
	 * @see Model.Model#M_loadMaze(java.lang.String, java.lang.String)
	 */
	@Override
	public void M_loadMaze(String mazeName, String file) throws IOException {
		try {
			InputStream in = new MyDecompressorInputStream(new FileInputStream(file));
			byte[] bArr = new byte[50000];
			//Reads some number of bytes from the input stream and stores them into the buffer array bArr
			int numByte = in.read(bArr);
			//in.read(bArr);
			in.close();
			byte[] newbArr = new byte[numByte];
			for (int i = 0; i < newbArr.length; i++) {
				newbArr[i] = bArr[i];
			}
			Maze3d maze3d = new Maze3d(bArr);
			mazes.put(mazeName, maze3d);
			c.C_displayMessage("Maze " + mazeName + " is loaded from " + file + " file\n");
			in.close();
		} 
		catch (FileNotFoundException e) {
			c.C_displayMessage("The file " + file + " is not found\n");
		} catch (IOException e) {
			c.C_displayMessage("Error with the new maze\n");
		}
	}
	


	/* (non-Javadoc)
	 * @see Model.Model#M_mazeSize(java.lang.String)
	 */
	@Override
	public void M_mazeSize(String mazeName) {
		if(!mazes.containsKey(mazeName))
		{
			c.C_displayMessage("There such no maze like that");

		}

		else{
			Maze3d maze=mazes.get(mazeName);
			int sizeX=maze.getP().getX()*4;
			int sizeY=maze.getP().getY()*4;
			int sizeZ=maze.getP().getZ()*4;
			int size=sizeX+sizeY+sizeZ+36;
			c.C_displayMessage("The maze " + mazeName+ " the size is "+ size+"\n");

		}

	}

	/* (non-Javadoc)
	 * @see Model.Model#M_fileSize(java.lang.String)
	 */
	//back.
	@Override
	public void M_fileSize(String mazeName) {
		Maze3d maze=mazes.get(mazeName);
		if(maze==null)
			c.C_displayMessage("There in no maze with these name");

		else
		{

			ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
			MyCompressorOutputStream compressorOut = new MyCompressorOutputStream(byteArrayOut);
			try {
				compressorOut.write(maze.toByteArray());
				compressorOut.close();
				c.C_displayMessage("The size of " + mazeName + " maze in the file is: " + byteArrayOut.size()+"\n");
			} catch (IOException e) {
				c.C_displayMessage("Could not write the " + mazeName + " maze to a file");
			}
		}


	}

	/* (non-Javadoc)
	 * @see Model.Model#M_solve(java.lang.String, java.lang.String)
	 */
	@Override
	public void M_solve(String mazeName, String Algo) {
		Thread thread=new Thread(new Runnable() {

			@Override
			public void run() {
				Maze3d maze=mazes.get(mazeName);
				Searchable<Position> mazeSearch = new MazeDomain(maze);
				if(maze==null){
					c.C_displayMessage("There is no maze with this name");
				}

				else{
					Searcher<Position> myAlgo; 

					switch(Algo)
					{
					case "BFS":
						myAlgo = new BFSSearcher<Position>();
						break;

					case "DFS":
						myAlgo=new DFSsearcher<Position>();
						break;

					default:
						c.C_displayMessage("There is no such algorithms");
						return;

					}

					c.C_displayMessage("The solutin for maze "+ mazeName+ " is ready\n");
					solutions.put(mazeName, myAlgo.Search(mazeSearch));

				}

			}
		});thread.start();
		threads.add(thread);

	}

	/* (non-Javadoc)
	 * @see Model.Model#M_displaySolution(java.lang.String)
	 */
	//need to check.
	@Override
	public void M_displaySolution(String mazeName) {
		// get solution from hashMap by key (name).
		SearchSolution<Position> mySolution = solutions.get(mazeName);
		if (mySolution == null)
			c.C_displayMessage("Solution for " + mazeName + " is not exist");
		else {
			// temp arrayList to get the solution.
			ArrayList<Position> arraySolution = mySolution.getSolution();
			// concat all solution steps.
			for (int i = 0; i < arraySolution.size(); i++)
				this.stringBuilder.append(arraySolution.get(i));
			// print solution
			c.C_displayMessage("The solution for maze " + mazeName + " is:\n" + stringBuilder.toString()+"\n");
		}
	}


	/* (non-Javadoc)
	 * @see Model.Model#exit()
	 */
	@Override
	public void exit() {
		for(int i=0;i<this.threads.size();i++){
			if(this.threads.get(i)!=null){
				//ask about remove.
				this.threads.remove(i);
			}

		}

		for(int j=0;j<this.files.size();j++){
			if(this.files.get(j)!=null){
				this.files.remove(j);

			}
		}

	}

	public Controller getC() {
		return c;
	}

	public void setC(Controller c) {
		this.c = c;
	}

	public HashMap<String, Maze3d> getMazes() {
		return mazes;
	}

	public void setMazes(HashMap<String, Maze3d> mazes) {
		this.mazes = mazes;
	}

	public HashMap<String, SearchSolution<Position>> getSolutions() {
		return solutions;
	}

	public void setSolutions(HashMap<String, SearchSolution<Position>> solutions) {
		this.solutions = solutions;
	}

	public ArrayList<Thread> getThreads() {
		return threads;
	}

	public void setThreads(ArrayList<Thread> threads) {
		this.threads = threads;
	}

	public ArrayList<File> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<File> files) {
		this.files = files;
	}


}

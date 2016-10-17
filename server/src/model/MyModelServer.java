
package model;


import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;

import java.io.ObjectInputStream;

import java.io.ObjectOutputStream;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.concurrent.Callable;

import java.util.concurrent.ExecutionException;

import java.util.concurrent.Future;

import java.util.concurrent.TimeUnit;

import java.util.zip.GZIPInputStream;

import java.util.zip.GZIPOutputStream;

import algorithms.demo.MazeDomain;
import algorithms.mazeGenerators.GrowingTreeGenerator;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.mazeGenerators.RandomPop;
import algorithms.search.BFSSearcher;
import algorithms.search.DFSsearcher;
import algorithms.search.SearchSolution;
import algorithms.search.Searchable;

import algorithms.search.Searcher;

import algorithms.search.Solution;

import algorithms.search.State;



/**

 * This class extends AbstractModelServer and represent maze3d model server.

 * @param hashPosition - mapping between String and Position.

 * @param stringBuilder - for working with strings.

 * @author SHAY

 *

 */

public class MyModelServer extends AbstractModelServer {



	private HashMap<String, Position> hashPosition;

	private StringBuilder stringBuilder;

	

	/**

	 * C'tor

	 */

	public MyModelServer() {

		this.hashPosition = new HashMap<String, Position>();

		this.stringBuilder = new StringBuilder();

		//loadFromZip();

	}



	/**

	 * This method generate maze3d and return true/false if  the maze generated successfully.

	 * @param mazeName

	 * @param x

	 * @param y

	 * @param z

	 * @return boolean

	 */

	@Override

	public boolean generate(String mazeName, int x, int y, int z) {

		/*Future<Maze3d> futureCallMaze = threadPool.submit(new Callable<Maze3d>() {



			@Override

			public Maze3d call() throws Exception {

				Maze3d maze3d = new MyMaze3dGenerator().generate(x, y, z);

				hashMaze.put(mazeName, maze3d);

				hashPosition.put(mazeName, maze3d.getStartPosition());

				return maze3d;

			}

		});*/

		
        Position p=new Position(x, y, z);
		
		Maze3d maze3d = new GrowingTreeGenerator(new RandomPop()).generate(p);

		hashMaze.put(mazeName, maze3d);

		hashPosition.put(mazeName, maze3d.getStartPosition());

		System.out.println("generate finished "+mazeName);

		return true;

	}



	/**

	 * This method get a maze name return the maze

	 * @param mazeName 

	 */

	@Override

	public Maze3d getMaze3d(String mazeName) {

		Maze3d maze3d = hashMaze.get(mazeName);

		return maze3d;

	}



	/**

	 * This method solve the maze by chosen algorithm and return true/false accordingly

	 * @param mazeName

	 * @param algorithm

	 */

	@Override

	public boolean solve(String mazeName, String algorithm) {

		Maze3d maze3d = hashMaze.get(mazeName);

		SearchSolution<Position> solution = mazeSolution.get(maze3d);

		if (solution == null) {

			Future<SearchSolution<Position>> futureCallSolution = threadPool.submit(new Callable<SearchSolution<Position>>() {



				@Override

				public SearchSolution<Position> call() throws Exception {

					System.out.println("solving the maze");

					Searcher<Position> myAlgorithm;

					Searchable<Position> mazeSearchable = new MazeDomain(maze3d);

					SearchSolution<Position> solution = new SearchSolution<Position>(null);



					switch (algorithm) {

					case "BFS":

						myAlgorithm = new BFSSearcher<Position>();

						solution = myAlgorithm.Search(mazeSearchable);

						break;

					case "DFS":

						myAlgorithm = new DFSsearcher<Position>();

						solution = myAlgorithm.Search(mazeSearchable);

						break;

		
					default:

						System.out.println("Invalid algorithm");

						return null;

					}

					return solution;

				}

			});



			try {

				mazeSolution.put(maze3d, futureCallSolution.get());

				System.out.println("solve finished");

				return true;

			} catch (InterruptedException e) {

				e.printStackTrace();

				return false;

			} catch (ExecutionException e) {

				e.printStackTrace();

				return false;

			}

		} else {

			return true;

		}

	}



	/**
	 * This method return the solution of the maze.
	 *
	 * @param mazeName the maze name
	 * @return the solution
	 */

	@Override

	public String getSolution(String mazeName) {

		Maze3d maze3d = hashMaze.get(mazeName);

		if(maze3d != null){

			SearchSolution<Position> solution = mazeSolution.get(maze3d);

			ArrayList<State<Position>> solutionArrayList = solution.getSolution();

			for(int i= 0; i<solutionArrayList.size(); i++){

				stringBuilder.append(solutionArrayList.get(i));

			}	

			System.out.println(stringBuilder.toString());
			return stringBuilder.toString();
		

		}

		return null;

	}



	/**

	 * This method save the maze details to a zip file

	 */

	@Override

	public void saveToZip() {

		try {

			// save the maze to a ZIP file using GZIPOutputstream

			ObjectOutputStream mazeOut = new ObjectOutputStream(

					new GZIPOutputStream(new FileOutputStream("fileMazeZip.zip")));

			// write all the maze's list and their solution to the file

			mazeOut.writeObject(hashMaze);

			mazeOut.writeObject(mazeSolution);

			mazeOut.flush();

			mazeOut.close();



		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}



	/**

	 * This method load the maze details from a zip file

	 */

	@SuppressWarnings("unchecked")

	@Override

	public void loadFromZip() {



		try {

			FileInputStream mazeFile = new FileInputStream("fileMazeZip.zip");

			ObjectInputStream mazeIn = new ObjectInputStream(new GZIPInputStream(mazeFile));

			hashMaze = (HashMap<String, Maze3d>) mazeIn.readObject();

			mazeSolution = (HashMap<Maze3d, SearchSolution<Position>>) mazeIn.readObject();

			mazeIn.close();



		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

	}



	/**

	 * This method save and close the project orderly.

	 */

	@Override

	public void close() {

		saveToZip();

		threadPool.shutdownNow();

		try {

			while (!(threadPool.awaitTermination(10, TimeUnit.SECONDS)))

				;

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

	}

}
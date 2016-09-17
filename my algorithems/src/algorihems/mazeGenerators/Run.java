
package algorihems.mazeGenerators;

import java.util.ArrayList;
import java.util.Random;

import algorithems.demo.MazeDomain;
import algorithms.search.BFSSearcher;
import algorithms.search.Searchable;
import algorithms.search.Searcher;

// TODO: 
/**
 * The Class Run.
 */
public class Run {

	/**
	 * Test maze generator.
	 *
	 * @param mg the mg
	 */
	private static void testMazeGenerator(Maze3dGenerator mg){
		// prints the time it takes the algorithm to run
		Position p1=new Position(3,3,3);
		Maze3d maze2;
		System.out.println("Time:"+mg.measureAlgorithmTime(p1)+"\n");
		// generate another 3d maze
		Maze3d maze=mg.generate(p1);
		// get the maze entrance
		Position p=maze.getStartPosition();
		// print the position
		System.out.println("The start position:"+p); // format "{x,y,z}"
		// get all the possible moves from a position
		String[] moves=maze.isLegal(p1);
		// print the moves

		byte[] arr=maze.toByteArray();
		maze2=new Maze3d(arr);
		if(maze.equals(maze2))
		{
			System.out.println("FIRE");
		}

		for(String move : moves)
		{
			System.out.println("The next move:");
			System.out.println(move);

		}
		System.out.println("---------------- \n");
		// prints the maze exit position
		System.out.println("The Goal potision:"+maze.getGoalPosition());
		//maze.printMaze3d();
		System.out.println(maze);
		//System.out.println(maze.getCell(0, 1, 0)+"forward");
		//System.out.println(maze.getCell(0, 0, 1)+"Right");
		//System.out.println(maze.getCell(1, 0, 0)+"up");
		//maze.createPositions(p1);
		//System.out.println(maze.getGoalPosition());
		try{
			// get 2d cross sections of the 3d maze
			int[][] maze2dx=maze.getCrossSectionByX(2);
			System.out.println("Maze2d by X");
			maze.print2dMaze(maze2dx);
			int[][] maze2dy=maze.getCrossSectionByY(5);
			System.out.println("\nMaze2d by Y");
			maze.print2dMaze(maze2dy);
			int[][] maze2dz=maze.getCrossSectionByZ(0);
			System.out.println("\nMaze2d by Z");
			maze.print2dMaze(maze2dz);
			// this should throw an exception!
			maze.getCrossSectionByX(-1);
		} catch (IndexOutOfBoundsException e){
			System.out.println("good!");




		}



	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		System.out.println("SimpleMaze3d");
		testMazeGenerator(new SimpleMaze3dGenerator());
		System.out.println("--------------------------------------------");
		System.out.println("GrowingTree");
		testMazeGenerator(new GrowingTreeGeneraor(new StackPop()));
		testMazeGenerator(new GrowingTreeGeneraor(new RandomPop()));	






	}
}

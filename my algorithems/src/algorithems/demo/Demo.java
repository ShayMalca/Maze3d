package algorithems.demo;

import java.util.ArrayList;

import algorihems.mazeGenerators.GrowingTreeGeneraor;
import algorihems.mazeGenerators.Maze3d;
import algorihems.mazeGenerators.Position;
import algorihems.mazeGenerators.StackPop;
import algorithms.search.BFSSearcher;
import algorithms.search.CommonSearcher;
import algorithms.search.DFSsearcher;

public class Demo {

	static Maze3d maze;
	
	/**
	 * Run.
	 */
	public void Run(){
	        Position p= new Position(5,5,5);
			 maze=new GrowingTreeGeneraor(new StackPop()).generate(p);
	      //  maze=new SimpleMaze3dGenerator().generate(p);
			System.out.println(maze);
			System.out.println(maze.getStartPosition());
			System.out.println(maze.getGoalPosition());
		    MazeDomain mazedomian=new MazeDomain(maze);
			CommonSearcher<Position> searcher;
			ArrayList<Position> solution;
			System.out.println("*****BFS TEST:****");
			searcher = new BFSSearcher<Position>();
			solution = searcher.Search(mazedomian).getSolution();
			System.out.println("Solution path:" + solution);
			System.out.println("number of nodes evaluated:" + searcher.getNumberOfNodsEvaluated());
			
			System.out.println("*****DFS TEST:****");
			searcher = new DFSsearcher<Position>();
            solution=searcher.Search(mazedomian).getSolution();
			System.out.println("Solution path:" + solution);
			System.out.println("number of nodes evaluated:" + searcher.getNumberOfNodsEvaluated());
		
		
	}
	
	public static void main(String[] args) {
		Demo demo = new Demo();
		demo.Run();
	}
}

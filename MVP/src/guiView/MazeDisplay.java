package guiView;



import java.util.ArrayList;

import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.SearchSolution;


public abstract class MazeDisplay extends Canvas {
	
	protected Maze3d maze3d;
	protected Position currentPos;
	protected SearchSolution<Position> solution;
	
	
	
	MazeDisplay(Composite parent,int style) {
		super(parent, style);
		this.currentPos = new Position(0,0,0);
		
		// TODO Auto-generated constructor stub
		
	}



	public Maze3d getMaze3d() {
		return maze3d;
	}



	public void setMaze3d(Maze3d maze3d) {
		this.maze3d = maze3d;
	}



	public Position getCurrentPos() {
		return currentPos;
	}



	public void setCurrentPos(Position currentPos) {
		this.currentPos = currentPos;
	}







	public abstract void moveUp();
	/**
	 * move down
	 */
	public abstract  void moveDown();
	/**
	 * move left
	 */
	public abstract  void moveLeft();
	/**
	 * move right
	 */
	public  abstract void moveRight();
	/**
	 * move forward
	 */
	public abstract  void moveForward();
	/**
	 * move back
	 */
	public  abstract void moveBack();
	
	public abstract boolean isSolving();



	public SearchSolution<Position> getSolution() {
		return solution;
	}



	public void setSolution(SearchSolution<Position> solution) {
		this.solution = solution;
	}

}

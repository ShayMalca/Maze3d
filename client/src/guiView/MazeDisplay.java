package guiView;

import java.util.ArrayList;

import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.SearchSolution;

/**
 * The Class MazeDisplay.
 */
public abstract class MazeDisplay extends Canvas {
	
	/** The maze 3 d. */
	protected Maze3d maze3d;
	
	/** The current pos. */
	protected Position currentPos;
	
	/** The solution. */
	protected SearchSolution<Position> solution;
	
	
	
	/**
	 * Instantiates a new maze display.
	 *
	 * @param parent the parent
	 * @param style the style
	 */
	MazeDisplay(Composite parent,int style) {
		super(parent, style);
		this.currentPos = new Position(0,0,0);
		
		// TODO Auto-generated constructor stub
		
	}



	/**
	 * Gets the maze 3 d.
	 *
	 * @return the maze 3 d
	 */
	public Maze3d getMaze3d() {
		return maze3d;
	}



	/**
	 * Sets the maze 3 d.
	 *
	 * @param maze3d the new maze 3 d
	 */
	public void setMaze3d(Maze3d maze3d) {
		this.maze3d = maze3d;
	}



	/**
	 * Gets the current pos.
	 *
	 * @return the current pos
	 */
	public Position getCurrentPos() {
		return currentPos;
	}



	/**
	 * Sets the current pos.
	 *
	 * @param currentPos the new current pos
	 */
	public void setCurrentPos(Position currentPos) {
		this.currentPos = currentPos;
	}


	/**
	 * Move up.
	 */
	public abstract void moveUp();
	
	/**
	 * move down.
	 */
	public abstract  void moveDown();
	
	/**
	 * move left.
	 */
	public abstract  void moveLeft();
	
	/**
	 * move right.
	 */
	public  abstract void moveRight();
	
	/**
	 * move forward.
	 */
	public abstract  void moveForward();
	
	/**
	 * move back.
	 */
	public  abstract void moveBack();
	
	/**
	 * Checks if is solving.
	 *
	 * @return true, if is solving
	 */
	public abstract boolean isSolving();



	/**
	 * Gets the solution.
	 *
	 * @return the solution
	 */
	public SearchSolution<Position> getSolution() {
		return solution;
	}



	/**
	 * Sets the solution.
	 *
	 * @param solution the new solution
	 */
	public void setSolution(SearchSolution<Position> solution) {
		this.solution = solution;
	}

}

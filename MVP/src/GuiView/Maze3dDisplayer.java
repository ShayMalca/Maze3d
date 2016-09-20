package GuiView;

import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.SearchSolution;

// TODO: Auto-generated Javadoc
/**
 * The Class Maze3dDisplayer.
 */
public class Maze3dDisplayer extends Canvas {
	
	/** The maze 3 d. */
	protected Maze3d maze3d;
	
	/** The current pos. */
	protected Position currentPos;
	
	/** The solution. */
	protected SearchSolution<Position> solution;

	/**
	 * Instantiates a new maze 3 d displayer.
	 *
	 * @param parent the parent
	 * @param style the style
	 */
	public Maze3dDisplayer(Composite parent, int style) {
		super(parent, style);
		this.currentPos=new Position(0, 0, 0);
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
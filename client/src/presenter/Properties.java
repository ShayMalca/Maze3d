package presenter;

import java.io.Serializable;

import algorithms.mazeGenerators.GrowingTreeGenerator;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.mazeGenerators.StackPop;

/**
 * The Class Properties.
 */
public class Properties implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The z. */
	private int x,y,z;
	
	/** The num of threads. */
	private int numOfThreads;
	
	/** The algo. */
	private String algo;
	
	/** The type of maze. */
	private String typeOfMaze;
	
	/** The maze name. */
	private String mazeName;
	
	/** The choose view. */
	private String chooseView;
	
	/** The axis. */
	private char axis;
	
	/** The maze. */
	private Maze3d maze;
	
	/**
	 * C'tor.
	 */
	public Properties(){
		super();
	}
	
	/**
	 * this function define default properties.
	 */
	public void defaultProperties(){
		this.x = 4;
		this.y = 4;
		this.z = 4;
		this.numOfThreads =10;
		this.algo = "BFS";
		this.typeOfMaze = "GrowingTreeGenerator";
		this.mazeName = "DefaultMaze";
		this.chooseView="Gui";
		this.axis='x';
		
	}
	
	/**
	 * setters & getters.
	 *
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Sets the x.
	 *
	 * @param x the new x
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Sets the y.
	 *
	 * @param y the new y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Gets the z.
	 *
	 * @return the z
	 */
	public int getZ() {
		return z;
	}
	
	/**
	 * Sets the z.
	 *
	 * @param z the new z
	 */
	public void setZ(int z) {
		this.z = z;
	}
	
	/**
	 * Gets the num of threads.
	 *
	 * @return the num of threads
	 */
	public int getNumOfThreads() {
		return numOfThreads;
	}
	
	/**
	 * Sets the num of threads.
	 *
	 * @param numOfThreads the new num of threads
	 */
	public void setNumOfThreads(int numOfThreads) {
		this.numOfThreads = numOfThreads;
	}
	
	/**
	 * Gets the algo.
	 *
	 * @return the algo
	 */
	public String getAlgo() {
		return algo;
	}
	
	/**
	 * Sets the algo.
	 *
	 * @param algo the new algo
	 */
	public void setAlgo(String algo) {
		this.algo = algo;
	}
	
	/**
	 * Gets the type of maze.
	 *
	 * @return the type of maze
	 */
	public String getTypeOfMaze() {
		return typeOfMaze;
	}
	
	/**
	 * Sets the type of maze.
	 *
	 * @param typeOfMaze the new type of maze
	 */
	public void setTypeOfMaze(String typeOfMaze) {
		this.typeOfMaze = typeOfMaze;
	}
	
	/**
	 * Gets the maze name.
	 *
	 * @return the maze name
	 */
	public String getMazeName() {
		return mazeName;
	}
	
	/**
	 * Sets the maze name.
	 *
	 * @param mazeName the new maze name
	 */
	public void setMazeName(String mazeName) {
		this.mazeName = mazeName;
	}
	
	/**
	 * Gets the choose view.
	 *
	 * @return the choose view
	 */
	public String getChooseView() {
		return chooseView;
	}
	
	/**
	 * Sets the choose view.
	 *
	 * @param chooseView the new choose view
	 */
	public void setChooseView(String chooseView) {
		this.chooseView = chooseView;
	}
	
	/**
	 * Gets the axis.
	 *
	 * @return the axis
	 */
	public char getAxis() {
		return axis;
	}
	
	/**
	 * Sets the axis.
	 *
	 * @param axis the new axis
	 */
	public void setAxis(char axis) {
		this.axis = axis;
	}
	
	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/**
	 * Gets the maze.
	 *
	 * @return the maze
	 */
	public Maze3d getMaze() {
		return maze;
	}
	
	/**
	 * Sets the maze.
	 *
	 * @param maze the new maze
	 */
	public void setMaze(Maze3d maze) {
		this.maze = maze;
	}

}

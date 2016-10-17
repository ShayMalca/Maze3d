package presenter;

import java.io.Serializable;

import algorithms.mazeGenerators.GrowingTreeGenerator;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.mazeGenerators.StackPop;

public class Properties implements Serializable {

	private static final long serialVersionUID = 1L;
	private int x,y,z;
	private int numOfThreads;
	private String algo;
	private String typeOfMaze;
	private String mazeName;
	private String chooseView;
	private char axis;
	private Maze3d maze;
	
	/**
	 * C'tor
	 */
	public Properties(){
		super();
	}
	/**
	 * this function define default properties
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
	 * setters & getters
	 */
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	public int getNumOfThreads() {
		return numOfThreads;
	}
	public void setNumOfThreads(int numOfThreads) {
		this.numOfThreads = numOfThreads;
	}
	public String getAlgo() {
		return algo;
	}
	public void setAlgo(String algo) {
		this.algo = algo;
	}
	public String getTypeOfMaze() {
		return typeOfMaze;
	}
	public void setTypeOfMaze(String typeOfMaze) {
		this.typeOfMaze = typeOfMaze;
	}
	public String getMazeName() {
		return mazeName;
	}
	public void setMazeName(String mazeName) {
		this.mazeName = mazeName;
	}
	public String getChooseView() {
		return chooseView;
	}
	public void setChooseView(String chooseView) {
		this.chooseView = chooseView;
	}
	public char getAxis() {
		return axis;
	}
	public void setAxis(char axis) {
		this.axis = axis;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Maze3d getMaze() {
		return maze;
	}
	public void setMaze(Maze3d maze) {
		this.maze = maze;
	}

}

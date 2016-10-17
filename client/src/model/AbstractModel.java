package model;


import java.util.HashMap;
import java.util.Observable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.SearchSolution;
import presenter.Properties;

/**
 * The Class AbstractModel.
 */
public abstract class AbstractModel extends Observable implements Model {
	
	/** The hash maze. */
	protected HashMap<String, Maze3d> hashMaze;
	
	/** The command map. */
	private HashMap<String, Object> commandMap;
	
	/** The properties. */
	protected Properties properties;
	
	/** The thread pool. */
	protected ExecutorService threadPool;

	/**
	 * Instantiates a new abstract model.
	 */
	public AbstractModel() {
		this.hashMaze = new HashMap<String, Maze3d>();
		this.commandMap = new HashMap<String, Object>();
		threadPool = Executors.newCachedThreadPool();
		this.properties= new Properties();
		properties.defaultProperties();
	}
	


	public abstract void generate(String mazeName);
	public abstract Maze3d getMaze3d(String mazeName);
	public abstract void getCrossSectionBy(String mazeName, String by, int index);
	public abstract void saveMaze(String fileName);
	public abstract void loadMaze(String fileName, String mazeName);
	public abstract void mazeSize(String mazeName);
	public abstract void fileSize(String mazeName);
	public abstract void solveMaze(String mazeName);
	public abstract SearchSolution<Position> getMazeSolution(String mazeName);
	public abstract void saveToZip();
	public abstract void loadFromZip();
	public abstract void exit();
//	public abstract void moveUp();
//	public abstract void moveDown();
//	public abstract void moveRight();
//	public abstract void moveLeft();
//	public abstract void moveForward();
//	public abstract void moveBackward();
	public abstract Position getPositionFromHash(String mazeName);


	/**
	 * this method gets command and return the object in the same place in the HashMap.
	 *
	 * @param command the command
	 * @return the user command
	 */
	public Object getUserCommand(String command){
		return commandMap.get(command);
	}
	
	/**
	 * This method set the notifyObservers with message and object.
	 *
	 * @param command the command
	 * @param obj the obj
	 */
	protected void setNotify(String command, Object obj) {
		if (obj != null) {
			commandMap.put(command, obj);
		}
		setChanged();
		notifyObservers(command);
	}
	
	/**
	 * getters & setters for properties.
	 *
	 * @return the properties
	 */
	public Properties getProperties() {
		return properties;
	}

	
	public void setProperties(Properties p) {
		this.properties = p;
		ExecutorService thread = threadPool;
		threadPool = Executors.newFixedThreadPool(properties.getNumOfThreads()) ;
		thread.shutdown();
	}

}

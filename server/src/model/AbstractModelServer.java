
package model;



import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.SearchSolution;
import algorithms.search.Solution;
import controller.PropertiesServer;



// TODO: Auto-generated Javadoc
/**
 * This class implements Model interface and define parameters for all kind of ModelServer.
 */

public abstract class AbstractModelServer implements Model {

	

	/** The maze solution. */
	protected HashMap<Maze3d, SearchSolution<Position>> mazeSolution;

	/** The hash maze. */
	protected HashMap<String, Maze3d> hashMaze;

	//private HashMap<String, Object> commandMap;

	/** The properties server. */
	protected PropertiesServer propertiesServer;

	/** The thread pool. */
	protected ExecutorService threadPool;

	

	/**
	 * C'tor.
	 */

	public AbstractModelServer() {

		this.mazeSolution = new HashMap<Maze3d, SearchSolution<Position>>();

		this.hashMaze = new HashMap<String, Maze3d>();

		this.propertiesServer = new PropertiesServer();

		propertiesServer.defaultPropertiesServer();

		threadPool = Executors.newFixedThreadPool(propertiesServer.getNumOfClients());

	}

	

	 
	public abstract boolean generate(String mazeName, int x, int y, int z);
	public abstract Maze3d getMaze3d(String mazeName);
	public abstract boolean solve(String mazeName, String algorithm);
	public abstract String getSolution(String mazeName);
	public abstract void saveToZip();
	public  abstract void loadFromZip();
	//public abstract Object getUserCommand(String command);
	public abstract void close();



}
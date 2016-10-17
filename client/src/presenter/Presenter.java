package presenter;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import algorithms.mazeGenerators.Maze3d;
import model.Model;
import view.View;

/**
 * The Class Presenter.
 */
public class Presenter implements Observer {
	
	/** The view. */
	private View view;
	
	/** The model. */
	private Model model;
	
	/** The hash string command. */
	private HashMap<String, Command> hashStringCommand;
	
	/** The properties. */
	private Properties properties;

	/**
	 * Instantiates a new presenter.
	 *
	 * @param view the view
	 * @param model the model
	 */
	public Presenter(View view, Model model) {
		this.view = view;
		this.model = model;
		this.properties = new Properties();
		properties.defaultProperties();
		model.setProperties(properties);
		
		try {
			XMLDecoder dXml = new XMLDecoder(new BufferedInputStream(new FileInputStream("Properties.xml")));
			properties = (Properties) dXml.readObject();
			dXml.close();
		} catch (FileNotFoundException e) {
			System.out.println("file not found, default properties will be loaded");
			properties = new Properties();
			properties.defaultProperties();
		}
		
		model.setProperties(properties);
		
		hashStringCommand = new HashMap<String, Command>();
		
		hashStringCommand.put("dir", new Dir(this));
		hashStringCommand.put("generate", new Generate3dMaze(this));
		hashStringCommand.put("display", new Display(this));
		hashStringCommand.put("displayCrossSectionBy", new DisplayCrossSectionByXYZ(this));
		hashStringCommand.put("displaySolution", new DisplaySolution(this));
		hashStringCommand.put("save", new SaveMaze(this));
		hashStringCommand.put("load", new LoadMaze(this));
		hashStringCommand.put("maze", new MazeSize(this));
		hashStringCommand.put("file", new FileSize(this));
		hashStringCommand.put("solve", new Solve(this));
	//	hashStringCommand.put("move", new Moves(this));
		hashStringCommand.put("exit", new Exit(this));
		
		view.V_setCommands(hashStringCommand);
	}

	@Override
	public void update(Observable observable, Object object) {
		if (observable == view) {
			// if the object is properties
			if (((object.getClass()).getName()).equals("presenter.Properties")) {
				Properties prop = (Properties) object;
				model.setProperties(prop);
			} else { // if it is a command
				Command command;
				String userCommand = (String) object;
				command = hashStringCommand.get(userCommand.split(" ")[0]);
				if (command != null) {
					if (userCommand.split(" ").length > 0) {
						command.doCommand(userCommand.substring(userCommand.indexOf(' ') + 1));
					} else {
						command.doCommand("");
					}
				} else {
					view.V_displayMessage("Invalid Input");
				}
			}
		} else if (observable == model) {
			String line = (String) object;
			String[] stringArray = line.split(" ");
			switch (stringArray[0]) {
			case "mazeIsReady":
				Maze3d maze = (Maze3d) model.getUserCommand(line);
				view.V_printAllMaze(maze);
			//	view.V_displayPosition(maze.getStartPosition());		
				break;
			case "displayCrossSectionBy":
				view.V_displayCrossSectionBy((int[][]) model.getUserCommand(line));
				break;
			case "saveMaze":
				view.V_displayMessage("Maze save succsesfully in file " + (String) model.getUserCommand(line));
				break;
			case "display":
				Maze3d maze1= (Maze3d) model.getUserCommand(line);
				view.V_printAllMaze(maze1);
				view.V_displayPosition(maze1.getStartPosition());
			case "loadMaze":
				Maze3d maze3d = (Maze3d) model.getUserCommand(line);
				view.V_printAllMaze(maze3d);
			
				break;
			case "mazeSize":
				view.V_displayMessage("Maze size in the memory is: " + (int) model.getUserCommand(line));
				break;
			case "fileSize":
				view.V_displayMessage("File size is: " + (int) model.getUserCommand(line));
				break;
			case "solutionIsReady":
				view.V_printdisplaySolution(model.getMazeSolution((String) model.getUserCommand(line)));
				
				break;
			case "saveZip":
				view.V_displayMessage("Maze file is saved to: " + (String) model.getUserCommand(line));
				break;
			case "loadZip":
				view.V_displayMessage("Maze file is loaded from: " + (String) model.getUserCommand(line));
				break;
			case "move":
				view.V_printAllMaze(model.getMaze3d((String) model.getUserCommand(line)));
			//	view.V_displayPosition(model.getPositionFromHash((String) model.getUserCommand(line)));
				break;
			case "exit":
				view.V_displayMessage("the program is shutting dowm, bye bye!\n");
				break;
			case "null":
				view.V_displayMessage("Maze " + (String) model.getUserCommand(line) + " is not exist");
				break;
			case "Invalid":
				switch (stringArray[1]) {
				case "parameters":
					view.V_displayMessage("Invalid parameters\n");
					break;
				case "index":
					view.V_displayMessage("Invalid index\n");
					break;
				case "file":
					view.V_displayMessage("The file " + (String) model.getUserCommand(line) + "is not exist");
					break;
				case "compress":
					view.V_displayMessage("Compressor " + (String) model.getUserCommand(line) + "is faild");
					break;
				case "maze":
					view.V_displayMessage("Error with " + (String) model.getUserCommand(line) + " maze");
					break;
				case "algorithm":
					view.V_displayMessage("Invalid algorithm\n");
					break;
				case "solution":
					view.V_displayMessage("Solution for: " + (String) model.getUserCommand(line) + "is not exist");
					break;

				default:
					view.V_displayMessage("Invalid command");
					break;
				}				
			}
		}

	}

	/**
	 * Gets the view.
	 *
	 * @return the view
	 */
	public View getView() {
		return view;
	}

	/**
	 * Sets the view.
	 *
	 * @param view the new view
	 */
	public void setView(View view) {
		this.view = view;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	public void setModel(Model model) {
		this.model = model;
	}

	/**
	 * Gets the hash.
	 *
	 * @return the hash
	 */
	public HashMap<String, Command> getHash() {
		return hashStringCommand;
	}

	/**
	 * Sets the hash.
	 *
	 * @param hashStringCommand the hash string command
	 */
	public void setHash(HashMap<String, Command> hashStringCommand) {
		this.hashStringCommand = hashStringCommand;
	}

	/**
	 * Gets the hash string command.
	 *
	 * @return the hash string command
	 */
	public HashMap<String, Command> getHashStringCommand() {
		return hashStringCommand;
	}

	/**
	 * Sets the hash string command.
	 *
	 * @param hashStringCommand the hash string command
	 */
	public void setHashStringCommand(HashMap<String, Command> hashStringCommand) {
		this.hashStringCommand = hashStringCommand;
	}

	/**
	 * Gets the properties.
	 *
	 * @return the properties
	 */
	public Properties getProperties() {
		return properties;
	}

	/**
	 * Sets the properties.
	 *
	 * @param properties the new properties
	 */
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

}

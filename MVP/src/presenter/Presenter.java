package presenter;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import algorithms.mazeGenerators.Maze3d;
import model.Model;
import view.View;





public class Presenter implements Observer {

private View ui;	
private Model model;
private HashMap<String, Command> hash;
private Properties properties;

public Presenter(View view, Model model){
	this.ui = view;
	this.model = model;
	this.properties = new Properties();
	properties.defaultProperties();
	model.setProperties(properties);
	
	hash = new HashMap<String, Command>();
	
	hash.put("dir", new Dir(this));
	hash.put("generate", new Generate(this));
	hash.put("displayCrossSectionBy", new DisplayCrossSectionByXYZ(this));
	hash.put("displaySolution", new DisplaySolution(this));
	hash.put("display", new Display(this));
	hash.put("save", new Save(this));
	hash.put("load", new Load(this));
	hash.put("maze", new MazeSize(this));
	hash.put("file", new FileSize(this));
	hash.put("solve", new Solve(this));
	hash.put("move", new Moves(this));
	hash.put("exit", new Exit(this));
	
	ui.V_setCommands(hash);
	
}

@Override
	public void update(Observable o, Object arg) {
	if (o == ui) {
		// if the object is properties
		if (((arg.getClass()).getName()).equals("presenter.Properties")) {
			Properties prop = (Properties) arg;
			model.setProperties(prop);
		} else { // if it is a command
			Command command;
			String userCommand = (String) arg;
			command = hash.get(userCommand.split(" ")[0]);
			if (command != null) {
				if (userCommand.split(" ").length > 0) {
					command.doCommand(userCommand.substring(userCommand.indexOf(' ')+1));
				} else {
					command.doCommand("");
				}
			} else {
				ui.V_displayMessage("Invalid Input");
			}
		}
	} else if (o == model) {
		String line = (String) arg;
		String[] stringArray = line.split(" ");
		switch (stringArray[0]) {
		case "mazeIsReady":
			Maze3d maze = (Maze3d) model.getUserCommand(line);
			ui.V_printAllMaze(maze);
			ui.displayPosition(maze.getStartPosition());
			break;
		case "displayCrossSectionBy":
			ui.V_displayCrossSectionBy((int[][]) model.getUserCommand(line));
			break;
		case "display":
			Maze3d maze1= (Maze3d) model.getUserCommand(line);
			ui.V_printAllMaze(maze1);
			ui.displayPosition(maze1.getStartPosition());
			break;
		case "saveMaze":
			ui.V_displayMessage("Maze save succsesfully in file" + (String) model.getUserCommand(line));
			break;
		case "loadMaze":
			Maze3d maze3d = (Maze3d) model.getUserCommand(line);
			ui.V_printAllMaze(maze3d);
			ui.displayPosition(maze3d.getStartPosition());
			break;
		case "mazeSize":
			ui.V_displayMessage("Maze size in the memory is: " + (int) model.getUserCommand(line));
			break;
		case "fileSize":
			ui.V_displayMessage("File size is: " + (int) model.getUserCommand(line));
			break;
		case "solutionIsReady":
			ui.V_printdisplaySolution(model.getMazeSolution((String) model.getUserCommand(line)));
			break;
		case "saveZip":
			ui.V_displayMessage("Maze file is saved to: " + (String) model.getUserCommand(line));
			break;
		case "loadZip":
			ui.V_displayMessage("Maze file is loaded from: " + (String) model.getUserCommand(line));
			break;
		case "move":
			ui.V_printAllMaze(model.getMaze3d((String) model.getUserCommand(line)));
			ui.displayPosition(model.getPositionFromHash((String) model.getUserCommand(line)));
			break;
		case "exit":
			ui.V_displayMessage("the program is shutting dowm, bye bye!");
			break;
		case "null":
			ui.V_displayMessage("Maze " + (String) model.getUserCommand(line) + " is not exist");
			break;
		case "Invalid":
			switch (stringArray[1]) {
			case "parameters":
				ui.V_displayMessage("Invalid parameters");
				break;
			case "index":
				ui.V_displayMessage("Invalid index");
				break;
			case "file":
				ui.V_displayMessage("The file" + (String) model.getUserCommand(line) + "is not exist");
				break;
			case "compress":
				ui.V_displayMessage("Compressor" + (String) model.getUserCommand(line) + "is faild");
				break;
			case "maze":
				ui.V_displayMessage("Error with" + (String) model.getUserCommand(line) + "maze");
				break;
			case "algorithm":
				ui.V_displayMessage("Invalid algorithm");
				break;
			case "solution":
				ui.V_displayMessage("Solution for:" + (String) model.getUserCommand(line) + "is not exist");
				break;

			default:
				ui.V_displayMessage("Invalid command");
				break;
			}				
		}
	}
}
	public View getUi() {
		return ui;
	}
	public void setUi(View ui) {
		this.ui = ui;
	}
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	public HashMap<String, Command> getHash() {
		return hash;
	}
	public void setHash(HashMap<String, Command> hash) {
		this.hash = hash;
	}






	public Properties getProperties() {
		return properties;
	}






	public void setProperties(Properties properties) {
		this.properties = properties;
	}

}

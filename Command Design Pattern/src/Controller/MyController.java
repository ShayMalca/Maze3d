package Controller;

import java.io.IOException;
import java.util.HashMap;

import Model.Model;
import View.View;


/**
 * The Class MyController.
 */
public class MyController implements Controller {

	/** The model. */
	private Model model;

	/** The view. */
	private View view;

	/** The hash. */
	private HashMap<String , Command> commands;

	/**
	 * Instantiates a new my controller.
	 *
	 * @param model the model
	 * @param view the view
	 * @param hash the hash
	 */
	public MyController(Model model,View view) {
		this.model=model;
		this.view=view;

	}

	/* (non-Javadoc)
	 * @see Controller.Controller#setModel(Model.Model)
	 */
	@Override
	public void setModel(Model model) {
		this.model=model;

	}

	/* (non-Javadoc)
	 * @see Controller.Controller#setView(View.View)
	 */
	@Override
	public void setView(View view) {
		this.view=view;
		this.commands=new HashMap<String,Command>();

		this.commands.put("solve",new Solve(this));
		this.commands.put("dir",new Dir(this));
		this.commands.put("display", new Display(this));
		this.commands.put("displayCrossSectionBy", new DisplayCrossSectionByXYZ(this));
		this.commands.put("displaySolution", new DisplaySolution(this));
		this.commands.put("exit", new Exit(this));
		this.commands.put("fileSize", new FileSize(this));
		this.commands.put("generate3dMaze", new Generate3dMaze(this));
		this.commands.put("loadMaze", new LoadMaze(this));
		this.commands.put("mazeSize", new MazeSize(this));
		this.commands.put("saveMaze", new SaveMaze(this));
		this.commands.put("solve", new Solve(this));
		view.V_sendCommands(commands);

	}

	/* (non-Javadoc)
	 * @see Controller.Controller#C_displayMessage(java.lang.String)
	 */
	@Override
	public void C_displayMessage(String msg) {
		view.V_displayMessage(msg);

	}

	/* (non-Javadoc)
	 * @see Controller.Controller#C_displayCrossSectionByXYZ(java.lang.String, java.lang.String, int)
	 */
	@Override
	public void C_displayCrossSectionByXYZ(String xyz, String mazeName, int index) {
		model.M_displayCrossSectionByXYZ(xyz, mazeName, index);
        
	}

	/* (non-Javadoc)
	 * @see Controller.Controller#C_solve(java.lang.String, java.lang.String)
	 */
	@Override
	public void C_solve(String mazeName, String Algo) {
		model.M_solve(mazeName, Algo);

	}

	/* (non-Javadoc)
	 * @see Controller.Controller#C_saveMaze(java.lang.String, java.lang.String)
	 */
	@Override
	public void C_saveMaze(String mazeName, String fileName) {
		model.M_saveMaze(mazeName, fileName);

	}

	/* (non-Javadoc)
	 * @see Controller.Controller#C_displayMaze(java.lang.String)
	 */
	@Override
	public void C_displayMaze(String mazeName) {
		model.M_display(mazeName);

	}

	/* (non-Javadoc)
	 * @see Controller.Controller#C_mazeSize(java.lang.String)
	 */
	@Override
	public void C_mazeSize(String mazeName) {
		model.M_mazeSize(mazeName);

	}

	/* (non-Javadoc)
	 * @see Controller.Controller#C_displayStringArray(java.lang.String[])
	 */
	@Override
	public void C_displayStringArray(String[] args) {
		view.V_displayStringArray(args);

	}

	/* (non-Javadoc)
	 * @see Controller.Controller#C_generate3dMaze(java.lang.String, int, int, int)
	 */
	@Override
	public void C_generate3dMaze(String mazeName, int x, int y, int z) {
		model.M_generate3dMaze(mazeName, x, y, z);

	}

	/* (non-Javadoc)
	 * @see Controller.Controller#C_loadMaze(java.lang.String, java.lang.String)
	 */
	@Override
	public void C_loadMaze(String mazeName, String fileName) throws IOException {
		model.M_loadMaze(mazeName, fileName);

	}

	/* (non-Javadoc)
	 * @see Controller.Controller#C_fileSize(java.lang.String)
	 */
	@Override
	public void C_fileSize(String mazeName) {
		model.M_fileSize(mazeName);

	}

	/* (non-Javadoc)
	 * @see Controller.Controller#C_displaySolution(java.lang.String)
	 */
	//need to check.
	@Override
	public void C_displaySolution(String MazeName) {
		model.M_displaySolution(MazeName);
	}

	
	


	
	
	
	
	/* (non-Javadoc)
	 * @see Controller.Controller#C_exit()
	 */
	@Override
	public void C_exit() {
		view.exit();
		model.exit();

	}






}

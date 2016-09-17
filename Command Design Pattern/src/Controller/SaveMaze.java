package Controller;


/**
 * The Class SaveMaze.
 */
public class SaveMaze extends abstractCommand {

	/**
	 * Instantiates a new save maze.
	 *
	 * @param c the c
	 */
	public SaveMaze(Controller c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see Controller.abstractCommand#doCommand(java.lang.String)
	 */
	@Override
	public void doCommand(String command) {
		String[] temp = command.split(" ");
		if(temp.length > 50){
			this.c.C_displayMessage("wrong\n");
		}
		else {
			String mazeName = temp[1];
			String fileName = temp[2];
			this.c.C_saveMaze(mazeName, fileName);
		}

	}

}

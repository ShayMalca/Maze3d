package Controller;

/**
 * The Class MazeSize.
 */
public class MazeSize extends abstractCommand {

	/**
	 * Instantiates a new maze size.
	 *
	 * @param c the c
	 */
	public MazeSize(Controller c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see Controller.abstractCommand#doCommand(java.lang.String)
	 */
	@Override
	public void doCommand(String command) {
		String[] temp = command.split(" ");
		if (temp.length != 2) {
			this.c.C_displayMessage("wrong input");
		} else {
			String nameMaze = temp[1];
			this.c.C_mazeSize(nameMaze);
		}

	}

}

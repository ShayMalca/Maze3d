package Controller;


/**
 * The Class Display.
 */
public class Display extends abstractCommand {

	/**
	 * Instantiates a new display.
	 *
	 * @param c the c
	 */
	public Display(Controller c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see Controller.abstractCommand#doCommand(java.lang.String)
	 */
	@Override
	public void doCommand(String command) {
		String [] temp=command.split(" ");
		
		if (temp.length != 2) {
			this.c.C_displayMessage("wromg input");
		} else {
			String mazeName = temp[1];
			this.c.C_displayMaze(mazeName);
		}

	}

}

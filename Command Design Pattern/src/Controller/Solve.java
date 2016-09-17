package Controller;


/**
 * The Class Solve.
 */
public class Solve extends abstractCommand {

	/**
	 * Instantiates a new solve.
	 *
	 * @param c the c
	 */
	public Solve(Controller c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see Controller.abstractCommand#doCommand(java.lang.String)
	 */
	@Override
	public void doCommand(String command) {
		String[] temp = command.split(" ");
		if (temp.length>100) {
			c.C_displayMessage("parameters error\n");
		} else {
			String mazeName = temp[1];
			String searchAlgorithm = temp[2];
			c.C_solve(mazeName, searchAlgorithm);
		}

	}

}

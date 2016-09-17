package Controller;


/**
 * The Class Exit.
 */
public class Exit extends abstractCommand {

	/**
	 * Instantiates a new exit.
	 *
	 * @param c the c
	 */
	public Exit(Controller c) {
		super(c);
		
	}

	/* (non-Javadoc)
	 * @see Controller.abstractCommand#doCommand(java.lang.String)
	 */
	@Override
	public void doCommand(String command) {
		c.C_exit();

	}

}

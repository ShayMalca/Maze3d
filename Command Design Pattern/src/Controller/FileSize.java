package Controller;


/**
 * The Class FileSize.
 */
public class FileSize extends abstractCommand {

	/**
	 * Instantiates a new file size.
	 *
	 * @param c the c
	 */
	public FileSize(Controller c) {
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
			String mazeName = temp[1];
			this.c.C_fileSize(mazeName);
		}

	}

}

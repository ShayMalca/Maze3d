package Controller;


/**
 * The Class DisplayCrossSectionByXYZ.
 */
public class DisplayCrossSectionByXYZ extends abstractCommand {

	/**
	 * Instantiates a new display cross section by XYZ.
	 *
	 * @param c the c
	 */
	public DisplayCrossSectionByXYZ(Controller c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see Controller.abstractCommand#doCommand(java.lang.String)
	 */
	@Override
	public void doCommand(String command) {
		String[] tempArr = command.split(" ");
		String mazeName;
		int index=0;
		try{
			index=Integer.parseInt(tempArr[2]);
			String xyz = tempArr[1];
			mazeName = tempArr[3];
			c.C_displayCrossSectionByXYZ (xyz,  mazeName, index);
		}catch (NumberFormatException e){
			c.C_displayMessage("invalid input");
		}


	}




}







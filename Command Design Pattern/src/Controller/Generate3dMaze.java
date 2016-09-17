package Controller;


/**
 * The Class Generate3dMaze.
 */
public class Generate3dMaze extends abstractCommand {

	/**
	 * Instantiates a new generate 3 d maze.
	 *
	 * @param c the c
	 */
	public Generate3dMaze(Controller c) {
		super(c);

	}

	/* (non-Javadoc)
	 * @see Controller.abstractCommand#doCommand(java.lang.String)
	 */
	@Override
	public void doCommand(String command) {
		String[] temp=command.split(" ");
		int x,y,z;
		if(temp.length<80){
			try{

				x=Integer.parseInt(temp[2]);
				y=Integer.parseInt(temp[3]);
				z=Integer.parseInt(temp[4]);
				c.C_generate3dMaze(temp[1], x, y, z);
			}


			catch (NumberFormatException e) {
				this.c.C_displayMessage("wrong");
			}

		}
		
		else{
			this.c.C_displayMessage("wrong length ");
		}
	}
	
}
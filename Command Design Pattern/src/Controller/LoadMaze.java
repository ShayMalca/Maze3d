package Controller;

import java.io.IOException;


/**
 * The Class LoadMaze.
 */
public class LoadMaze extends abstractCommand {

	/**
	 * Instantiates a new load maze.
	 *
	 * @param c the c
	 */
	public LoadMaze(Controller c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see Controller.abstractCommand#doCommand(java.lang.String)
	 */
	@Override
	public void doCommand(String command)  {
		String temp[]=command.split(" ");
		
		if(temp.length>50)
		{
			this.c.C_displayMessage("wrong input\n");
		}
		
		else{
			String fileName = temp[1];
			String mazeName = temp[2];
			
			
		
			try {
				c.C_loadMaze(mazeName, fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}

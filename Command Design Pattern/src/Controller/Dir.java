package Controller;

import java.io.File;


/**
 * The Class Dir.
 */
public class Dir extends abstractCommand {

	/**
	 * Instantiates a new dir.
	 *
	 * @param c the c
	 */
	public Dir(Controller c) {
		super(c);

	}

	/* (non-Javadoc)
	 * @see Controller.abstractCommand#doCommand(java.lang.String)
	 */
	@Override
	public void doCommand(String command) {
		if(command == null)
			this.c.C_displayMessage("wrong input\n");
		else{
			try {
				String [] temp=command.split(" ");
				File file = new File(temp[1]);
				if(file.list().length == 0)
					this.c.C_displayMessage("empty file error\n");
				else
					this.c.C_displayStringArray(file.list());
			}
			catch (NullPointerException e){
				this.c.C_displayMessage("wrong path\n");
			}

		}

//		try {
//			File file = new File(command);	
//			String[] string = file.list();
//			String list = "";
//			
//			for(int i = 0; i <string.length; i++)
//				list += string[i] + '\n';
//			
//			c.C_displayMessage(list);
//		}
//		catch (NullPointerException e){
//			c.C_displayMessage("Invalid path");
//		}
		
	}
		
}



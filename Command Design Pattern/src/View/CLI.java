package View;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;

import Controller.Command;

/**
 * The Class CLI.
 */
public class CLI {

	/** The in. */
	private BufferedReader in;

	/** The out. */
	private PrintWriter out;

	/** The hash. */
	private HashMap<String, Command> hash;





	/**
	 * Instantiates a new cli.
	 *
	 * @param in the in
	 * @param out the out
	 * @param hash the hash
	 */
	public CLI(BufferedReader in,PrintWriter out,HashMap<String, Command> hash) {
		this.in=in;
		this.out=out;
		this.hash=hash;
	}



	/**
	 * Start.
	 */
	public void start(){
		//crate Thread
		new Thread(new Runnable() {

			@Override
			public void run() {
				try{
					//ask user for command.

					out.println("Please enter your command");
					out.flush();
					//get command
					String commandName=in.readLine();
					Command command=null;

					while(!commandName.equals("exit")){
						command= hash.get(commandName.split(" ")[0]);
						if(command!=null){
							if(commandName.split(" ").length>1){
								command.doCommand(commandName.substring(commandName.indexOf(' ') ));
							}else {
								out.println("InValid Parmeter\n");
								out.flush();
							}
						}else {
							out.println("this command is not exits\n");
							out.flush();
						}

						out.println("please enter a new command");
						out.flush();
						commandName = in.readLine();

					}
					hash.get("exit").doCommand("");


				}catch(Exception e){
					e.printStackTrace();
				}

			}
		}).start();

	}


}











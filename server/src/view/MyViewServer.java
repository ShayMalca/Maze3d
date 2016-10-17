package view;

import controller.Controller;


/**
 * The Class MyViewServer.
 */
public class MyViewServer extends AbstractViewSerer {

	/**
	 * Instantiates a new my view server.
	 *
	 * @param controller the controller
	 */
	public MyViewServer(Controller controller) {
		super(controller);

	}

	@Override
	public void start() {
		controller.start();

	}

	@Override
	public void close() {
		controller.close();

	}

	@Override
	public void printMessage(String message) {

		if(message != null)

			System.out.println(message);

		else

			System.out.println("empty message");

	}

}



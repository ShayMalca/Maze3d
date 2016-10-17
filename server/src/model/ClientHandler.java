package model;

import java.io.InputStream;
import java.io.OutputStream;

import controller.Controller;

/**
 * The Interface ClientHandler.
 */
public interface ClientHandler {


	/**
	 * Handle client.
	 *
	 * @param inFromClient the in from client
	 * @param outToClient the out to client
	 */
	void handleClient(InputStream inFromClient, OutputStream outToClient);

	/**
	 * Sets the controller.
	 *
	 * @param controller the new controller
	 */
	void setController(Controller controller);

}

package model;

import java.io.InputStream;
import java.io.OutputStream;

import controller.Controller;

/**
 * The Class AbstractClientHandler.
 */
public abstract class AbstractClientHandler implements ClientHandler {
	
	/** The controller. */
	protected Controller controller;
	

	@Override

	public abstract void handleClient(InputStream inFromClient, OutputStream outToClient);

	@Override

	public void setController(Controller controller) {

		this.controller = controller;

	}

}

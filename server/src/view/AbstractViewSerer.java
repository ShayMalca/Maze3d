package view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.ServerSocket;

import controller.Controller;


/**
 * The Class AbstractViewSerer.
 */
public abstract class AbstractViewSerer implements View {

	/** The in. */
	protected BufferedReader in;

	/** The out. */
	protected PrintWriter out;

	/** The server socket. */
	protected ServerSocket serverSocket;

	/** The controller. */
	protected Controller controller;
	
	
	/**
	 * Instantiates a new abstract view server.
	 *
	 * @param controller the controller
	 */
	public AbstractViewSerer(Controller controller) {
		super();
		this.controller = controller;
	}
	
	@Override
	public abstract void start();
	@Override
	public abstract void close();
	@Override
	public abstract void printMessage(String message);
}

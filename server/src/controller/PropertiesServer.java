package controller;

import java.io.Serializable;

/**
 * The Class PropertiesServer.
 */
public class PropertiesServer implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The port. */
	private int port;

	/** The num of clients. */
	private int numOfClients;

	

	/**
	 * C'tor.
	 */

	public PropertiesServer() {

		super();

	}



	/**
	 * getters & setters.
	 *
	 * @return the port
	 */

	public int getPort() {

		return port;

	}



	/**
	 * Sets the port.
	 *
	 * @param port the new port
	 */
	public void setPort(int port) {

		this.port = port;

	}



	/**
	 * Gets the num of clients.
	 *
	 * @return the num of clients
	 */
	public int getNumOfClients() {

		return numOfClients;

	}



	/**
	 * Sets the num of clients.
	 *
	 * @param numOfClients the new num of clients
	 */
	public void setNumOfClients(int numOfClients) {

		this.numOfClients = numOfClients;

	}

	

	/**
	 * Default properties server.
	 */
	public void defaultPropertiesServer(){

		this.port = 5400;

		this.numOfClients = 10;

	}

}

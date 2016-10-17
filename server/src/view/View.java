package view;


/**
 * The Interface View.
 */
public interface View {

	/**
	 * Start.
	 */
	void start();
	
	/**
	 * Close.
	 */
	void close();
	
	/**
	 * Prints the message.
	 *
	 * @param message the message
	 */
	void printMessage(String message);
	
}

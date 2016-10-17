package guiView;

import java.util.Observable;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


/**
 * The Class BasicWindow.
 */
public abstract class BasicWindow extends Observable implements Runnable {
	
	/** The display. */
	protected Display display;
	
	/** The shell. */
	protected Shell shell;

	/**
	 * Instantiates a new basic window.
	 *
	 * @param title the title
	 * @param width the width
	 * @param height the height
	 */
	public BasicWindow(String title, int width,int height) {
		display=new Display();
		shell  = new Shell(display);
		shell.setSize(width,height);
		shell.setText(title);
	}

	/**
	 * Inits the widgets.
	 */
	protected abstract void initWidgets();

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		initWidgets();
		shell.open();
		// main event loop
		while(!shell.isDisposed()){ // while window isn't closed

			// 1. read events, put then in a queue.
			// 2. dispatch the assigned listener
			if(!display.readAndDispatch()){ 	// if the queue is empty
				display.sleep(); 			// sleep until an event occurs 
			}

		}
		// TODO Auto-generated method stub

		// shell is disposed
		display.dispose(); // dispose OS components


	}

	/**
	 * Gets the display.
	 *
	 * @return the display
	 */
	public Display getDisplay() {
		return display;
	}

	/**
	 * Sets the display.
	 *
	 * @param display the new display
	 */
	public void setDisplay(Display display) {
		this.display = display;
	}

	/**
	 * Gets the shell.
	 *
	 * @return the shell
	 */
	public Shell getShell() {
		return shell;
	}

	/**
	 * Sets the shell.
	 *
	 * @param shell the new shell
	 */
	public void setShell(Shell shell) {
		this.shell = shell;
	} 


}

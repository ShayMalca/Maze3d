package guiProperties;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * BasicWindow class - implements Runnable
 * create the basic window.
 */
public abstract class BasicWindow implements Runnable {
	
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
	public BasicWindow(String title, int width, int height){
		display = new Display();
		shell = new Shell(display);
		shell.setSize(width,height);
		shell.setText(title);
		
	}
	
	/**
	 * Configure the window widgets.
	 */
	public abstract void initWidgets();

	@Override
	public void run() {
		initWidgets();
		shell.open();
		
		while(!shell.isDisposed())
			if(!display.readAndDispatch())
				display.sleep();
		
		display.dispose();

	}

}

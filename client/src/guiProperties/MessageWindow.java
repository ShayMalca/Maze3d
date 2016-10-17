package guiProperties;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;

import presenter.Properties;

/**
 * The Class MessageWindow.
 */
public class MessageWindow extends BasicWindow {

	/** The properties. */
	protected Properties properties;
	
	/** The ok button. */
	protected Button okButton;
	
	/** The background. */
	protected Image background;


	/**
	 * Instantiates a new message window.
	 *
	 * @param title the title
	 * @param width the width
	 * @param height the height
	 */
	public MessageWindow(String title, int width, int height) {
		super(title, width, height);
		properties=new Properties();
		background=new Image(display, "images/propBackround1.jpg");

	}
	
	

	@Override
	public void initWidgets() {
		shell.setLayout(new GridLayout(2,false));
		shell.setBackgroundImage(background);

		//maze name
		new Label(shell, SWT.None).setText("Maze Name: ");
		final Text mazeName = new Text(shell, SWT.BORDER);
		mazeName.setBackground(new Color(null,37,63,228));//176,274,230
		mazeName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		mazeName.setForeground(new Color(null, 255,255,255));

		//number of threads
		new Label(shell, SWT.None).setText("Number of threads: ");
		final Text numOfThreads = new Text(shell, SWT.BORDER);
		numOfThreads.setBackground(new Color(null,37,63,228));
		numOfThreads.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		numOfThreads.setForeground(new Color(null, 255,255,255));

		//number of floors
		new Label(shell, SWT.None).setText("Number of floors: ");
		final Text numOfFloors = new Text(shell, SWT.BORDER);
		numOfFloors.setBackground(new Color(null,37,63,228));
		numOfFloors.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		numOfFloors.setForeground(new Color(null, 255,255,255));

		//number of rows
		new Label(shell, SWT.None).setText("Number of rows: ");
		final Text numOfRows = new Text(shell, SWT.BORDER);
		numOfRows.setBackground(new Color(null,37,63,228));
		numOfRows.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		numOfRows.setForeground(new Color(null, 255,255,255));

		//number of columns
		new Label(shell, SWT.None).setText("Number of columns: ");
		final Text numOfColumns = new Text(shell, SWT.BORDER);
		numOfColumns.setBackground(new Color(null,37,63,228));
		numOfColumns.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		numOfColumns.setForeground(new Color(null, 255,255,255));

		//solving algorithm
		new Label(shell, SWT.None).setText("Choose solving algorithm: ");
		final Combo algorithm = new Combo(shell, SWT.DROP_DOWN | SWT.PUSH | SWT.BORDER);
		algorithm.setBackground(new Color(null,37,63,228));
		algorithm.setForeground(new Color(null, 255,255,255));
		algorithm.add("BFS");
		algorithm.add("DFS");
		algorithm.select(0);
		

		//view
		new Label(shell, SWT.NONE).setText("Choose view display:");
		final Combo view = new Combo(shell, SWT.DROP_DOWN | SWT.PUSH | SWT.BORDER);
		view.setBackground(new Color(null,37,63,228));	
		view.setForeground(new Color(null, 255,255,255));
		view.add("Gui");
		view.add("Cli");
		view.select(0);

		//OK button 
		okButton = new Button(shell, SWT.PUSH);
		okButton.setText("OK");

		okButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				properties.setMazeName(mazeName.getText());
				
				properties.setAlgo(algorithm.getText());
				
				

				// check number of floors
				if ((Integer.parseInt(numOfFloors.getText()) > 0)) {
					properties.setX(Integer.parseInt(numOfFloors.getText()));
				} else {
					displayError("Inccorect number of floors");
					properties.setX(6);
				}
				// check number of rows
				if ((Integer.parseInt(numOfRows.getText()) > 0)) {
					properties.setY(Integer.parseInt(numOfRows.getText()));
				} else {
					displayError("Inccorect number of rows");
					properties.setY(6);
				}
				// check number Of Columns
				if ((Integer.parseInt(numOfColumns.getText()) > 0)) {
					properties.setZ(Integer.parseInt(numOfColumns.getText()));
				} else {
					displayError("Inccorect number of columns");
					properties.setZ(6);
				}
				// check number Of Threads
				if ((Integer.parseInt(numOfThreads.getText()) > 0)) {
					properties.setNumOfThreads(Integer.parseInt(numOfThreads.getText()));
				} else {
					displayError("Incorrect number of threads");
					properties.setNumOfThreads(10);
				}


				try { // push all the information from properties to XML file
					XMLEncoder eXml = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Properties.xml")));
					eXml.writeObject(properties);
					eXml.flush();
					eXml.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				shell.dispose();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});

	}

	/**
	 * Display error.
	 *
	 */
	public void displayError(String error){
		Display.getDefault().syncExec(new Runnable() {

			@Override
			public void run() {
				MessageBox messageBox = new MessageBox(shell, SWT.ICON_INFORMATION);
				messageBox.setMessage(error);
				messageBox.open();		
			}
		});
	}

	/**
	 * This method open the shell.
	 */
	public void open(){
		shell.open();
	}

}

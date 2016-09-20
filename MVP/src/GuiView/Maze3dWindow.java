package GuiView;



import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.SearchSolution;


// TODO: Auto-generated Javadoc
/**
 * The Class Maze3dWindow.
 */
public class Maze3dWindow extends BasicWindow {

	/** The maze 3 d. */
	protected Maze3d maze3d;

	/** The current pos. */
	protected Position currentPos;

	/** The solution. */
	protected SearchSolution<Position> solution;

	/** The properties listener. */
	protected SelectionListener generateListener, solveListener, exitListener, saveListener, loadListener, propertiesListener;

	/** The options menu. */
	protected Menu toolBarMenu, fileMenu, optionsMenu;

	/** The option start item. */
	protected MenuItem fileSaveItem, fileLoadItem, fileExitItem, filePropertiesItem, optionSolveItem, optionStartItem;

	/** The options menu header. */
	protected MenuItem fileMenuHeader, optionsMenuHeader;

	/** The dispose exit. */
	protected DisposeListener disposeExit;

	/** The keyboard listner. */
	protected KeyListener keyboardListner;

	/** The maze 3 d displayer list. */
	protected ArrayList<Maze3dDisplayer> maze3dDisplayerList;

	/** The play button. */
	protected Button playButton;

	/** The file name. */
	protected String fileName; 

	/**
	 * Instantiates a new maze 3 d window.
	 *
	 * @param title the title
	 * @param width the width
	 * @param height the height
	 */
	public Maze3dWindow(String title, int width, int height) {
		super(title, width, height);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the maze 3 d.
	 *
	 * @return the maze 3 d
	 */
	public Maze3d getMaze3d() {
		return maze3d;
	}

	/**
	 * Sets the maze 3 d.
	 *
	 * @param maze3d the new maze 3 d
	 */
	public void setMaze3d(Maze3d maze3d) {
		this.maze3d = maze3d;
	}

	/**
	 * Gets the current pos.
	 *
	 * @return the current pos
	 */
	public Position getCurrentPos() {
		return currentPos;
	}

	/**
	 * Sets the current pos.
	 *
	 * @param currentPos the new current pos
	 */
	public void setCurrentPos(Position currentPos) {
		this.currentPos = currentPos;
	}

	/**
	 * Gets the solution.
	 *
	 * @return the solution
	 */
	public SearchSolution<Position> getSolution() {
		return solution;
	}

	/**
	 * Sets the solution.
	 *
	 * @param solution the new solution
	 */
	public void setSolution(SearchSolution<Position> solution) {
		this.solution = solution;
	}

	/**
	 * Gets the generate listener.
	 *
	 * @return the generate listener
	 */
	public SelectionListener getGenerateListener() {
		return generateListener;
	}

	/**
	 * Sets the generate listener.
	 *
	 * @param generateListener the new generate listener
	 */
	public void setGenerateListener(SelectionListener generateListener) {
		this.generateListener = generateListener;
	}

	/**
	 * Gets the solve listener.
	 *
	 * @return the solve listener
	 */
	public SelectionListener getSolveListener() {
		return solveListener;
	}

	/**
	 * Sets the solve listener.
	 *
	 * @param solveListener the new solve listener
	 */
	public void setSolveListener(SelectionListener solveListener) {
		this.solveListener = solveListener;
	}

	/**
	 * Gets the exit listener.
	 *
	 * @return the exit listener
	 */
	public SelectionListener getExitListener() {
		return exitListener;
	}

	/**
	 * Sets the exit listener.
	 *
	 * @param exitListener the new exit listener
	 */
	public void setExitListener(SelectionListener exitListener) {
		this.exitListener = exitListener;
	}

	/**
	 * Gets the save listener.
	 *
	 * @return the save listener
	 */
	public SelectionListener getSaveListener() {
		return saveListener;
	}

	/**
	 * Sets the save listener.
	 *
	 * @param saveListener the new save listener
	 */
	public void setSaveListener(SelectionListener saveListener) {
		this.saveListener = saveListener;
	}

	/**
	 * Gets the load listener.
	 *
	 * @return the load listener
	 */
	public SelectionListener getLoadListener() {
		return loadListener;
	}

	/**
	 * Sets the load listener.
	 *
	 * @param loadListener the new load listener
	 */
	public void setLoadListener(SelectionListener loadListener) {
		this.loadListener = loadListener;
	}

	/**
	 * Gets the properties listener.
	 *
	 * @return the properties listener
	 */
	public SelectionListener getPropertiesListener() {
		return propertiesListener;
	}

	/**
	 * Sets the properties listener.
	 *
	 * @param propertiesListener the new properties listener
	 */
	public void setPropertiesListener(SelectionListener propertiesListener) {
		this.propertiesListener = propertiesListener;
	}

	/**
	 * Gets the tool bar menu.
	 *
	 * @return the tool bar menu
	 */
	public Menu getToolBarMenu() {
		return toolBarMenu;
	}

	/**
	 * Sets the tool bar menu.
	 *
	 * @param toolBarMenu the new tool bar menu
	 */
	public void setToolBarMenu(Menu toolBarMenu) {
		this.toolBarMenu = toolBarMenu;
	}

	/**
	 * Gets the file menu.
	 *
	 * @return the file menu
	 */
	public Menu getFileMenu() {
		return fileMenu;
	}

	/**
	 * Sets the file menu.
	 *
	 * @param fileMenu the new file menu
	 */
	public void setFileMenu(Menu fileMenu) {
		this.fileMenu = fileMenu;
	}

	/**
	 * Gets the options menu.
	 *
	 * @return the options menu
	 */
	public Menu getOptionsMenu() {
		return optionsMenu;
	}

	/**
	 * Sets the options menu.
	 *
	 * @param optionsMenu the new options menu
	 */
	public void setOptionsMenu(Menu optionsMenu) {
		this.optionsMenu = optionsMenu;
	}

	/**
	 * Gets the file save item.
	 *
	 * @return the file save item
	 */
	public MenuItem getFileSaveItem() {
		return fileSaveItem;
	}

	/**
	 * Sets the file save item.
	 *
	 * @param fileSaveItem the new file save item
	 */
	public void setFileSaveItem(MenuItem fileSaveItem) {
		this.fileSaveItem = fileSaveItem;
	}

	/**
	 * Gets the file load item.
	 *
	 * @return the file load item
	 */
	public MenuItem getFileLoadItem() {
		return fileLoadItem;
	}

	/**
	 * Sets the file load item.
	 *
	 * @param fileLoadItem the new file load item
	 */
	public void setFileLoadItem(MenuItem fileLoadItem) {
		this.fileLoadItem = fileLoadItem;
	}

	/**
	 * Gets the file exit item.
	 *
	 * @return the file exit item
	 */
	public MenuItem getFileExitItem() {
		return fileExitItem;
	}

	/**
	 * Sets the file exit item.
	 *
	 * @param fileExitItem the new file exit item
	 */
	public void setFileExitItem(MenuItem fileExitItem) {
		this.fileExitItem = fileExitItem;
	}

	/**
	 * Gets the file properties item.
	 *
	 * @return the file properties item
	 */
	public MenuItem getFilePropertiesItem() {
		return filePropertiesItem;
	}

	/**
	 * Sets the file properties item.
	 *
	 * @param filePropertiesItem the new file properties item
	 */
	public void setFilePropertiesItem(MenuItem filePropertiesItem) {
		this.filePropertiesItem = filePropertiesItem;
	}

	/**
	 * Gets the option solve item.
	 *
	 * @return the option solve item
	 */
	public MenuItem getOptionSolveItem() {
		return optionSolveItem;
	}

	/**
	 * Sets the option solve item.
	 *
	 * @param optionSolveItem the new option solve item
	 */
	public void setOptionSolveItem(MenuItem optionSolveItem) {
		this.optionSolveItem = optionSolveItem;
	}

	/**
	 * Gets the option start item.
	 *
	 * @return the option start item
	 */
	public MenuItem getOptionStartItem() {
		return optionStartItem;
	}

	/**
	 * Sets the option start item.
	 *
	 * @param optionStartItem the new option start item
	 */
	public void setOptionStartItem(MenuItem optionStartItem) {
		this.optionStartItem = optionStartItem;
	}

	/**
	 * Gets the file menu header.
	 *
	 * @return the file menu header
	 */
	public MenuItem getFileMenuHeader() {
		return fileMenuHeader;
	}

	/**
	 * Sets the file menu header.
	 *
	 * @param fileMenuHeader the new file menu header
	 */
	public void setFileMenuHeader(MenuItem fileMenuHeader) {
		this.fileMenuHeader = fileMenuHeader;
	}

	/**
	 * Gets the options menu header.
	 *
	 * @return the options menu header
	 */
	public MenuItem getOptionsMenuHeader() {
		return optionsMenuHeader;
	}

	/**
	 * Sets the options menu header.
	 *
	 * @param optionsMenuHeader the new options menu header
	 */
	public void setOptionsMenuHeader(MenuItem optionsMenuHeader) {
		this.optionsMenuHeader = optionsMenuHeader;
	}

	/**
	 * Gets the dispose exit.
	 *
	 * @return the dispose exit
	 */
	public DisposeListener getDisposeExit() {
		return disposeExit;
	}

	/**
	 * Sets the dispose exit.
	 *
	 * @param disposeExit the new dispose exit
	 */
	public void setDisposeExit(DisposeListener disposeExit) {
		this.disposeExit = disposeExit;
	}

	/**
	 * Gets the keyboard listner.
	 *
	 * @return the keyboard listner
	 */
	public KeyListener getKeyboardListner() {
		return keyboardListner;
	}

	/**
	 * Sets the keyboard listner.
	 *
	 * @param keyboardListner the new keyboard listner
	 */
	public void setKeyboardListner(KeyListener keyboardListner) {
		this.keyboardListner = keyboardListner;
	}

	/**
	 * Gets the maze 3 d displayer list.
	 *
	 * @return the maze 3 d displayer list
	 */
	public ArrayList<Maze3dDisplayer> getMaze3dDisplayerList() {
		return maze3dDisplayerList;
	}

	/**
	 * Sets the maze 3 d displayer list.
	 *
	 * @param maze3dDisplayerList the new maze 3 d displayer list
	 */
	public void setMaze3dDisplayerList(ArrayList<Maze3dDisplayer> maze3dDisplayerList) {
		this.maze3dDisplayerList = maze3dDisplayerList;
	}

	/**
	 * Gets the play button.
	 *
	 * @return the play button
	 */
	public Button getPlayButton() {
		return playButton;
	}

	/**
	 * Sets the play button.
	 *
	 * @param playButton the new play button
	 */
	public void setPlayButton(Button playButton) {
		this.playButton = playButton;
	}

	/**
	 * Gets the file name.
	 *
	 * @return the file name
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Sets the file name.
	 *
	 * @param fileName the new file name
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/* (non-Javadoc)
	 * @see guiView.BasicWindow#initWidgets()
	 */
	@Override
	protected void initWidgets() {

		shell.setLayout(new GridLayout(2, false));
		toolBarMenu=new Menu(shell, SWT.BAR);
		shell.setMenuBar(toolBarMenu);

		fileMenuHeader=new MenuItem(toolBarMenu, SWT.CASCADE);
		//check
		fileMenuHeader.setText("&File");
		fileMenu=new Menu(shell, SWT.DROP_DOWN);
		fileMenuHeader.setMenu(fileMenu);

		filePropertiesItem=new MenuItem(fileMenu, SWT.PUSH);
		filePropertiesItem.setText("&Properties");

		fileSaveItem=new MenuItem(fileMenu, SWT.PUSH);
		fileSaveItem.setText("&Save");

		fileLoadItem=new MenuItem(fileMenu, SWT.PUSH);
		fileLoadItem.setText("&Load");

		fileExitItem=new MenuItem(fileMenu, SWT.PUSH);
		fileExitItem.setText("&Exit");

		optionsMenu=new Menu(shell, SWT.DROP_DOWN);
		optionsMenuHeader=new MenuItem(toolBarMenu, SWT.CASCADE);
		optionsMenuHeader.setText("&Options");
		optionsMenuHeader.setMenu(optionsMenu);

		optionStartItem=new MenuItem(optionsMenu, SWT.PUSH);
		optionStartItem.setText("&Start");

		optionSolveItem=new MenuItem(optionsMenu, SWT.PUSH);
		optionSolveItem.setText("&Solve");

		//exit listener
		fileExitItem.addSelectionListener(exitListener);

		//save listener
		fileSaveItem.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				FileDialog fileDialog=new FileDialog(shell, SWT.OPEN);
				fileDialog.setText("Save As");
				fileDialog.setFilterPath("desktop");
				String [] txt={"*.txt", "*.doc"};
				fileDialog.setFilterExtensions(txt);
				setFileName(fileDialog.open());

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});

		fileSaveItem.addSelectionListener(saveListener);
		fileLoadItem.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				FileDialog fileDialog = new FileDialog(shell,SWT.OPEN);
				fileDialog.setText("Open");
				fileDialog.setFilterPath("desktop");
				String[] txt = {"*.txt", "*.doc"};
				fileDialog.setFilterExtensions(txt);
				setFileName(fileDialog.open());

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});

		fileLoadItem.addSelectionListener(loadListener);
		//Start listener
		optionStartItem.addSelectionListener(generateListener);


		Maze3dDisplayer maze3d = new Maze3dGuiDisplayer(shell, SWT.DOUBLE_BUFFERED, 'x');
		maze3d.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2));
		maze3dDisplayerList.add(maze3d);
		//solve listener
		optionSolveItem.addSelectionListener(solveListener);
		//play button listener
		playButton.addKeyListener(keyboardListner);
		// properties listener
		filePropertiesItem.addSelectionListener(propertiesListener);



	}

	/**
	 * Update displayer list.
	 */
	public void updateDisplayerList() {
		for (Maze3dDisplayer widget : maze3dDisplayerList) {
			if (maze3d != null) {
				widget.setMaze3d(maze3d);
			}
			if (currentPos != null) {
				widget.setCurrentPos(currentPos);
			}
			if (solution != null) {
				widget.setSolution(solution);
			}
			Display.getDefault().syncExec(new Runnable() {
				@Override
				public void run() {
					widget.redraw();
				}
			});		
		}
	}

	public void movePlayer(int x, int y, int z){
		if (x>=0 && x<maze3d.getP().getX() && y>=0 && y<maze3d.getP().getY() && z>=0 && z<maze3d.getP().getZ()){
			//if (maze3d.getValue(x, y, z)==0){
			currentPos.setX(x);
			currentPos.setY(y);
			currentPos.setZ(z);
			updateDisplayerList();
			//}
		}
	}
	
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


}
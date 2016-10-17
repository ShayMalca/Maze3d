package guiView;



import org.eclipse.swt.SWT;

import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;


import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.SearchSolution;

/**
 * The Class MazeWindow.
 */
public class MazeWindow extends BasicWindow {
	
	/** The maze. */
	protected Maze3d maze;
	
	/** The current pos. */
	protected Position currentPos;
	
	/** The solution. */
	protected SearchSolution <Position> solution;
	
	/** The game. */
	protected Menu toolbar,file,game;
	
	/** The prop item. */
	protected MenuItem fileItem,saveItem,loadItem,gameItem,exitItem,generateItem,solveItem,hintItem, propItem;
	
	/** The prop listener. */
	protected SelectionListener saveListener,loadListener,exitListener,generateListener,solvListener,hintListener,propListener;
	
	/** The file name. */
	protected String fileName;
	
	/** The maze 3 d. */
	protected MazeDisplay maze3d;
	
	/** The keyboard listner. */
	protected KeyListener keyboardListner;
	
	/**
	 * Instantiates a new maze window.
	 *
	 * @param title the title
	 * @param width the width
	 * @param height the height
	 */
	public MazeWindow(String title, int width, int height) {
		super(title, width, height);
	
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initWidgets() {
		shell.setLayout(new GridLayout(2,false));
		toolbar=new Menu(shell, SWT.BAR);
		shell.setMenuBar(toolbar);
		file=new Menu(shell, SWT.DROP_DOWN);
		fileItem=new MenuItem(toolbar, SWT.CASCADE);
		fileItem.setMenu(file);
		fileItem.setText("&File");
		saveItem=new MenuItem(file, SWT.PUSH);
		saveItem.setText("&Save");
		loadItem=new MenuItem(file, SWT.PUSH);
		loadItem.setText("&Load");
		exitItem=new MenuItem(file, SWT.PUSH);
		exitItem.setText("&Exit");
		game=new Menu(shell,SWT.DROP_DOWN);
		gameItem=new MenuItem(toolbar, SWT.CASCADE);
		gameItem.setMenu(game);
		gameItem.setText("&Game");
		generateItem=new MenuItem(game, SWT.PUSH);
		generateItem.setText("&Start");
		solveItem=new MenuItem(game, SWT.PUSH);
		solveItem.setText("&Solve");
		hintItem=new MenuItem(game, SWT.PUSH);
		hintItem.setText("&Hint");
		propItem=new MenuItem(game, SWT.PUSH);
		propItem.setText("&Properties");
		
		saveItem.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
					FileDialog filedialog=new FileDialog(shell,SWT.SAVE);
					filedialog.setText("&Save as");
					filedialog.setFilterPath("Desktop");
					String[] text={"*.txt","*.doc"};
					filedialog.setFilterExtensions(text);
					setFileName(filedialog.open());
					
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		saveItem.addSelectionListener(saveListener);
		
		loadItem.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				FileDialog filedialog=new FileDialog(shell,SWT.OPEN);
				filedialog.setText("&load as");
				filedialog.setFilterPath("Desktop");
				String[] text={"*.txt","*.doc"};
				filedialog.setFilterExtensions(text);
				setFileName(filedialog.open());
				
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		loadItem.addSelectionListener(loadListener);
		
		
		exitItem.addSelectionListener(exitListener);
		
		solveItem.addSelectionListener(solvListener);
		
	    
		
		hintItem.addSelectionListener(hintListener);
		
		
		generateItem.addSelectionListener(generateListener);
		
		propItem.addSelectionListener(propListener);
		
		maze3d = new MazeGuiDisplay(shell, SWT.DOUBLE_BUFFERED, 'x');
		maze3d.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2));
		
	

		
	
	}
	
	
	/**
	 * Gets the maze gui display.
	 *
	 * @return the maze gui display
	 */
	public MazeDisplay getMazeGuiDisplay()
	{
		return maze3d;
	}
	
	/**
	 * Sets the position dispaly.
	 *
	 * @param p the new position dispaly
	 */
	public void setPositionDispaly(Position p) {
		 maze3d.setCurrentPos(p);
	}

	/**
	 * Gets the toolbar.
	 *
	 * @return the toolbar
	 */
	public Menu getToolbar() {
		return toolbar;
	}

	/**
	 * Sets the toolbar.
	 *
	 * @param toolbar the new toolbar
	 */
	public void setToolbar(Menu toolbar) {
		this.toolbar = toolbar;
	}

	/**
	 * Gets the file.
	 *
	 * @return the file
	 */
	public Menu getFile() {
		return file;
	}

	/**
	 * Sets the file.
	 *
	 * @param file the new file
	 */
	public void setFile(Menu file) {
		this.file = file;
	}

	/**
	 * Gets the game.
	 *
	 * @return the game
	 */
	public Menu getGame() {
		return game;
	}

	/**
	 * Sets the game.
	 *
	 * @param game the new game
	 */
	public void setGame(Menu game) {
		this.game = game;
	}

	/**
	 * Gets the file item.
	 *
	 * @return the file item
	 */
	public MenuItem getFileItem() {
		return fileItem;
	}

	/**
	 * Sets the file item.
	 *
	 * @param fileItem the new file item
	 */
	public void setFileItem(MenuItem fileItem) {
		this.fileItem = fileItem;
	}

	/**
	 * Gets the save item.
	 *
	 * @return the save item
	 */
	public MenuItem getSaveItem() {
		return saveItem;
	}

	/**
	 * Sets the save item.
	 *
	 * @param saveItem the new save item
	 */
	public void setSaveItem(MenuItem saveItem) {
		this.saveItem = saveItem;
	}

	/**
	 * Gets the load item.
	 *
	 * @return the load item
	 */
	public MenuItem getLoadItem() {
		return loadItem;
	}

	/**
	 * Sets the load item.
	 *
	 * @param loadItem the new load item
	 */
	public void setLoadItem(MenuItem loadItem) {
		this.loadItem = loadItem;
	}

	/**
	 * Gets the game item.
	 *
	 * @return the game item
	 */
	public MenuItem getGameItem() {
		return gameItem;
	}

	/**
	 * Sets the game item.
	 *
	 * @param gameItem the new game item
	 */
	public void setGameItem(MenuItem gameItem) {
		this.gameItem = gameItem;
	}

	/**
	 * Gets the exit item.
	 *
	 * @return the exit item
	 */
	public MenuItem getExitItem() {
		return exitItem;
	}

	/**
	 * Sets the exit item.
	 *
	 * @param exitItem the new exit item
	 */
	public void setExitItem(MenuItem exitItem) {
		this.exitItem = exitItem;
	}

	/**
	 * Gets the generate item.
	 *
	 * @return the generate item
	 */
	public MenuItem getGenerateItem() {
		return generateItem;
	}

	/**
	 * Sets the generate item.
	 *
	 * @param generateItem the new generate item
	 */
	public void setGenerateItem(MenuItem generateItem) {
		this.generateItem = generateItem;
	}

	/**
	 * Gets the solve item.
	 *
	 * @return the solve item
	 */
	public MenuItem getSolveItem() {
		return solveItem;
	}

	/**
	 * Sets the solve item.
	 *
	 * @param solveItem the new solve item
	 */
	public void setSolveItem(MenuItem solveItem) {
		this.solveItem = solveItem;
	}

	/**
	 * Gets the hint item.
	 *
	 * @return the hint item
	 */
	public MenuItem getHintItem() {
		return hintItem;
	}

	/**
	 * Sets the hint item.
	 *
	 * @param hintItem the new hint item
	 */
	public void setHintItem(MenuItem hintItem) {
		this.hintItem = hintItem;
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
	public SelectionListener getSolvListener() {
		return solvListener;
	}

	/**
	 * Sets the solve listener.
	 *
	 * @param solvListener the new solve listener
	 */
	public void setSolvListener(SelectionListener solvListener) {
		this.solvListener = solvListener;
	}

	/**
	 * Gets the hint listener.
	 *
	 * @return the hint listener
	 */
	public SelectionListener getHintListener() {
		return hintListener;
	}

	/**
	 * Sets the hint listener.
	 *
	 * @param hintListener the new hint listener
	 */
	public void setHintListener(SelectionListener hintListener) {
		this.hintListener = hintListener;
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
	 * Gets the maze.
	 *
	 * @return the maze
	 */
	public Maze3d getMaze() {
		return maze;
	}

	/**
	 * Sets the maze.
	 *
	 * @param maze the new maze
	 */
	public void setMaze(Maze3d maze) {
		this.maze = maze;
		if(maze3d != null)
			maze3d.setMaze3d(maze);
	}

	/**
	 * Gets the current position.
	 *
	 * @return the current position
	 */
	public Position getCurrentPos() {
		return currentPos;
	}

	/**
	 * Sets the current position.
	 *
	 * @param currentPos the new current position
	 */
	public void setCurrentPos(Position currentPos) {
		this.currentPos = currentPos;
	}

	/**
	 * Gets the maze 3 d.
	 *
	 * @return the maze 3 d
	 */
	public MazeDisplay getMaze3d() {
		return maze3d;
	}

	/**
	 * Sets the maze 3 d.
	 *
	 * @param maze3d the new maze 3 d
	 */
	public void setMaze3d(MazeDisplay maze3d) {
		this.maze3d = maze3d;
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
	 * Sets the maze display solution.
	 *
	 * @param solution the new maze display solution
	 */
	//add the array solution to mazedisplay.
	public void setMazeDisplaySolution(SearchSolution<Position> solution){
		maze3d.setSolution(solution);
	}

	/**
	 * Gets the prop item.
	 *
	 * @return the prop item
	 */
	public MenuItem getPropItem() {
		return propItem;
	}

	/**
	 * Sets the prop item.
	 *
	 * @param propItem the new prop item
	 */
	public void setPropItem(MenuItem propItem) {
		this.propItem = propItem;
	}

	/**
	 * Gets the prop listener.
	 *
	 * @return the prop listener
	 */
	public SelectionListener getPropListener() {
		return propListener;
	}

	/**
	 * Sets the prop listener.
	 *
	 * @param propListener the new prop listener
	 */
	public void setPropListener(SelectionListener propListener) {
		this.propListener = propListener;
	}


}

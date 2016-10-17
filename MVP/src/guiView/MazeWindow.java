package guiView;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
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

public class MazeWindow extends BasicWindow {
	protected Maze3d maze;
	protected Position currentPos;
	protected SearchSolution <Position> solution;
	protected Menu toolbar,file,game;
	protected MenuItem fileItem,saveItem,loadItem,gameItem,exitItem,generateItem,solveItem,hintItem;
	protected SelectionListener saveListener,loadListener,exitListener,generateListener,solvListener,hintListener;
	protected String fileName;
	protected MazeDisplay maze3d;
	protected KeyListener keyboardListner;
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
		generateItem.setText("&Generate");
		solveItem=new MenuItem(game, SWT.PUSH);
		solveItem.setText("&Solve");
		hintItem=new MenuItem(game, SWT.PUSH);
		hintItem.setText("&Hint");
		
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
		loadItem.addSelectionListener(saveListener);
		
		
		exitItem.addSelectionListener(exitListener);
		
		solveItem.addSelectionListener(solvListener);
		
		//hintItem.addSelectionListener(hintListener);
		
		
		
		
		
		generateItem.addSelectionListener(generateListener);
		
		
		maze3d = new MazeGuiDisplay(shell, SWT.DOUBLE_BUFFERED, 'x');
		maze3d.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2));
		
	

		
	
	}
	
	
	public MazeDisplay getMazeGuiDisplay()
	{
		return maze3d;
	}
	
	public void setPositionDispaly(Position p) {
		 maze3d.setCurrentPos(p);
	}

	public Menu getToolbar() {
		return toolbar;
	}

	public void setToolbar(Menu toolbar) {
		this.toolbar = toolbar;
	}

	public Menu getFile() {
		return file;
	}

	public void setFile(Menu file) {
		this.file = file;
	}

	public Menu getGame() {
		return game;
	}

	public void setGame(Menu game) {
		this.game = game;
	}

	public MenuItem getFileItem() {
		return fileItem;
	}

	public void setFileItem(MenuItem fileItem) {
		this.fileItem = fileItem;
	}

	public MenuItem getSaveItem() {
		return saveItem;
	}

	public void setSaveItem(MenuItem saveItem) {
		this.saveItem = saveItem;
	}

	public MenuItem getLoadItem() {
		return loadItem;
	}

	public void setLoadItem(MenuItem loadItem) {
		this.loadItem = loadItem;
	}

	public MenuItem getGameItem() {
		return gameItem;
	}

	public void setGameItem(MenuItem gameItem) {
		this.gameItem = gameItem;
	}

	public MenuItem getExitItem() {
		return exitItem;
	}

	public void setExitItem(MenuItem exitItem) {
		this.exitItem = exitItem;
	}

	public MenuItem getGenerateItem() {
		return generateItem;
	}

	public void setGenerateItem(MenuItem generateItem) {
		this.generateItem = generateItem;
	}

	public MenuItem getSolveItem() {
		return solveItem;
	}

	public void setSolveItem(MenuItem solveItem) {
		this.solveItem = solveItem;
	}

	public MenuItem getHintItem() {
		return hintItem;
	}

	public void setHintItem(MenuItem hintItem) {
		this.hintItem = hintItem;
	}

	public SelectionListener getSaveListener() {
		return saveListener;
	}

	public void setSaveListener(SelectionListener saveListener) {
		this.saveListener = saveListener;
	}

	public SelectionListener getLoadListener() {
		return loadListener;
	}

	public void setLoadListener(SelectionListener loadListener) {
		this.loadListener = loadListener;
	}

	public SelectionListener getExitListener() {
		return exitListener;
	}

	public void setExitListener(SelectionListener exitListener) {
		this.exitListener = exitListener;
	}

	public SelectionListener getGenerateListener() {
		return generateListener;
	}

	public void setGenerateListener(SelectionListener generateListener) {
		this.generateListener = generateListener;
	}

	public SelectionListener getSolvListener() {
		return solvListener;
	}

	public void setSolvListener(SelectionListener solvListener) {
		this.solvListener = solvListener;
	}

	public SelectionListener getHintListener() {
		return hintListener;
	}

	public void setHintListener(SelectionListener hintListener) {
		this.hintListener = hintListener;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
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

	public Maze3d getMaze() {
		return maze;
	}

	public void setMaze(Maze3d maze) {
		this.maze = maze;
		if(maze3d != null)
			maze3d.setMaze3d(maze);
	}

	public Position getCurrentPos() {
		return currentPos;
	}

	public void setCurrentPos(Position currentPos) {
		this.currentPos = currentPos;
	}

	public MazeDisplay getMaze3d() {
		return maze3d;
	}

	public void setMaze3d(MazeDisplay maze3d) {
		this.maze3d = maze3d;
	}

	public KeyListener getKeyboardListner() {
		return keyboardListner;
	}

	public void setKeyboardListner(KeyListener keyboardListner) {
		this.keyboardListner = keyboardListner;
	}

	public SearchSolution<Position> getSolution() {
		return solution;
	}

	public void setSolution(SearchSolution<Position> solution) {
		this.solution = solution;
	}
	//add the array solution to mazedisplay.
	public void setMazeDisplaySolution(SearchSolution<Position> solution){
		maze3d.setSolution(solution);
	}


}

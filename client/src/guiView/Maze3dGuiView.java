package guiView;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.SearchSolution;
import guiProperties.MessageWindow;
import presenter.Command;
import presenter.Properties;

public class Maze3dGuiView extends AbstractGuiView {

	MazeWindow mw;
	Properties properties;
	


	public Maze3dGuiView(String title,int width,int height,BufferedReader in, PrintWriter out) {
		super(in, out);
		mw=new MazeWindow(title, width, height);
		this.properties=new Properties();
		mw.setSaveListener(new SelectionListener() {
	
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				String file =mw.getFileName();
				setChanged();
				notifyObservers("save " + file);

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});


		
		
		
		mw.setHintListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				MazeGuiDisplay mgd = (MazeGuiDisplay) mw.getMazeGuiDisplay();
				mgd.newSolve(false);
			
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		

		mw.setLoadListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				String file = mw.getFileName();

				if (file == null){

					//	display("No file is selected");

					return;

				}
				String mazeName = new File(file).getName();
				
				mazeName = mazeName.substring(0, mazeName.indexOf("."));
				
				setChanged();

				notifyObservers("load "+ file +" "+ mazeName);
				

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		mw.setExitListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				setChanged();
				notifyObservers("exit");
				mw.shell.dispose();


			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		mw.setGenerateListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {

				setChanged();
				notifyObservers("generate");
				
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		mw.setSolvListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				setChanged();
				notifyObservers("solve");

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		
		mw.setPropListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				new Thread(new Runnable(){

					@Override
					public void run() {
						MessageWindow messageWindow = new MessageWindow("Properties Game" , 600, 800);
						messageWindow.run();
						Properties tempProp = new Properties();
						try{
							// the XMLDecoder class is used to read XML documents created 
							XMLDecoder xml = new XMLDecoder(new BufferedInputStream(new FileInputStream("Properties.xml")));
							tempProp = (Properties) xml.readObject();
							xml.close();
							setChanged();
							notifyObservers(tempProp);
						} catch (FileNotFoundException e){
							e.printStackTrace();
						}
					}	
				}).start();
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});

	}


	public void display(String message) {
		mw.displayError(message);
	}

	@Override
	public void V_setProperties(Properties prop) {
		if (properties.getChooseView() != null)
			if (!properties.getChooseView().equals(prop.getChooseView())) {
				setChanged();
				notifyObservers("replace userInterface");
			} else
				this.properties = prop;

	}

	@Override
	public void V_displayPosition(Position position) {
		mw.setCurrentPos(position);
		mw.setPositionDispaly(position);

	}

	@Override
	public void V_start() throws IOException {
		mw.run();

	}

	@Override
	public void V_displayStringArray(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void V_displayMessage(String msg) {
		System.out.println(msg);
	}

	@Override
	public void V_setCommands(HashMap<String, Command> command) {
		// TODO Auto-generated method stub

	}

	@Override
	public void V_displayCrossSectionBy(int[][] Maze2d) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> void V_printdisplaySolution(SearchSolution<Position> posArray) {
		mw.setSolution(posArray);
		mw.setMazeDisplaySolution(posArray);
		if(posArray!=null){
			for(int i=0;i<posArray.getSolution().size();i++){
				out.println(posArray.getSolution().get(i) +" ");
			}
			out.flush();
		}

		MazeGuiDisplay mbd = (MazeGuiDisplay) mw.getMazeGuiDisplay();
		mbd.displaySolution();		
	}




	@Override
	public void V_printMazeSize(byte[] b) {
		// TODO Auto-generated method stub

	}

	@Override
	public void V_printAllMaze(Maze3d maze) {
		mw.setMaze(maze);
		MazeGuiDisplay mgd = (MazeGuiDisplay) mw.getMazeGuiDisplay();
		mw.setCurrentPos(maze.getStartPosition());
		mw.setPositionDispaly(maze.getStartPosition());
		maze.printMaze3d();
		mgd.draw();


	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub

	}

}

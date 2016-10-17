package guiView;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;
import algorithms.search.State;

public class MazeGuiDisplay extends MazeDisplay {

	protected char axis;
	protected int pos1,pos2;
	protected int goalX,goalY,goalZ;
	protected Image playerImage,goalImage,winImage,wallImage,backImage,traceImage,upImage,downImage,updownImage;
	protected int index;
	protected MazeWindow mw;
	Thread run;
	boolean running;
	Thread solve;
	ExecutorService threadSolve;
	MazeGuiDisplay(Composite parent, int style,char axis) {
		super(parent, style);		
		backImage=new Image(getDisplay(), "images/background.jpg");
		setBackgroundImage(backImage);
		this.axis=axis;
		running = false;
		threadSolve = Executors.newFixedThreadPool(1);
		
	
		
	}

	public void draw()
	{

		playerImage=new Image(getDisplay(), "images/poohPlayer.png");
		goalImage=new Image(getDisplay(), "images/hunnyGoal.png");
		wallImage=new Image(getDisplay(), "images/wall.png");
		winImage=new Image(getDisplay(), "images/win.jpg");
		backImage=new Image(getDisplay(), "images/background.jpg");
		traceImage=new Image(getDisplay(), "images/trace.png");
		upImage=new Image(getDisplay(), "images/up.png");
		downImage=new Image(getDisplay(), "images/down.png");
		updownImage=new Image(getDisplay(), "images/upDown.png");
		solution=null;
		backImage=new Image(getDisplay(), "images/background.jpg");
		setBackgroundImage(backImage);


		addPaintListener(new PaintListener() {

			@Override
			public void paintControl(PaintEvent e) {	
				int width = getSize().x;
				int height = getSize().y;
				goalX=maze3d.getGoalPosition().getX();
				goalY=maze3d.getGoalPosition().getY();
				goalZ=maze3d.getGoalPosition().getZ();
				
				int h= height /  maze3d.getP().getY();
				int w= width / maze3d.getP().getZ();



				
				for(int i=0;i<maze3d.getP().getY();i++)
					for(int j=0;j<maze3d.getP().getZ();j++){ {	
						int x = i * h;
						int y = j * w;	

						if(!maze3d.haveSpace(currentPos.getX(), i, j)){
							e.gc.drawImage(wallImage, 0, 0, wallImage.getBounds().width,wallImage.getBounds().height , y, x, w, h);
						}

						if(maze3d.haveSpace(currentPos.getX(), i, j) && maze3d.haveSpace(currentPos.getX() + 2, i,j) && maze3d.haveSpace(currentPos.getX() - 2, i,j))
							  e.gc.drawImage(updownImage, 0, 0, updownImage.getBounds().width,updownImage.getBounds().height , y, x, w, h);
				          else if(maze3d.haveSpace(currentPos.getX(), i, j) && maze3d.haveSpace(currentPos.getX() + 2, i,j))
				        	  e.gc.drawImage(upImage, 0, 0, upImage.getBounds().width,upImage.getBounds().height , y, x, w, h);
				          else if(maze3d.haveSpace(currentPos.getX(), i, j) && maze3d.haveSpace(currentPos.getX() - 2, i,j))
				        	  e.gc.drawImage(downImage, 0, 0, downImage.getBounds().width,downImage.getBounds().height , y, x, w, h);
						
						if (i == currentPos.getY() && j == currentPos.getZ()) {
							e.gc.drawImage(playerImage, 0, 0, playerImage.getBounds().width, playerImage.getBounds().height, y, x, w, h);
						}
						if (i == goalY && j == goalZ && currentPos.getX() == goalX-2) {
							e.gc.drawImage(goalImage, 0, 0, goalImage.getBounds().width, goalImage.getBounds().height,y ,x, w, h);
						} 
						

						if(currentPos.getX() == goalX-2 && currentPos.getZ() == goalZ && currentPos.getY() == goalY)
						{
							e.gc.drawImage(winImage, 0, 0, winImage.getBounds().width, winImage.getBounds().height, 0, 0, getSize().x, getSize().y);
							running = false;
						}
					}
					}
		

			}	
		});
		
	
	addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent key) {
		//		if(!maze3d.isSolving())
					switch(key.keyCode)
					{
					case SWT.ARROW_DOWN:
						moveBack();
						break;
					case SWT.ARROW_UP:
						moveForward();
						break;
					case SWT.ARROW_LEFT:
						moveLeft();
						break;
					case SWT.ARROW_RIGHT:
						moveRight();
						break;
					case SWT.PAGE_UP:
						moveUp();
						break;
					case SWT.PAGE_DOWN:
						moveDown();
						break;
					}
			}
		});
		

	}
	private void moveCharacter(int x,int y, int z){
		if(currentPos.getX() == goalX && currentPos.getY() == goalZ && currentPos.getZ() == goalY)
      	  return;
		
		if(x>=0 && x < maze3d.getP().getX() && y>=0 && y<maze3d.getP().getY() && z>=0 && z<maze3d.getP().getZ() && maze3d.haveSpace(x, y, z)){
			currentPos.setX(x);
			currentPos.setY(y);
			currentPos.setZ(z);

			run=new Thread(new Runnable() {
				
				@Override
				public void run() {
					redraw();
					//draw();
				}
			});
			getDisplay().syncExec(run);
		
		}
	}

	
	public void moveUp() {
		int x = currentPos.getX() + 2;
		int y = currentPos.getY();
		int z = currentPos.getZ();
		
		moveCharacter(x, y, z);
	}


	public void moveDown() {
		int x = currentPos.getX() - 2;
		int y = currentPos.getY();
		int z = currentPos.getZ();
		
		moveCharacter(x, y, z);
	}

	
	public void moveLeft() {
		int x = currentPos.getX();
		int y =currentPos.getY();
		int z = currentPos.getZ()-1;
		
		moveCharacter(x, y, z);
	}


	public void moveRight() {
		int x = currentPos.getX();
		int y = currentPos.getY();
		int z = currentPos.getZ() + 1;
		
		moveCharacter(x, y, z);
	}


	public void moveForward() {
		int x = currentPos.getX();
		int y = currentPos.getY() - 1;
		int z = currentPos.getZ();
		
		moveCharacter(x, y, z);
	}

	
	public void moveBack() {
		int x = currentPos.getX();
		int y = currentPos.getY()+1;
		int z = currentPos.getZ();
		
		moveCharacter(x, y, z);
	}

	@Override
	public boolean isSolving() {
		
		return false;
	}
	
	
	
	public void displaySolution()
	{
	
		this.running = true;
		solve=new Thread(new Runnable() {	
			@Override
			public void run() {
				while(running)
				{
				
					int x,y,z;
				ArrayList<State<Position>> sol = solution.getSolution();
				if(sol != null)
				{
					System.out.println("Here");
				}
				else
				{
					System.out.println("Null");
				}
				
				for(int i=0;i<sol.size()-1;i++)
				{
				
					State<Position> p=sol.get(i);
					x=p.getState().getX();
					y=p.getState().getY();
					z=p.getState().getZ();
					  moveCharacter(x,y,z);
					  System.out.println("{" + x + "," + y + "," + z + "}");
					try {
						if(i != sol.size() - 2)
							Thread.sleep(700);
					} catch (InterruptedException e) {}
				}
				running = false;
				}
			}
		});
		threadSolve.execute(solve);
		
	}
public void setRunning(boolean running){ 
		
		if(!running)
		{
			this.running=running;
			if(run != null)
				while(run.isAlive());
			threadSolve.shutdown();
		}
	}
	/**
	 * set that new solve is occur
	 * @param running
	 */
	public void newSolve(boolean running){ 
		
		if(!running)
			this.running=running;
	}
	
	
	
	
	
}








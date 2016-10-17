package boot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.eclipse.swt.internal.theme.Theme;

import model.MyModel;
import presenter.Presenter;
import view.AbstractView;
import view.MyView;
import guiView.Maze3dGuiView;
import guiView.MazeWindow;
import model.AbstractModel;

public class Run {

	public static void main(String[] args) throws IOException {

//
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				AbstractModel model = new MyModel();
				AbstractView view = new Maze3dGuiView("Maze3dGuiDisplayer", 1200, 750, new BufferedReader(new InputStreamReader(System.in)),
				new PrintWriter(System.out));
				Presenter presenter = new Presenter(view, model);
				model.addObserver(presenter);
				view.addObserver(presenter);
				try {
					view.V_start();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		
//		
//				MyView myView= new MyView(new BufferedReader(new InputStreamReader(System.in)), new PrintWriter(System.out));
//				MyModel myModel=new MyModel();
//				Presenter myPresenter=new Presenter(myView,myModel);
//				myView.addObserver(myPresenter);
//				myModel.addObserver(myPresenter);
//				
//				myView.V_start();
	
	}

	}




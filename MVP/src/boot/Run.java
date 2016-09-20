package boot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

import model.MyModel;
import presenter.Command;
import presenter.Presenter;
import view.MyView;





public class Run {

	public static void main(String[] args) throws IOException {
		MyModel myModel= new MyModel();
		MyView myView= new MyView(new BufferedReader(new InputStreamReader(System.in)), new PrintWriter(System.out));
		Presenter myPresenter=new Presenter(myView,myModel);
		myView.addObserver(myPresenter);
		myModel.addObserver(myPresenter);
		
		myView.V_start();
	

		
	}

}

package boot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

import Controller.Command;
import Controller.Controller;
import Controller.MyController;
import Model.Model;
import Model.MyModel;
import View.CLI;
import View.MyView;
import View.View;

public class Run {

	public static void main(String[] args) throws IOException {
//		Controller controller = new MyController();
//		View view = new MyView(controller);
//		Model model = new MyModel(controller);
//		controller.setModel(model);
//		controller.setView(view);
//		controller.setHashMap();
//		CLI client = new CLI(new BufferedReader(new InputStreamReader(System.in)), new PrintWriter(System.out, true),
//				controller.getCommand(), view);
//		view.setClient(client);
//		view.start();
		
		
		MyModel myModel= new MyModel();
		MyView myView= new MyView(new BufferedReader(new InputStreamReader(System.in)), new PrintWriter(System.out), new HashMap<String, Command>());
		MyController myController= new MyController(myModel,myView);
		myController.setView(myView);
		
		myModel.setC(myController);
		myView.setC(myController);
		//CLI cli=new CLI(myView.getIn(), myView.getOut(), myView.getCommands());
		//myView.setCli(cli);
		myView.V_start();
	

	}

}

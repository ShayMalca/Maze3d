package presenter;

import algorithms.mazeGenerators.Position;

public class DisplaySolution extends AbstractCommand {

	public DisplaySolution(Presenter presenter) {
		super(presenter);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCommand(String command) {
		String[] temp = command.split(" ");
		if (temp.length > 4) {
			presenter.getUi().V_displayMessage("wrong input");
		} else {
			String mazeName = temp[0];
			//how to cast?
			presenter.getUi().V_printdisplaySolution(presenter.getModel().getMazeSolution(mazeName));
		
		
		}

	}

}
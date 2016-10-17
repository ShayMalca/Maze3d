package presenter;

public class DisplaySolution extends AbstractCommand {

	public DisplaySolution(Presenter presenter) {
		super(presenter);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCommand(String command) {
		String[] temp = command.split(" ");
		if (temp.length != 2) {
			presenter.getView().V_displayMessage("wrong input");
		} else {
			String mazeName = temp[1];
			//presenter.getView().V_printdisplaySolution(presenter.getModel().getMazeSolution(mazeName));


		}

	}


}

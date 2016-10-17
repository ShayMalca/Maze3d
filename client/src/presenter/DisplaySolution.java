package presenter;


/**
 * The Class DisplaySolution.
 */
public class DisplaySolution extends AbstractCommand {

	/**
	 * Instantiates a new display solution.
	 *
	 * @param presenter the presenter
	 */
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

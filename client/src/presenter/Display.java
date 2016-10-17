package presenter;

/**
 * The Class Display.
 */
public class Display extends AbstractCommand {

	/**
	 * Instantiates a new display.
	 *
	 * @param presenter the presenter
	 */
	public Display(Presenter presenter) {
		super(presenter);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void doCommand(String command) {
	String [] temp=command.split(" ");
		
		if (temp.length > 2) {
			this.presenter.getView().V_displayMessage("wrong input\n");
		} else {
			String mazeName = temp[0];
			presenter.getModel().display(mazeName);
		}

	}

}

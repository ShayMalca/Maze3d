package presenter;

/**
 * The Class Exit.
 */
public class Exit extends AbstractCommand {

	/**
	 * Instantiates a new exit.
	 *
	 * @param presenter the presenter
	 */
	public Exit(Presenter presenter) {
		super(presenter);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void doCommand(String command) {
		presenter.getModel().exit();
		presenter.getView().exit();

	}

}

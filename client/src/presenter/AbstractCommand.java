package presenter;

/**
 * The Class AbstractCommand.
 */
public abstract class AbstractCommand implements Command {

	/** The presenter. */
	protected Presenter presenter;
	
	/**
	 * Instantiates a new abstract command.
	 *
	 * @param presenter the presenter
	 */
	public AbstractCommand(Presenter presenter) {
		super();
		this.presenter = presenter;
	}
	
	@Override
	public abstract void doCommand(String command);

	/**
	 * Gets the presenter.
	 *
	 * @return the presenter
	 */
	public Presenter getPresenter() {
		return presenter;
	}

	/**
	 * Sets the presenter.
	 *
	 * @param presenter the new presenter
	 */
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}

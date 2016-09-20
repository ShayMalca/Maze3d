package presenter;

public abstract class AbstractCommand implements Command {

	protected Presenter presenter;
	public AbstractCommand(Presenter presenter) {
		super();
		this.presenter = presenter;
	}

	public abstract void doCommand(String command);

	public Presenter getPresenter() {
		return presenter;
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
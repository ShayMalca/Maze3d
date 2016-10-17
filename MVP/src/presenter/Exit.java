package presenter;

public class Exit extends AbstractCommand {

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

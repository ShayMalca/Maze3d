package presenter;

public class Generate extends AbstractCommand {

	public Generate(Presenter presenter) {
		super(presenter);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCommand(String command) {
		presenter.getModel().generate(command);

	}

}

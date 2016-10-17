package presenter;

public class Generate3dMaze extends AbstractCommand {

	public Generate3dMaze(Presenter presenter) {
		super(presenter);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCommand(String command) {
		presenter.getModel().generate(command);

	}

}

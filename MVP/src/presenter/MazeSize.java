package presenter;

public class MazeSize extends AbstractCommand {

	public MazeSize(Presenter presenter) {
		super(presenter);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCommand(String command) {
		String[] tempArr = command.split(" ");
		if (tempArr.length> 3) {
			presenter.getView().V_displayMessage("Invalid parameters");
		} else {
			String mazeName = tempArr[0];
			presenter.getModel().mazeSize(mazeName);
		}
	}

}

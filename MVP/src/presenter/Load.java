package presenter;

public class Load extends AbstractCommand {

	public Load(Presenter presenter) {
		super(presenter);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCommand(String command) {
		String[] tempArr = command.split(" ");
		if (tempArr.length < 1) {
			presenter.getUi().V_displayMessage("Invalid Input");
		} else if (tempArr[0].equals("zip")) {
			presenter.getModel().loadFromZip();
		} else {
			String fileName = tempArr[0];
			String mazeName = tempArr[1];
			presenter.getModel().loadMaze(fileName, mazeName);
		}
	}
}
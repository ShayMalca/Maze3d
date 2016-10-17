package presenter;

public class LoadMaze extends AbstractCommand {

	public LoadMaze(Presenter presenter) {
		super(presenter);
		// TODO Auto-generated constructor stub
	}

//	@Override
//	public void doCommand(String command) {
//		String[] tempArr = command.split(" ");
//		if (tempArr.length < 1) {
//			presenter.getView().V_displayMessage("Invalid Input");
//		} else if (tempArr[0].equals("zip")) {
//			presenter.getModel().loadFromZip();
//		} else {
//			String fileName = tempArr[1];
//			String mazeName = tempArr[2];
//			presenter.getModel().loadMaze(fileName, mazeName);
//		//	presenter.getModel().loadFromZip();
//		}
//
//	}

	@Override

	public void doCommand(String command) {

		String[] tempArr = command.split(" ");

		if (tempArr.length < 1) {

			presenter.getView().V_displayMessage("Invalid Input");

		} else if (tempArr[0].equals("zip")) {

			presenter.getModel().loadFromZip();

		} else {

			String fileName = tempArr[0];

			String mazeName = tempArr[1];

			presenter.getModel().loadMaze(fileName, mazeName);

		}

	}

}

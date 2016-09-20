package presenter;

public class Solve extends AbstractCommand {

	public Solve(Presenter presenter) {
		super(presenter);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCommand(String command) {
		String[] tempArr = command.split(" ");
		if (tempArr.length >4){
			presenter.getUi().V_displayMessage("Invalid Input");
	}else{
		String name = tempArr[0];
		presenter.getModel().solveMaze(name);
		}
	}
}

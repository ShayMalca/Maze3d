package presenter;

public class Moves extends AbstractCommand {

	public Moves(Presenter presenter) {
		super(presenter);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCommand(String command) {
		switch (command){
		case "up":
			presenter.getModel().moveUp();
			break;
		case "down":
			presenter.getModel().moveDown();
			break;
		case "right":
			presenter.getModel().moveRight();
			break;
		case "left":
			presenter.getModel().moveLeft();
			break;
		case "forward":
			presenter.getModel().moveForward();
			break;
		case "backward":
			presenter.getModel().moveBackward();
			break;
		default: 
			presenter.getView().V_displayMessage("move does not exist!");
			break;
		}

	}

}

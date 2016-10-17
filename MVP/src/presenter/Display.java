package presenter;

public class Display extends AbstractCommand {

	public Display(Presenter presenter) {
		super(presenter);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCommand(String command) {
	String [] temp=command.split(" ");
		
		if (temp.length > 2) {
			this.presenter.getView().V_displayMessage("wrong input\n");
		} else {
			String mazeName = temp[0];
			presenter.getModel().display(mazeName);
		}

	}

}

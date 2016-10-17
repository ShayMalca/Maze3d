package presenter;

/**
 * The Class FileSize.
 */
public class FileSize extends AbstractCommand {

	/**
	 * Instantiates a new file size.
	 *
	 * @param presenter the presenter
	 */
	public FileSize(Presenter presenter) {
		super(presenter);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void doCommand(String command) {
		String[] tempArr = command.split(" ");
		if (tempArr.length > 50){
			presenter.getView().V_displayMessage("Invalid input");
		} else{
			String name = tempArr[0];
			presenter.getModel().fileSize(name);
			
		}
	}

	}



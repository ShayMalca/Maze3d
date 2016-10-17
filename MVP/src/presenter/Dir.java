package presenter;

import java.io.File;

/**
 * The Class Dir.
 */
public class Dir extends AbstractCommand {

	/**
	 * Instantiates a new dir.
	 *
	 * @param presenter the presenter
	 */
	public Dir(Presenter presenter) {
		super(presenter);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see presenter.AbstractCommand#doCommand(java.lang.String)
	 */
	@Override
	public void doCommand(String command) {
		if(command == null)
			this.presenter.getView().V_displayMessage("wrong input\n");
		else{
			try {
				String [] temp=command.split(" ");
				File file = new File(temp[1]);
				if(file.list().length == 0)
					this.presenter.getView().V_displayMessage("empty file error\n");
				else
					this.presenter.getView().V_displayStringArray(file.list());
			}
			catch (NullPointerException e){
				this.presenter.getView().V_displayMessage("wrong path\n");
			}

		}

	}

}

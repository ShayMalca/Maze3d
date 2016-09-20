package presenter;

import java.io.File;

public class Dir extends AbstractCommand {

	public Dir(Presenter presenter) {
		super(presenter);
		// TODO Auto-generated constructor stub
	}

	public void doCommand(String command) {
		if(command == null)
			this.presenter.getUi().V_displayMessage("wrong input\n");
		else{
			try {
				String [] temp=command.split(" ");
				File file = new File(temp[0]);
				if(file.list().length == 0)
					this.presenter.getUi().V_displayMessage("empty file error\n");
				else
					this.presenter.getUi().V_displayStringArray(file.list());
			}
			catch (NullPointerException e){
				this.presenter.getUi().V_displayMessage("wrong path\n");
			}

		}

	}

}
package presenter;

public class Save extends AbstractCommand {

	public Save(Presenter presenter) {
		super(presenter);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCommand(String command) {
		String[] tempArr = command.split(" ");
		if (tempArr.length < 1 ){
			presenter.getUi().V_displayMessage("Invalid Input");
		} else if(tempArr[0].equals("zip")){ // if the command is: save zip mazeName
			presenter.getModel().saveToZip();
		}else{ // if the command is: save mazeName
			String nameMaze = tempArr[0];
			presenter.getModel().saveMaze(nameMaze);
		}
	}


	}



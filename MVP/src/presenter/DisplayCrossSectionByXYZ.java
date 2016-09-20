package presenter;

public class DisplayCrossSectionByXYZ extends AbstractCommand {

	public DisplayCrossSectionByXYZ(Presenter presenter) {
		super(presenter);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCommand(String command) {
		String[] tempArr = command.split(" ");
		//String mazeName;
		int index=0;
		try{
			index=Integer.parseInt(tempArr[0]);
			String xyz = tempArr[1];
			//mazeName = tempArr[3];
			presenter.getModel().getCrossSectionBy(xyz, index);
		}catch (NumberFormatException e){
			presenter.getUi().V_displayMessage("eror");
		}


	}




}
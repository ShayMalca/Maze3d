package presenter;


/**
 * The Class DisplayCrossSectionByXYZ.
 */
public class DisplayCrossSectionByXYZ extends AbstractCommand {

	/**
	 * Instantiates a new display cross section by XYZ.
	 *
	 * @param presenter the presenter
	 */
	public DisplayCrossSectionByXYZ(Presenter presenter) {
		super(presenter);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void doCommand(String command) {
		String[] tempArr = command.split(" ");
		String mazeName;
		int index=0;
		try{
			index=Integer.parseInt(tempArr[1]);
			String xyz = tempArr[0];
			mazeName = tempArr[2];
			presenter.getModel().getCrossSectionBy(mazeName, xyz, index);
		}catch (NumberFormatException e){
			presenter.getView().V_displayMessage("eror");
		}


	}


	

}



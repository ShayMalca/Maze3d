package presenter;

/**
 * The Class Generate3dMaze.
 */
public class Generate3dMaze extends AbstractCommand {

	/**
	 * Instantiates a new generate 3 d maze.
	 *
	 * @param presenter the presenter
	 */
	public Generate3dMaze(Presenter presenter) {
		super(presenter);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCommand(String command) {
		presenter.getModel().generate(command);

	}

}

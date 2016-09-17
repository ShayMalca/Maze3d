package Controller;

public abstract class abstractCommand implements Command {
	
	protected Controller c;
	
	public abstractCommand(Controller c) {
		this.c=c;
	}

	@Override
	public abstract void doCommand(String command);

}

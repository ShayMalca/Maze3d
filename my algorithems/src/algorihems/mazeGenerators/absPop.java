package algorihems.mazeGenerators;

import java.util.ArrayList;

// TODO: 
/**
 * The Class absPop.
 */
public abstract class absPop implements Pop {

/** The arr. */
ArrayList<Position>	arr;
	
	/* (non-Javadoc)
	 * @see algorihems.mazeGenerators.Pop#Pop(java.util.ArrayList)
	 */
	public abstract Position Pop(ArrayList<Position> p);




}

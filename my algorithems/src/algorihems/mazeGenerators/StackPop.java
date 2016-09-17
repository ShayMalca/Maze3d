package algorihems.mazeGenerators;

import java.util.ArrayList;

// TODO: 
/**
 * The Class StackPop.
 */
public class StackPop extends absPop {

	/* (non-Javadoc)
	 * @see algorihems.mazeGenerators.absPop#Pop(java.util.ArrayList)
	 */
	@Override
	public Position Pop(ArrayList<Position> p) {
		
		this.arr = p;
		return arr.get(arr.size()-1);
	}

}

package algorihems.mazeGenerators;

import java.util.ArrayList;
import java.util.Random;

// TODO: 
/**
 * The Class RandomPop.
 */
public class RandomPop extends absPop {

	/* (non-Javadoc)
	 * @see algorihems.mazeGenerators.absPop#Pop(java.util.ArrayList)
	 */
	@Override
	public Position Pop(ArrayList<Position> p) {
	
		Random rand=new Random();
		int randomNum=rand.nextInt(p.size());
		return p.get(randomNum);
		
	}

}

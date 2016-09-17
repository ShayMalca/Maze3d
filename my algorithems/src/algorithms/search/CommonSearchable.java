package algorithms.search;

import java.util.ArrayList;

import algorihems.mazeGenerators.Position;

/**
 * The Class CommonSearchable.
 *
 * @param <T> the generic type
 */
public abstract class CommonSearchable<T> implements Searchable<T> {

	/* (non-Javadoc)
	 * @see algorithms.search.Searchable#getStartState()
	 */
	@Override
	public abstract State<T> getStartState();


	/* (non-Javadoc)
	 * @see algorithms.search.Searchable#getGoalState()
	 */
	@Override
	public abstract State<T> getGoalState();

	
	/* (non-Javadoc)
	 * @see algorithms.search.Searchable#getAllPossibleStates(algorithms.search.State)
	 */
	public abstract ArrayList<State<T>> getAllPossibleStates(State<T> s);
	
	
}

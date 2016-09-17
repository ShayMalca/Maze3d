package algorithms.search;

import java.util.ArrayList;

/**
 * The Class BFSSearcher.
 *
 * @param <T> the generic type
 */
public class BFSSearcher<T> extends CommonSearcher<T> {

	/**
	 * Instantiates a new BFS searcher.
	 */
	public BFSSearcher() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see algorithms.search.CommonSearcher#Search(algorithms.search.Searchable)
	 */
	@Override
	public SearchSolution<T> Search(Searchable<T> s) {

		State<T> n; 
		AddToPriorityQueue(s.getStartState());
		while(open.size()>0)
		{
			n = PopFromPriorityQueue();
			close.add(n);
			if(n.equals(s.getGoalState()))
			{
				return backTrace(s.getStartState(),n);
			}
			ArrayList<State<T>>Successors=new ArrayList<State<T>>();
			Successors=s.getAllPossibleStates(n);
			for (State<T> state : Successors) 
			{
				if(!close.contains(state) &&(!open.contains(state)))
				{
					//add to open.
					state.setCameFrom(n);
					state.setCost(n.getCost()+calculateCostBetweenStates(s, n, state));
					AddToPriorityQueue(state);
				}
				else{
//					if(state.getCameFrom()!=null && n.getCost() < state.getCameFrom().getCost()){
//
//						state.setCameFrom(n);
//						state.setCost(calculateCostBetweenStates(s, n, state));
//					}
//						if (!open.contains(state)) {
//							AddToPriorityQueue(state);
//						} else {
//							removeFromPriorityQueue(state);
//							AddToPriorityQueue(state);
//						}
//					}
					if(n.getCost()+calculateCostBetweenStates(s, n, state)<state.getCost())
					{
						if(!open.contains(state))
						{
							AddToPriorityQueue(state);
						}
						else{
							removeFromPriorityQueue(state);
							AddToPriorityQueue(state);
						}
					}
				
				}
		

	
	}
	
		}
		return null;
	}
	
}

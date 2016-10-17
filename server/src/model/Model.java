package model;

import algorithms.mazeGenerators.Maze3d;

/**
 * The Interface Model.
 */
public interface Model {

	

		/**
		 * Generate.
		 *
		 * @param mazeName the maze name
		 * @param x the x
		 * @param y the y
		 * @param z the z
		 * @return true, if successful
		 */
		boolean generate(String mazeName, int x, int y, int z);

		/**
		 * Gets the maze 3 d.
		 *
		 * @param mazeName the maze name
		 * @return the maze 3 d
		 */
		Maze3d getMaze3d(String mazeName);

		/**
		 * Solve.
		 *
		 * @param mazeName the maze name
		 * @param algorithm the algorithm
		 * @return true, if successful
		 */
		public boolean solve(String mazeName, String algorithm);

		/**
		 * Gets the solution.
		 *
		 * @param mazeName the maze name
		 * @return the solution
		 */
		public String getSolution(String mazeName);

		/**
		 * Save to zip.
		 */
		public void saveToZip();

		/**
		 * Load from zip.
		 */
		public void loadFromZip();

		//public Object getUserCommand(String command);

		/**
		 * Close.
		 */
		public void close();
	
}

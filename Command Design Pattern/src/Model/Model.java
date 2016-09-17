package Model;

import java.io.IOException;

/**
 * The Interface Model.
 */
public interface Model {
	
	/**
	 * M dir.
	 *
	 * @param path the path
	 */
	public void M_dir(String path);
	
	/**
	 * M generate 3 d maze.
	 *
	 * @param mazeName the maze name
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 */
	public void M_generate3dMaze(String mazeName,int x,int y,int z);
	
	/**
	 * M display.
	 *
	 * @param mazeName the maze name
	 */
	public void M_display(String mazeName);
	
	/**
	 * M display cross section by XYZ.
	 *
	 * @param xyz the xyz
	 * @param mazeName the maze name
	 * @param index the index
	 */
	public void M_displayCrossSectionByXYZ(String xyz,String mazeName,int index);
	
	/**
	 * M save maze.
	 *
	 * @param mazeName the maze name
	 * @param file the file
	 */
	public void M_saveMaze(String mazeName,String file);
	
	/**
	 * M load maze.
	 *
	 * @param mazeName the maze name
	 * @param file the file
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void M_loadMaze(String mazeName,String file)throws IOException ;
	
	/**
	 * M maze size.
	 *
	 * @param mazeName the maze name
	 */
	public void M_mazeSize(String mazeName);
	
	/**
	 * M file size.
	 *
	 * @param mazeName the maze name
	 */
	public void M_fileSize(String mazeName);
	
	/**
	 * M solve.
	 *
	 * @param mazeName the maze name
	 * @param Algo the algo
	 */
	public void M_solve(String mazeName,String Algo);
	
	/**
	 * M display solution.
	 *
	 * @param mazeName the maze name
	 */
	public void M_displaySolution(String mazeName);
	
	/**
	 * Exit.
	 */
	public void exit();
	
	

}

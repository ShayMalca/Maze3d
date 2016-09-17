package Controller;

import java.io.IOException;


import Model.Model;
import View.View;

public interface Controller {
	
	
	public void setModel(Model model);
	
	public void setView(View view);
	
	public void C_displayMessage(String msg);
	
	public void C_displayCrossSectionByXYZ(String xyz,String mazeName,int index);
	
	public void C_solve(String mazeName,String Algo);
	
	public void C_saveMaze(String mazeName,String fileName);
	
	public void C_displayMaze(String mazeName);
	
	public void C_mazeSize(String mazeName);
	
	public void C_displayStringArray(String [] args);
	
	public void C_generate3dMaze(String mazeName,int x,int y, int z);
	
	public void C_loadMaze(String mazeName,String fileName) throws IOException;
	
	public void C_fileSize(String mazeName);
	
	public void C_displaySolution(String MazeName);

	
	public void C_exit();
	
	
	
	
	
	
	
	
	
	
	
	

}

package algorihems.mazeGenerators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Maze3d {
	private Position p;	
	private Position start;
	private Position goal;
	int [][][] maze;
	Random rand=new Random();


	/**
	 * Instantiates a new maze 3 d.
	 *
	 * @param p1 the p 1
	 */
	public Maze3d(Position p1) {
		this.p=new Position(p1.getX(),p1.getY(),p1.getZ());
		this.maze=new int[p1.getX()][p1.getY()][p1.getZ()];


	}


	public Maze3d(byte[] b){
		this.p=new Position(b[0],b[1],b[2]);
		this.maze=new int [p.getX()][p.getY()][p.getZ()];
		Position start=new Position(b[3],b[4],b[5]);
		Position goal=new Position(b[6],b[7],b[8]);
		int n=9;
		for (int i = 0; i < p.getX(); i++) {
			for (int j = 0; j < p.getY(); j++) {
				for (int k = 0; k < p.getZ(); k++) {
					
					this.maze[i][j][k]=b[n];
					n++;
				}
			}
		}
		
		setStart(start);
		setGoal(goal);
	

	}

	
	

	public void initMaze(){// The default initialize is that all the positions at the maze is walls
		for(int i=0;i<p.getX();i++){
			for (int j=0;j<p.getY();j++){
				for(int k=0;k<p.getZ();k++){
					maze[i][j][k]=1;
				}
			}
		}

	}



	public void wall(Position p){//This Function is put a wall in any point we want
		maze[p.getX()][p.getY()][p.getZ()]=1;
	}
	public void BreakWall(Position p){//This Function is put a passage in any point we want
		maze[p.getX()][p.getY()][p.getZ()]=0;
	}


	public void setCell(int x,int y,int z,int temp){
		this.maze[x][y][z]=temp;
	}
	public int getCell(int x,int y,int z){
		return maze[x][y][z];
	}

	public void setStart(Position start) {
		//		this.start.setX(start.getX());
		//		this.start.setY(start.getY());
		//		this.start.setZ(start.getZ());
		this.start=start;

	}

	public void setGoal(Position goal) {
		//		this.goal.setX(goal.getX());
		//		this.goal.setY(goal.getY());
		//		this.goal.setZ(goal.getZ());
		this.goal=goal;
	}


	public Position getStartPosition(){
		return start;
	}
	public Position getGoalPosition(){
		return goal;	
	}


	//random start position
	public void GetRandomStartPosition()
	{
		int temp=0;
		do{
			temp=rand.nextInt(p.getZ()-2);
		}while(temp%2==0);
		start=new Position(0,0,temp+1);
	}
	public void createLimits(){
		for (int i=0;i<p.getY();i++){
			for(int j=0;j<p.getZ();j++){
				maze[i][0][j]=1;
				maze[i][j][0]=1;
				maze[i][j][p.getZ()-1]=1;
				maze[i][p.getY()-1][j]=1;
				maze[0][i][j]=1;
				maze[1][i][j]=1;
				maze[p.getX()-2][i][j]=1;
				maze[p.getX()-1][i][j]=1;
			}
		}




	}

	public void GetRandomGoalPosition()
	{
		int temp=0;
		do{
			temp=rand.nextInt(p.getZ()-1);
		}while(temp%2!=0||temp==0);
		goal=new Position(p.getX()-1,p.getY()-1,temp);

	}



	//print
	@Override
	public String toString() {
		String s1 = new String();

		for (int i = 0; i < p.getX(); i++) {
			for (int j = 0; j < p.getY() ; j++) {
				for (int k = 0; k< p.getZ() ; k++) {
					s1 += maze[i][j][k];
				}

				s1 += "\n";
			}

			s1 += "\n";
		}
		return s1;
	}


	public int [][] getCrossSectionByX(int n)throws IndexOutOfBoundsException{
		if(n<0||n>=maze.length)
			throw new IndexOutOfBoundsException("Out of bounds");
		else
		{
			int[][]arr=new int [maze[0].length][maze[0][0].length];
			for(int i=0;i<maze[0].length;i++)
			{
				for(int j=0;j<maze[0][0].length;j++)
				{
					arr[i][j]=maze[n][i][j];
				}
			}
			return arr;
		}
	}

	public int[][] getCrossSectionByY(int n) throws IndexOutOfBoundsException{
		if((n<0)||(n>=maze[0].length))
			throw new IndexOutOfBoundsException("Out of bounds");
		else
		{
			int[][]arr=new int[maze.length][maze[0][0].length];
			for(int i=0;i<maze.length;i++)
				for(int j=0;j<maze[0][0].length;j++)
					arr[i][j]=maze[i][n][j];
			return arr;
		}
	}

	public int[][] getCrossSectionByZ(int n) throws IndexOutOfBoundsException{
		if((n<0)||(n>=maze[0][0].length))
			throw new IndexOutOfBoundsException("Out of bounds");
		int[][]arr=new int[maze.length][maze[0].length];
		for(int i=0;i<maze.length;i++)
			for(int j=0;j<maze[0].length;j++)
				arr[i][j]=maze[i][j][n];
		return arr;
	}


	public void print2dMaze(int [][] arr){
		for (int i = 0; i < arr[0].length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[j][i]+" ");
			}
			System.out.println();
		}

	}




	//check the limits of the maze;
	public String[] isLegal(Position p1)
	{
		ArrayList<String> s=new ArrayList<String>();

		if((p1.getX()==0)){

			s.add("Up");
			String [] tempS=new String[s.size()];
			s.toArray(tempS);
			return tempS;
		}

		if((p1.getX()==p.getX())){

			s.add("Down");
			String [] tempS=new String[s.size()];
			s.toArray(tempS);
			return tempS;
		}



		if(p1.getX()+1<this.p.getX()){
			s.add("Up");

		}
		if(p1.getX()>0){
			s.add("Down");

		}
		if(p1.getY()+1<this.p.getY()){
			s.add("Forward");

		}
		if(p1.getY()>0){
			s.add("Backward");

		}
		if(p1.getZ()+1<this.p.getZ()){
			s.add("Right");

		}
		if(p1.getZ()>0){
			s.add("Left");

		}
		String [] tempS=new String[s.size()];
		s.toArray(tempS);
		return tempS;

	}





	public String [] getPossibleMoves(Position p1)
	{
		ArrayList<String> s=new ArrayList<String>();

		if(p1.getX()+1<this.p.getX()&&(maze[p1.getX()+1][p1.getY()][p1.getZ()]==0)){
			s.add("Up");

		}
		if(p1.getX()>0&&(maze[p1.getX()-1][p1.getY()][p1.getZ()]==0)){
			s.add("Down");

		}
		if(p1.getY()+1<this.p.getY()&&(maze[p1.getX()][p1.getY()+1][p1.getZ()]==0)){
			s.add("Forward");

		}
		if(p1.getY()>0&&(maze[p1.getX()][p1.getY()-1][p1.getZ()]==0)){
			s.add("BackWard");

		}
		if(p1.getZ()+1<this.p.getZ()&&(maze[p1.getX()][p1.getY()][p1.getZ()+1]==0)){
			s.add("Right");

		}
		if(p1.getZ()>0&&(maze[p1.getX()][p1.getY()][p1.getZ()-1]==0)){
			s.add("Left");

		}
		String [] tempS=new String[s.size()];
		s.toArray(tempS);
		return tempS;
	}


	public void RandomMove(String[] Moves,Position p)
	{
		String move;
		Random rand=new Random();

		int randomNum=rand.nextInt(Moves.length);
		move=Moves[randomNum];

		switch(move){

		case "Up":
			p.setX(p.getX()+2);	
			break;
		case "Down":
			p.setX(p.getX()-2);	
			break;
		case "Forward":
			p.setY(p.getY()+2);
			break;

		case "Backward":
			p.setY(p.getY()-2);
			break;

		case "Right":
			p.setZ(p.getZ()+2);
			break;

		case "Left":
			p.setZ(p.getZ()-2);
			break;


		default:

			System.out.println("No Move to play");
			break;

		}

	}


	public Position getP() {
		return p;
	}




	public void setP(Position p) {
		this.p = p;
	}



	public byte[] toByteArray() {
		byte[] b = new byte[p.getX() * p.getY()* p.getZ() + 9];

		// maze dimensions
		b[0] = (byte) p.getX();
		b[1] = (byte) p.getY();
		b[2] = (byte) p.getZ();

		// start position
		b[3] = (byte) getStartPosition().getX();
		b[4] = (byte) getStartPosition().getY();
		b[5] = (byte) getStartPosition().getZ();

		// end position
		b[6] = (byte) getGoalPosition().getX();
		b[7] = (byte) getGoalPosition().getY();
		b[8] = (byte) getGoalPosition().getZ();

		// maze
		int i = 9;
		for (int x = 0; x < p.getX(); x++) {
			for (int y = 0; y < p.getY(); y++) {
				for (int z = 0; z < p.getZ(); z++) {
					b[i] = (byte) maze[x][y][z];
					i++;
				}
			}
		}
		return b;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goal == null) ? 0 : goal.hashCode());
		result = prime * result + Arrays.deepHashCode(maze);
		result = prime * result + ((p == null) ? 0 : p.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Maze3d other = (Maze3d) obj;
		if (goal == null) {
			if (other.goal != null)
				return false;
		} else if (!goal.equals(other.goal))
			return false;
		if (!Arrays.deepEquals(maze, other.maze))
			return false;
		if (p == null) {
			if (other.p != null)
				return false;
		} else if (!p.equals(other.p))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		return true;
	}


	public int[][][] getMaze() {
		return maze;
	}


	public void setMaze(int[][][] maze) {
		this.maze = maze;
	}
	
	public void printMaze3d(){
		for(int i=0;i<getP().getX();i++){
			for(int j=0;j<getP().getY();j++){
				for(int k=0;k<getP().getZ();k++)
				{
					System.out.print(maze[i][j][k]+" ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}

















}
package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import algorihems.mazeGenerators.GrowingTreeGeneraor;
import algorihems.mazeGenerators.Maze3d;
import algorihems.mazeGenerators.Position;
import algorihems.mazeGenerators.StackPop;

public class Run {



	public static void main(String[] args) throws IOException {
		
		Position p= new Position(5,5,5);
		Maze3d maze=new Maze3d(p);
		 maze=new GrowingTreeGeneraor(new StackPop()).generate(p);
		// save it to a file
		OutputStream out=new MyCompressorOutputStream(
		new FileOutputStream("1.maz"));
		out.write(maze.toByteArray());
		out.flush();
		out.close();
		InputStream in=new MyDecompressorInputStream(new FileInputStream("1.maz"));
		byte b[]=new byte[maze.toByteArray().length];
		in.read(b);
		in.close();
		Maze3d loaded=new Maze3d(b);
		System.out.println(loaded.equals(maze));

		
		
		
	}

}

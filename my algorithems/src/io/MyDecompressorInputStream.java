package io;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * The Class MyDecompressorInputStream.
 */
public class MyDecompressorInputStream extends InputStream {


	/** The in. */
	private InputStream in;
	
	/** The check num. */
	private int checkNum;
	
	/** The count. */
	private int count;
	
	/**
	 * Instantiates a new my decompressor input stream.
	 *
	 * @param in the in
	 */
	public MyDecompressorInputStream(InputStream in) {

		this.in=in;
		this.checkNum=0;
		this.count=0;


	}



	/* (non-Javadoc)
	 * @see java.io.InputStream#read()
	 */
	@Override
	public int read() throws IOException {
		return 0;

	}




	/**
	 * Read.
	 *
	 * @param b the b
	 * @return the int
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public int read(int b) throws IOException {
		in.read();
		return -1;
	}




	/* (non-Javadoc)
	 * @see java.io.InputStream#read(byte[])
	 */
	public int read(byte[] arr) throws IOException {

		int index=0;
		checkNum=in.read();
		count=in.read();
		while(checkNum!=-1 && count!=-1)
		{
			for(int i = 0; i<count; i++)
			{
				arr[index] = (byte)checkNum;
				index++;

			}
			checkNum=in.read();
			count=in.read();
		}
		in.close();
		return 0;
	}



















}

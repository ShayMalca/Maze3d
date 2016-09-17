package io;

import java.io.IOException;
import java.io.OutputStream;

/**
 * The Class MyCompressorOutputStream.
 */
public class MyCompressorOutputStream extends OutputStream {

	/** The out. */
	private OutputStream out;
	
	/** The count. */
	private int count;
	
	/** The check num. */
	private int checkNum;

	/**
	 * Instantiates a new my compressor output stream.
	 *
	 * @param out the out
	 */
	public MyCompressorOutputStream(OutputStream out) {
		this.out=out;
		this.count=0;
		this.checkNum=0;
	}

	/* (non-Javadoc)
	 * @see java.io.OutputStream#write(int)
	 */
	@Override
	public void write(int b) throws IOException {

		if(count==0){

			checkNum=b;
			count++;
		}

		else if(checkNum==b){

			count++;
		}
		else{
			while(count>255){
				out.write(checkNum);
				out.write(255);
				count-=255;
			}
			out.write(checkNum);
			out.write(count);
			checkNum=b;
			count=1;
		}

	}


	/* (non-Javadoc)
	 * @see java.io.OutputStream#write(byte[])
	 */
	public void write(byte[] arr)throws IOException{


		for(int i=0;i<arr.length;i++)
		{
			write(arr[i]);
		}
		//need to check.
		out.write(checkNum);
		out.write(count);
		out.close();



	}

	/**
	 * Gets the out.
	 *
	 * @return the out
	 */
	public OutputStream getOut() {
		return out;
	}

	/**
	 * Sets the out.
	 *
	 * @param out the new out
	 */
	public void setOut(OutputStream out) {
		this.out = out;
	}

	/**
	 * Gets the count.
	 *
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Sets the count.
	 *
	 * @param count the new count
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * Gets the check num.
	 *
	 * @return the check num
	 */
	public int getCheckNum() {
		return checkNum;
	}

	/**
	 * Sets the check num.
	 *
	 * @param checkNum the new check num
	 */
	public void setCheckNum(int checkNum) {
		this.checkNum = checkNum;
	}



}



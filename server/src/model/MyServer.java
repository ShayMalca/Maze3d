package model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import controller.Controller;


/**
 * The Class MyServer.
 */
public class MyServer {
	
	/** The port. */
	int port;

	/** The server. */
	ServerSocket server;

	

	/** The client handler. */
	ClientHandler clientHandler;

	/** The num of clients. */
	int numOfClients;

	/** The threadpool. */
	ExecutorService threadpool;

	

	/** The stop. */
	volatile boolean stop;

	

	/** The main server thread. */
	Thread mainServerThread;

	/** The controller. */
	Controller controller;

	/** The clients handled. */
	int clientsHandled = 0;

	

	/**
	 * C'tor.
	 *
	 * @param port the port
	 * @param clientHandler the client handler
	 * @param numOfClients the num of clients
	 * @param controller the controller
	 */

	public MyServer(int port, ClientHandler clientHandler, int numOfClients, Controller controller) {

		super();

		this.port = port;

		this.clientHandler = clientHandler;

		this.numOfClients = numOfClients;

		this.controller = controller;

		this.stop = false;

	}

	/**
	 * This method start the for-loop witch listen to the clients who want to connect the server.
	 */

	public void start() {

		try {

			server = new ServerSocket(port);

			server.setSoTimeout(10 * 1000);

		} catch (IOException e) {

			e.printStackTrace();

		}

		threadpool = Executors.newFixedThreadPool(numOfClients);



		mainServerThread = new Thread(new Runnable() {



			@Override

			public void run() {
				System.out.println("Server is running");
				while (!stop) {

					try {

						// server.accept() - return socket for some client

						final Socket someClient = server.accept();

						if (someClient != null) {

							threadpool.execute(new Runnable() {



								/* (non-Javadoc)
								 * @see java.lang.Runnable#run()
								 */
								@Override

								public void run() {

									try {

										clientsHandled++;
									     System.out.println(clientsHandled);


										controller.display("handling client " + clientsHandled);

										clientHandler.handleClient(someClient.getInputStream(),someClient.getOutputStream());

										someClient.close();

										controller.display("done handling client " + clientsHandled);

									} catch (IOException e) {

										e.printStackTrace();

									}

								}

							});

						}

					} catch (SocketTimeoutException e) {

						// System.out.println("no clinet connected...");

					} catch (IOException e) {

						e.printStackTrace();

					}

				}

				// controller.display("done accepting new clients.");

			}// end of the mainServerThread task

		});

		mainServerThread.start();

	}



	/**
	 * This method stop the communication with the server.
	 */

	public void close(){

		stop = true;

		// do not execute jobs in queue, continue to execute running threads

		threadpool.shutdown();

		// wait 10 seconds over and over again until all running jobs have finished

		try {

			while (!(threadpool.awaitTermination(10, TimeUnit.SECONDS))) {

				threadpool.shutdown();

			}

			System.out.println("all the tasks have finished");

			// join means that after mainServerThread will finish, the next rows

			// in the code will implement

			mainServerThread.join();

			System.out.println("main server thread is done");

			System.out.println("server is safely closed");

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

		try {

			server.close();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}
}

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Server {
	static final int DEFAULT_PORT = 5000;
    public static void main(String[] args) throws IOException {
    	ServerSocket serverSocket = null;
		boolean listening = true;
		int servPort;
		String serverPort = null;
		Scanner fromKeyboard = new Scanner(System.in);
		System.out.print("Enter port, or press return to use default:");

		if ((serverPort = fromKeyboard.nextLine()).length() == 0)
			servPort = DEFAULT_PORT;
		else
			servPort = Integer.parseInt(serverPort);	
		
		try {
			serverSocket = new ServerSocket(servPort);
		} catch (IOException e) {
			System.err.println("Could not listen on port: 8007.");
			System.exit(-1);
		}
        System.out.println("TicTacToe Server is up and running.....");
		while (listening)
		{
			Socket clntSock1 = serverSocket.accept();
			System.out.println("Incoming request 1 accepted");
			System.out.println("Waiting for second connection...");
			Socket clntSock2 = serverSocket.accept(); 
			System.out.println("Incoming request 2 accepted");
			ServerMultiplayer gameThread = new ServerMultiplayer(clntSock1, clntSock2);
			Thread T = new Thread(gameThread);
			System.out.println("Starting Thread");
			T.start();
		}
		serverSocket.close();
    }
}
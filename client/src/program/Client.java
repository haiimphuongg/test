package program;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import controller.ClientListener;
import view.ClientDesign;

public class Client {
	
	//private ClientDesign clientDesign ; 
	public static  Socket client = null;
	public static BufferedWriter out = null;
	public static BufferedReader in = null;
//	
//	public static void Connect() throws IOException {
//		final String serverHost = "localhost";
//		
//		try {
//			client = new Socket(serverHost, 9999);
//			out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
//			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
//			
//		}  catch (UnknownHostException e) {
//	        System.err.println("Don't know about host " + serverHost);
//	        return;
//	    } catch (IOException e) {
//	        System.err.println("Couldn't get I/O for the connection to " + serverHost);
//	        return;
//	    }
//				
//	}
}

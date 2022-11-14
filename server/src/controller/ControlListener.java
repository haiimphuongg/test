package controller;
import java.io.*;

import java.io.IOException;

import Program.Server;

public class ControlListener {
	public void ShutdownListener() {
		Runtime runtime = Runtime.getRuntime() ;
		try {
			Server.server.close();
			Server.client.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	    try
	    {
	       System.out.println("Shutting down the PC after 5 seconds.");
	       runtime.exec("shutdown -s -t 20");
	    }
	    catch(IOException e)
	    {
	       System.out.println("Exception: " +e);
	    }
	}
	
	
	public void RestartListener() {
		Runtime runtime = Runtime.getRuntime() ;
		try {
			Server.server.close();
			Server.client.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	    try
	    {
	       System.out.println("Restarting the PC after 20 seconds.");
	       runtime.exec("shutdown -r -t 20");
	    }
	    catch(IOException e)
	    {
	       System.out.println("Exception: " +e);
	    }
	}
	
	public ControlListener() throws IOException {
		String requestLine = Server.in.readLine();
		if (requestLine.equals("SHUTDOWN"))
		{
			this.ShutdownListener();
		}
		else if(requestLine.equals("RESTART"))
		{
			this.RestartListener();
		}
		else if(requestLine.equals("EXIT_CONTROL"))
		{
			return;
		}
	}
}


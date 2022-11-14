package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import javax.swing.JOptionPane;

import Program.Server;
import view.ServerDesign;

public class ServerListener implements ActionListener{
	private ServerDesign serverDesign;
	
	public ServerListener(ServerDesign serverDesign) {
		this.serverDesign = serverDesign;
	}
	
	// Create connect [Done] =========================================================================
	private void StartServer() throws IOException {
            try {
            	int port = 6789;
                Server.server = new ServerSocket(port);
                Server.client = Server.server.accept();
                Server.in = new BufferedReader(new InputStreamReader(Server.client.getInputStream()));
                Server.out = new BufferedWriter(new OutputStreamWriter(Server.client.getOutputStream()));
                //JOptionPane.showMessageDialog(null, "Connected successfully!");
            } catch (Exception e){
                //e1.printStackTrace();
    			//JOptionPane.showMessageDialog(null, "Error!" + e1.getMessage());
            }  

	}
	// ===============================================================================================

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Connect =================================
		try {
			StartServer();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//==========================================

		
		// Choose features
		boolean isRunning = true;
		while (isRunning)
        {
			System.out.println("\n[here] menu");
			String s = null;
			try {
				s = Server.in.readLine();
				
				System.out.println("[server] menu receive: " + s); // msg from client
				
				if(s.equals("APPLICATION")) new AppListener().main(null);
				else if(s.equals("PROCESS")) new ProcessListener().main(null);
				else if(s.equals("KEYSTROKE")) new KeyLogListener();
				else if(s.equals("CONTROL")) new ControlListener();
				else if(s.equals("EXIT")) isRunning = false;
				else isRunning = false;
				
			} catch(Exception e1) {
				isRunning = false;
			}
        }
		
		try {
			Server.server.close();
			Server.client.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
}	


package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

import program.*;
import view.AppDesign;
import view.ClientDesign;
import view.KeylogDesign;
import view.ProcessDesign;

public class ClientListener implements ActionListener{
	private ClientDesign clientDesign;
	//PrintStream out = new PrintStream( socket.getOutputStream() );
    //BufferedReader in = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
    
	public ClientListener(ClientDesign clientDesign) {
		this.clientDesign = clientDesign;
	}

	private void ConnectListener() throws IOException {
		boolean test = true;
		try {
			int port = 6789;
			Client.client = new Socket(clientDesign.txtIP.getText(), port);
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error!" + e.getMessage());
            test = false;
            Client.client = null;
			//e.printStackTrace();
		}
		if(test) {
            JOptionPane.showMessageDialog(null, "Connected successfully!");

            // Create input and output streams to read from and write to the server
            Client.in = new BufferedReader(new InputStreamReader(Client.client.getInputStream()));
            Client.out = new BufferedWriter(new OutputStreamWriter(Client.client.getOutputStream()));
		}
	}
		
	private void AppListener() throws IOException {
		if(Client.client == null) {
			JOptionPane.showMessageDialog(null, "Not connected to the server");
			return;
		}
		String s = "APPLICATION";
		Client.out.write(s);
		Client.out.flush();
		new AppDesign().setVisible(true);
	}
	
	private void ProcessListener() throws IOException {
		if(Client.client == null) {
			JOptionPane.showMessageDialog(null, "Not connected to the server");
			return;
		}
		String s = "PROCESS";
		Client.out.write(s);
		Client.out.flush();
		new ProcessDesign().setVisible(true);
	}
	
	private void ExitListener() throws IOException {
		String s = "EXIT";
		if(Client.client != null) {
			Client.out.write(s);
			Client.out.newLine();
			Client.out.flush();
			Client.client.close();
		}
		clientDesign.setVisible(false);
		// THOAT FRAME
	}
	
	
	private void KeylogListener() throws IOException{
		if(Client.client == null) {
			JOptionPane.showMessageDialog(null, "Not connected to the server");
			return;
		}
		String s = "KEYSTROKE";
		Client.out.write(s);
		Client.out.newLine();
		Client.out.flush();
		new KeylogDesign().setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String click = e.getActionCommand();
		
		if(click.equals("Connect"))
			try {
				ConnectListener() ;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		if(click.equals("App Running"))
			try {
				AppListener();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		if(click.equals("Process Running"))
			try {
				ProcessListener();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
		if(click.equals("Exit"))
			try {
				ExitListener();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		if(click.equals("Keystroke"))
			try {
				KeylogListener();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
}
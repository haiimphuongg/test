package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

import Program.Client;
import view.AppDesign;
import view.ClientDesign;
import view.KeylogDesign;
import view.ProcessDesign;

public class ClientListener implements ActionListener{
	private ClientDesign clientDesign;
	private AppDesign appDesign;
	private ProcessDesign processDesign;
	private KeylogDesign keylogDesign;
	public ClientListener(ClientDesign clientDesign) {
		this.clientDesign = clientDesign;
	}

	// Connect [Done] ================================================================================
	private void ConnectListener() throws IOException {
		boolean test = true;
		try {
			int port = 6789;
			Client.client = new Socket(clientDesign.txtIP.getText(), port);
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Cannot connect to " + e.getMessage());
            test = false;
            Client.client = null;
		}
		if(test) {
            JOptionPane.showMessageDialog(null, "Connected successfully!");

            // Create input and output streams to read from and write to the server
            Client.in = new BufferedReader(new InputStreamReader(Client.client.getInputStream()));
            Client.out = new BufferedWriter(new OutputStreamWriter(Client.client.getOutputStream()));
		}
	}
	// ===============================================================================================
	
	private void AppListener() throws IOException {
		if(Client.client == null) {
			JOptionPane.showMessageDialog(null, "Not connected to the server");
			return;
		}
		String s = "APPLICATION";
		Client.out.write(s);
		Client.out.newLine();
		Client.out.flush();
		this.appDesign.main(null);
	}
		
	private void ProcessListener() throws IOException {
		if(Client.client == null) {
			JOptionPane.showMessageDialog(null, "Not connected to the server");
			return;
		}
		String s = "PROCESS";
		Client.out.write(s);
		Client.out.newLine();
		Client.out.flush();
		this.processDesign.main(null);
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
		this.keylogDesign.main(null);
		
	} 
	
	private void ExitListener() throws IOException {
		String s = "EXIT";
		if(Client.client != null) {
			Client.out.write(s);
			Client.out.newLine();
			Client.out.flush();
		}
		clientDesign.setVisible(false);
		// THOAT FRAME
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String click = e.getActionCommand();
		
		// Connect =================================
		
		if(click.equals("Connect"))
			try {
				this.ConnectListener() ;
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		
		
		// Application =============================
		
		if(click.equals("App Running"))
			try {
				this.AppListener();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		
		
		// Process ==================================

		if(click.equals("Process Running"))
			try {
				this.ProcessListener();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		
		
		// Keystroke ==========================================
		
		if (click.equals("Keystroke"))
		{
			System.out.println("in keystroke");
			try {
				this.KeylogListener();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		
		if(click.equals("Exit"))
			try {
				this.ExitListener();
			} catch (IOException e1) {
				e1.printStackTrace();
			}		
	}
}	

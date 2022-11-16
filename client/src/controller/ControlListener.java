package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import model.Client;
import view.ControlDesign;

public class ControlListener implements ActionListener {
	private ControlDesign controlDesign;
	public ControlListener(ControlDesign controlDesign ) {
		this.controlDesign = controlDesign;
	}
	
	
	private void ShutdownListenner() throws IOException{
		String s = "SHUTDOWN";
		Client.out.write(s);
		Client.out.newLine();
		Client.out.flush();
		this.controlDesign.dispose();
		Client.client.close();
	}
	
	private void RestrarListener() throws IOException{
		
		String s = "RESTART";
		Client.out.write(s);
		Client.out.newLine();
		Client.out.flush();
		this.controlDesign.dispose();
		Client.client.close();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String scr = e.getActionCommand();
		
		if (scr.equals("SHUT DOWN"))
		{
			try {
				this.ShutdownListenner();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (scr.equals("RESTART"))
		{
			try {
				this.RestrarListener();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
}

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import model.Client;
import view.StopDesign;

public class StopListener implements ActionListener{
	//private AppDesign appDesign;
	private StopDesign stopDesign;
	
	public StopListener(StopDesign stopDesign) {
		this.stopDesign = stopDesign;
	}
	
	public void actionPerformed(ActionEvent e) {
		String ID = stopDesign.txtID.getText();
		System.out.println(ID);
		try {
			Client.out.write(ID);
			Client.out.newLine();
			Client.out.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		// Kiem tra lai message
		String s = null;
		try {
			s = Client.in.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        JOptionPane.showMessageDialog(null, s);
	}
}
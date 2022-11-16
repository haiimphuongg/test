package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import model.*;
import view.*;

public class StartListener implements ActionListener {
	private StartDesign startDesign;
	
	public StartListener(StartDesign startDesign) {
		this.startDesign = startDesign;
	}

	public void actionPerformed(ActionEvent e) {
		String name = startDesign.txtName.getText();
		
//		try {
//			Client.out.write("START_NAME");
//			Client.out.newLine();
//			Client.out.flush();
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
		
		String s = null;
//		try {
//			s = Client.in.readLine();
//		} catch (IOException e2) {
//			e2.printStackTrace();
//		}
		
//		if(s.equals("OKE"))
			try {
				Client.out.write(name);
				Client.out.newLine();
				Client.out.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
//		else JOptionPane.showMessageDialog(null, s); 

		// Kiem tra lai message
		try {
			s = Client.in.readLine();
		} catch (IOException e1) {
		}
        JOptionPane.showMessageDialog(null, s);
	}
}

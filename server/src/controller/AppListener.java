package controller;

import java.io.IOException;
import java.lang.System;
import java.util.Scanner;

import Program.Server;

public class AppListener {	
	
	// List [Done] ========================================================
	
	private static void List() throws IOException, InterruptedException {
		Process process = new ProcessBuilder("powershell","\"gps| ? {$_.mainwindowtitle.length -ne 0} | Format-Table -HideTableHeaders  name, ID").start(); 
		new Thread(() -> {
			Scanner sc = new Scanner(process.getInputStream());
			if (sc.hasNextLine()) sc.nextLine();
			while (sc.hasNextLine()) {
			    String info = sc.nextLine();
			    
			    if(info.length() == 0) continue;
			    	                
			    int pLastName = info.indexOf(" ");
				int pFirstID = info.lastIndexOf(" ") + 1;
				String name = info.substring(0, pLastName);
				String ID = info.substring(pFirstID);
				
				try {
					Server.out.write(name);
					Server.out.newLine();
					Server.out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				try {
					Server.out.write(ID);
					Server.out.newLine();
					Server.out.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				System.out.print(name + " ");
			    System.out.println(ID);
			}
		}).start();   
	    process.waitFor();
		Server.out.write("Done");
   		Server.out.newLine();
   		Server.out.flush();
	}
	
	// ====================================================================

	private static void Start(String nameApp) throws IOException {
		while(true) {
			System.out.println("\n[here] start app controller");
			
//			while (true) {
//				String s = Server.in.readLine();
//				if(s.equals("EXIT_START")) {
//					return;
//				}
//				if (!s.equals("START_NAME")) {
//					Server.out.write("Please exit START dialog before using another feature!");
//					Server.out.newLine();
//					Server.out.flush();
//				}
//				else {
//					Server.out.write("OKE");
//					Server.out.newLine();
//					Server.out.flush();
//					break;
//				}
//			}
			
			try {
				nameApp = Server.in.readLine();
				System.out.println("[server] start app receive: " + nameApp);
				if(nameApp.equals("EXIT_START")) {
					return;
				}
				try {
					//Process process = new ProcessBuilder(nameApp + ".exe").start();
					Runtime.getRuntime().exec("powershell -command \"Start-Process " + nameApp);
					Server.out.write("Start " + nameApp);
					Server.out.newLine();
					Server.out.flush();
				} catch (Exception e) {
					Server.out.write("Server do not install this application");
					Server.out.newLine();
					Server.out.flush();		
				}
			} catch(Exception e) {
			}
			
		}
	}
//	
	private static void Stop() throws IOException, InterruptedException {
		while(true) {
			System.out.println("\n[here] stop app controller");
			String msg = null;
			try {
				msg = Server.in.readLine();
				System.out.println("[server] stop app receive: " + msg);
				if(msg.equals("EXIT_STOP")) {
					return;
				}
				try {
					long pid = Integer.parseInt(msg.toString());				
					ProcessHandle.of(pid).ifPresent(ProcessHandle::destroyForcibly);
					Server.out.write("Stopped application!");
					Server.out.newLine();
					Server.out.flush();
				} catch (Exception e) {
					Server.out.write("[Error] Cannot stop the application");
					Server.out.newLine();
					Server.out.flush();
				}
			} catch(Exception e) {
			}
		}
		
	}
	
	public void main(String[] args) throws IOException, InterruptedException
    {		
		while (true)
        {
			System.out.println("\n[here] app controller");
			String s = null;
			try {
				s = Server.in.readLine();
			} catch(Exception e) {
				s =  "EXIT_APP";
			}
			System.out.println("[server] app receive: " + s);
			
			if(s.equals("LIST")) List();
			else if(s.equals("START")) Start(null);
			else if(s.equals("STOP")) Stop();
			else if(s.equals("EXIT_APP")) return;
//			else JOptionPane.showMessageDialog(null, "");
        }
    }
}
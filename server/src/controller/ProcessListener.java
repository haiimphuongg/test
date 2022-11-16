package controller;

import java.io.IOException;
import java.lang.System;
import java.util.Scanner;

import javax.swing.JOptionPane;


import Program.Server;

public class ProcessListener {
	
	// List [Done] ========================================================
	
	private static void List() throws IOException, InterruptedException {
		Process process = new ProcessBuilder("powershell","\"gps| Format-Table -HideTableHeaders  name, ID").start(); 
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
			System.out.println("\n[here] start process controller");

			try {
				nameApp = Server.in.readLine();
				System.out.println("[server] start process receive: " + nameApp);
				if(nameApp.equals("EXIT_START")) {
					return;
				}
				try {
					Runtime.getRuntime().exec("powershell -command \"Start-Process " + nameApp);
					//Process process = new ProcessBuilder(nameApp + ".exe").start();
					Server.out.write("Start " + nameApp);
					Server.out.newLine();
					Server.out.flush();
				} catch (Exception e) {
					Server.out.write("Server do not have this process");
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
			System.out.println("\n[here] stop process controller");
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
					Server.out.write("Stopped process!");
					Server.out.newLine();
					Server.out.flush();
				} catch (Exception e) {
					Server.out.write("[Error] Cannot stop the process");
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
			System.out.println("\n[here] process controller");
			String s = null;
			try {
				s = Server.in.readLine();
			} catch(Exception e) {
				s =  "EXIT_PROCESS";
			}
			System.out.println("[server] process receive: " + s);
			//System.out.println(s.length());
			
			if(s.equals("LIST")) List();
			else if(s.equals("START")) Start(null);
			else if(s.equals("STOP")) Stop();
			else if(s.equals("EXIT_PROCESS")) return;
			else JOptionPane.showMessageDialog(null, "Please exit application dialog begin use another feature!");

//            switch (s)
//            {
//                case "KEYLOG": ; break;
//                case "SHUTDOWN": ; break;
//                case "CAPTURE": ; break;
//                case "PROCESS": ; break;
//                case "APPLICATION":
//                	System.out.println("hehehe");
//                	//new AppListener().main(null); 
//                	//break;     
//                case "EXIT": return;
//            }
        }
//		while(true) {
//			ReceiveSignal signal = new ReceiveSignal();
//			System.out.println(signal);
//			break;
//		}

		//Stop();
//        try {
// 
//            // create a new process
//            System.out.println("Creating Process");
// 
//            
// 
//            // wait 10 seconds
//            System.out.println("Waiting");
//            Thread.sleep(10000);
// 
//            // kill the process
//            
//        }
//        catch (Exception ex) {
//            ex.printStackTrace();
//        }
    }
}
package Program;

import java.net.ServerSocket;
import java.net.Socket;

import view.ServerDesign;

import java.io.*;

import controller.AppListener;

public class Server {
	static public ServerSocket server;
	static public Socket client;
	static public BufferedReader in;
	static public BufferedWriter out;

	// PROCESS
//	public static void main(String[] args) throws IOException, InterruptedException {
//		Process process = new ProcessBuilder("tasklist.exe").start();//, "/fo", "csv").start();
//	    //System.out.println(process.pid());
//		
//		new Thread(() -> {
//	        Scanner sc = new Scanner(process.getInputStream());
//	        if (sc.hasNextLine()) sc.nextLine();
//	        while (sc.hasNextLine()) {
//	            String line = sc.nextLine();
//	            String[] parts = line.split(",");
//	            String unq = parts[0].substring(1).replaceFirst(".$", "");
//	            String pid = parts[1].substring(1).replaceFirst(".$", "");
//            if(parts[3].substring(1).replaceFirst(".$", "").equals("0")) {
//	                System.out.println(unq + " " + pid);
//	            }
//      }
//	    }).start();
//	    process.waitFor();
//	    System.out.println("Done");
//	}
	
//	APPLICATION
//	public static void main(String[] args) throws IOException, InterruptedException {
//		new ServerDesign().setVisible(true);
//		   Process process = new ProcessBuilder("powershell","\"gps| ? {$_.mainwindowtitle.length -ne 0} | Format-Table -HideTableHeaders  name, ID").start(); 
//		   
//		   new Thread(() -> {
//	            Scanner sc = new Scanner(process.getInputStream());
//	            if (sc.hasNextLine()) sc.nextLine();
//	            while (sc.hasNextLine()) {
//	                String line = sc.nextLine();
//	                String[] parts = line.split(" ");
//	                System.out.println(line);	     
//	            }
//	        }).start();
//	    process.waitFor();
//		System.out.println("Done");
//	}


}

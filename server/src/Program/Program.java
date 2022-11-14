package Program;

import java.io.IOException;
import java.net.InetAddress;

import javax.swing.JOptionPane;

import controller.AppListener;
import view.ServerDesign;

public class Program {
	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("Server Start Success!");
        InetAddress IP=InetAddress.getLocalHost();
        JOptionPane.showMessageDialog(null, "IP of your system is := "+IP.getHostAddress(),"Message", JOptionPane.WARNING_MESSAGE);

		ServerDesign.main(null);
	}
}

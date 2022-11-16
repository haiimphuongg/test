package view;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AppListener;
import controller.ClientListener;
import model.Client;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;

public class ClientDesign extends JFrame {
	public JPanel contentPane;
	public JTextField txtIP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientDesign frame = new ClientDesign();
					frame.setVisible(true);
					frame.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							String s = "EXIT";
							if(Client.client == null) {
								return;
							}
							else {
							try {
								Client.out.write(s);
								Client.out.newLine();
								Client.out.flush();
							} catch (IOException e1) {
								return;
							}
							}
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientDesign() {
		setTitle("Client");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 452, 284);
		setLocationRelativeTo(null); // center
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtIP = new JTextField();
		txtIP.setText(" Enter IP:");
		txtIP.setBounds(20, 10, 305, 35);
		contentPane.add(txtIP);
		txtIP.setColumns(10);
		
		ActionListener ac = new ClientListener(this);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(ac);
		btnConnect.setBounds(335, 9, 85, 35);
		contentPane.add(btnConnect);
		
		JButton btnApp = new JButton("App Running");
		btnApp.setBounds(20, 54, 140, 80);
		btnApp.addActionListener(ac);
		contentPane.add(btnApp);
		
		JButton btnKeystroke = new JButton("Keystroke");
		btnKeystroke.addActionListener(ac);
		btnKeystroke.setBounds(170, 54, 120, 80);
		contentPane.add(btnKeystroke);
		
		JButton btnCapture = new JButton("Capture");
		//btnCapture.addActionListener(ac);
		btnCapture.setBounds(300, 54, 120, 80);
		contentPane.add(btnCapture);
		
		JButton btnProcess = new JButton("Process Running");
		btnProcess.addActionListener(ac);
		btnProcess.setBounds(20, 144, 140, 80);
		contentPane.add(btnProcess);
		
		JButton btnShutdown = new JButton("Control");
		btnShutdown.addActionListener(ac);
		btnShutdown.setBounds(170, 144, 120, 80);
		contentPane.add(btnShutdown);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(ac);
		btnExit.setBounds(300, 144, 120, 80);
		contentPane.add(btnExit);
	}
}

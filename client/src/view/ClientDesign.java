package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ClientListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;

public class ClientDesign extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txtIP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ClientDesign();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public ClientDesign() {
		
		setTitle("Client");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtIP = new JTextField();
		txtIP.setText(" Enter IP:");
		txtIP.setBounds(20, 10, 305, 34);
		contentPane.add(txtIP);
		txtIP.setColumns(10);
		
		ActionListener act = new ClientListener(this);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(act);
		btnConnect.setBounds(335, 9, 85, 35);
		contentPane.add(btnConnect);
		
		JButton btnApp = new JButton("App Running");
		btnApp.addActionListener(act);
		btnApp.setBounds(20, 54, 140, 80);
		contentPane.add(btnApp);
		
		JButton btnKeystroke = new JButton("Keystroke");
		btnKeystroke.addActionListener(act);
		btnKeystroke.setBounds(170, 54, 120, 80);
		contentPane.add(btnKeystroke);
		
		JButton btnCapture = new JButton("Capture");
		btnCapture.addActionListener(act);
		btnCapture.setBounds(300, 54, 120, 80);
		contentPane.add(btnCapture);
		
		JButton btnProcess = new JButton("Process Running");
		btnProcess.addActionListener(act);
		btnProcess.setBounds(20, 144, 140, 80);
		contentPane.add(btnProcess);
		
		JButton btnShutdown = new JButton("Shutdown");
		btnShutdown.addActionListener(act);
		btnShutdown.setBounds(170, 144, 120, 80);
		contentPane.add(btnShutdown);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(act);
		btnExit.setBounds(300, 144, 120, 80);
		contentPane.add(btnExit);
		
		this.setVisible(true);
	}
}

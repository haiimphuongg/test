package view;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.StopListener;
import model.Client;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;

public class StopDesign extends JFrame {

	private static final long serialVersionUID = -5150868917346611313L;
	private JPanel contentPane;
	public JTextField txtID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					StopDesign frame = new StopDesign();
					frame.setVisible(true);
					frame.setVisible(true);
					frame.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							String s = "EXIT_STOP";
							try {
								Client.out.write(s);
								Client.out.newLine();
								Client.out.flush();
							} catch (IOException e1) {
								e1.printStackTrace();
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
	public StopDesign() {
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("Stop");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 95);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtID = new JTextField();
		txtID.setBounds(21, 10, 295, 30);
		txtID.setText(" Enter ID:");
		txtID.setToolTipText("Enter ID of app/process you want to stop.");
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		ActionListener ac = new StopListener(this);
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(ac);
		btnStop.setBounds(326, 9, 85, 31);
		contentPane.add(btnStop);
	}

}

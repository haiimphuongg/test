package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControlListener;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ControlDesign extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControlDesign frame = new ControlDesign();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ControlDesign() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 200, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ActionListener act = new ControlListener(this);
		
		JButton btnShutdown = new JButton("SHUT DOWN");
		btnShutdown.addActionListener(act);
		btnShutdown.setBounds(30, 45, 125, 50);
		contentPane.add(btnShutdown);
		
		JButton btnRestart = new JButton("RESTART");
		btnRestart.addActionListener(act);
		btnRestart.setBounds(30, 95, 125, 50);
		contentPane.add(btnRestart);
	}
}

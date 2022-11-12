package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

public class StartProcessDesign extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartProcessDesign frame = new StartProcessDesign();
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
	public StartProcessDesign() {
		setResizable(false);
		setTitle("Start Application");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 95);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtID = new JTextField();
		txtID.setBounds(21, 10, 295, 30);
		txtID.setText(" Enter ID:");
		txtID.setToolTipText("Enter ID of application you want to start.");
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(326, 9, 85, 31);
		contentPane.add(btnStart);
	}

}

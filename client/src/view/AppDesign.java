package view;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.AppListener;
//import controller.ClientListenner;

import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;



public class AppDesign extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnList;
	private JButton btnStart;
	private JButton btnStop;
	private JButton btnClear;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppDesign frame = new AppDesign();
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
	public AppDesign() {
		setTitle("Application");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		ActionListener act = new AppListener(this);
		
		btnList = new JButton("List");
		btnList.addActionListener(act);
		btnList.setBounds(10, 10, 85, 30);
		contentPane.add(btnList);
		
		btnStart = new JButton("Start");
		btnStart.addActionListener(act);
		btnStart.setBounds(120, 10, 85, 30);
		contentPane.add(btnStart);
		
		btnStop = new JButton("Stop");
		btnStop.addActionListener(act);
		btnStop.setBounds(230, 10, 85, 30);
		contentPane.add(btnStop);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(act);
		btnClear.setBounds(340, 10, 85, 30);
		contentPane.add(btnClear);
		
		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 50, 415, 190);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setSurrendersFocusOnKeystroke(true);
		table.setShowGrid(false);
		table.setShowVerticalLines(false);
		table.setRowSelectionAllowed(false);
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name Application", "ID Application", "Count thread"
			}
		));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(91);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane.setViewportView(table);
	}
}

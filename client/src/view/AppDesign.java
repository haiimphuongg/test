package view;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import controller.AppListener;
import model.Client;

import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;

public class AppDesign extends JFrame {

	private JPanel contentPane;
	private JButton btnList;
	private JButton btnStart;
	private JButton btnStop;
	private JButton btnClear;
	private JScrollPane scrollPane;
	public JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					AppDesign frame = new AppDesign();
					frame.setVisible(true);
					frame.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							String s = "EXIT_APP";
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
	public AppDesign() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Application");
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		//contentPane.addC

		ActionListener ac = new AppListener(this);
		
		btnList = new JButton("List");
		btnList.addActionListener(ac);
		btnList.setBounds(10, 10, 85, 30);
		contentPane.add(btnList);
		
		btnStart = new JButton("Start");
		btnStart.addActionListener(ac);
		btnStart.setBounds(120, 10, 85, 30);
		contentPane.add(btnStart);
		
		btnStop = new JButton("Stop");
		btnStop.addActionListener(ac);
		btnStop.setBounds(230, 10, 85, 30);
		contentPane.add(btnStop);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(ac);
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
				"Name Application", "ID Application"
			}
		)); 
		table.getColumnModel().getColumn(0).setResizable(true);
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		table.getColumnModel().getColumn(1).setResizable(true);
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane.setViewportView(table);
	}
	
	public void AddRow(String[] list) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(list);
	}
}

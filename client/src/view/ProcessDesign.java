package view;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
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
import controller.ProcessListener;
import model.Client;

import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;

public class ProcessDesign extends JFrame {

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
					ProcessDesign frame = new ProcessDesign();
					frame.setVisible(true);
					frame.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							String s = "EXIT_PROCESS";
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
	public ProcessDesign() {
		setTitle("Process");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ActionListener ac = new ProcessListener(this);
		
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
		scrollPane.setBounds(10, 50, 415, 190);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name Process", "ID Process"
			}
		));
		scrollPane.setViewportView(table);
		table.setShowHorizontalLines(false);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	}
}

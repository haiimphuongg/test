package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import controller.ClientListener;
import controller.KeylogListener;
import model.Client;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;
//import javax.swing.JLabel;
import java.awt.Font;


public class KeylogDesign extends JFrame{

	public JTextArea text ;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					KeylogDesign frame = new KeylogDesign();
					frame.setVisible(true);
					frame.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							String s = "EXIT_KEYSTROKE";
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
	 * Initialize the contents of the frame.
	 */
	    public KeylogDesign() {
		
		this.setBounds(100, 100, 500, 350);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		ActionListener act = new KeylogListener(this) ;
		
		
		//Tạo JPanel tên panelButton chứa 4 nút HOOK, UNHOOK, SHOW TEXT, CLEAR TEXT
		JPanel panelButton = new JPanel();
		//Tạo kích cỡ, vị trí của panelButton
		panelButton.setBounds(10, 11, 465, 60);
		//Thêm panelButton vào giao diện
		this.getContentPane().add(panelButton);
		panelButton.setLayout(null);
		
		
		//NÚT HOOK
		//Tạo nút HOOK
		JButton btnHook = new JButton("HOOK");
		btnHook.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnHook.addActionListener(act);		
		//Tạo kích cỡ, vị trí nút HOOK
		btnHook.setBounds(10, 5, 100, 50);
		//Thêm nút HOOK vào panelButton
		panelButton.add(btnHook);
		
		
		//NÚT UNHOOK
		//Tạo nút UNHOOK
		JButton btnUnHook = new JButton("UNHOOK");
		btnUnHook.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnUnHook.addActionListener(act);		
		//Tạo kích cỡ, vị trí của nút UNHOOK
		btnUnHook.setBounds(125, 5, 100, 50);
		//Thêm nút UNHOOK vào panelButton
		panelButton.add(btnUnHook);
		
		
		//NÚT SHOW TEXT
		//Tạo nút SHOWTEXT
		JButton btnShowText = new JButton("SHOW TEXT");
		btnShowText.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnShowText.addActionListener(act);
		//Tạo kích cỡ, vị trí của nút SHOWTEXT
		btnShowText.setBounds(240, 5, 100, 50);
		//Thêm nút SHOWTEXT vào panellButton
		panelButton.add(btnShowText);
		
		
		//NÚT CLEAR TEXT
		//Tạo nút CLEARTEXT
		JButton btnClearText = new JButton("CLEAR TEXT");
		btnClearText.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnClearText.addActionListener(act);
		//Tạo kích cỡ, vị trí của nút CLEARTEXT
		btnClearText.setBounds(355, 5, 100, 50);
		//Thêm CLEARTEXT vào panelButton
		panelButton.add(btnClearText);
		
		
		
		
		
		
		//Tạo panelText chứa phần text hiển thị những phím đã bắt được
		JPanel panelText = new JPanel();
	    //Tạo kích cỡ, vị trí của panelText
		panelText.setBounds(10, 75, 465, 190);
		//Thêm panelText vào giao diện
		this.getContentPane().add(panelText);
		panelText.setLayout(null);
		
		//Tạo lblText hiển thị các phím đã bắt được
		text = new JTextArea("");
		text.setEditable(false);
		//Tạo kích cỡ, vị trí của lbl
		text.setBounds(10, 0, 445, 190);
		//Thêm lblText vào panelText
		panelText.add(text);
		
		
		
		
		//Tạo panelBackButton để chứa nút Back to Menu		
		JPanel panelBackButton = new JPanel();
		//Tạo kích cỡ, vị trí của panelBackButton
		panelBackButton.setBounds(10, 275, 465, 30);
		//thêm panelBackButton vào giao diện 
		this.getContentPane().add(panelBackButton);
		panelBackButton.setLayout(null);
//		
//		//Tạo nút Back to Menu 
//		JButton btnBackToMenu = new JButton("Back to Menu");
//		btnBackToMenu.setFont(new Font("Tahoma", Font.BOLD, 11));
//		//Tạo kích cỡ, vị trí cho nút Back to Menu
//		btnBackToMenu.setBounds(338, 0, 117, 30);
//		//Thêm nút Back to Menu vào panelBackButton
//		panelBackButton.add(btnBackToMenu);
	}
}

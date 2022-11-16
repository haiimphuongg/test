package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.table.DefaultTableModel;

import model.*;
import view.*;


public class ProcessListener implements ActionListener{
	private ProcessDesign processDesign;
	private StartDesign startDesign;
	private StopDesign stopDesign;
	
	public ProcessListener(ProcessDesign processDesign) { 
		this.processDesign = processDesign;
	}

	private void List() throws IOException {
		String s = "LIST";
		Client.out.write(s);
		Client.out.newLine();
		Client.out.flush();
		
		String name = null;
		String ID = null;
		this.ClearListener();
		while(true) {
			name = Client.in.readLine();
			if(name.equals("Done")) break; // Da list xong
			ID = Client.in.readLine();
			String list[] = {name, ID};
			System.out.println(list[0] + " " + list[1]);
			DefaultTableModel model = (DefaultTableModel) processDesign.table.getModel();
	        model.addRow(list);
		}
	}
	
	private void Start() throws IOException {
		String s = "START";
		Client.out.write(s);
		Client.out.newLine();
		Client.out.flush();
		this.startDesign.main(null);
	}
	
	private void Stop() throws IOException {
		String s = "STOP";
		Client.out.write(s);
		Client.out.newLine();
		Client.out.flush();
		this.stopDesign.main(null);
	}
	
	private void ClearListener() {
		DefaultTableModel model = (DefaultTableModel) processDesign.table.getModel();
		model.setRowCount(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String click = e.getActionCommand();
		//System.out.println(click);
		if(click.equals("List"))
			try {
				this.List();
			} catch (IOException e2) {
				e2.printStackTrace();
			} 
		
		if(click.equals("Start"))
			try {
				this.Start();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		
		if(click.equals("Stop"))
			try {
				this.Stop();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		
		if(click.equals("Clear")) ClearListener();
	}
}	
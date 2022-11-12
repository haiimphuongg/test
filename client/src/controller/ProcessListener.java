package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import view.ProcessDesign;
import view.StartAppDesign;
import view.StartProcessDesign;
import view.StopAppDesign;
import view.StopProcessDesign;

public class ProcessListener implements ActionListener{
	
	private ProcessDesign processDesign ;
	private StartProcessDesign startProcessDesign = new StartProcessDesign();
	private StopProcessDesign stopProcessDesign = new StopProcessDesign();
	
	public ProcessListener(ProcessDesign processDesign) {
		this.processDesign = processDesign; 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String scr = e.getActionCommand();
		
		if("Start".equals(scr)) {
			StartProcessDesign.main(null);
		}
		
		if("Stop".equals(scr))
		{
			StopProcessDesign.main(null);
		}
		
	}

}

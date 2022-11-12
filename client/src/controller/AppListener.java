package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import view.AppDesign;
import view.StartAppDesign;
import view.StopAppDesign;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;

public class AppListener implements ActionListener{
	
	private AppDesign appDesign ;
	private StartAppDesign startAppDesign = new StartAppDesign();
	private StopAppDesign stopAppDesign = new StopAppDesign();
	
	public AppListener(AppDesign appDesign) {
		this.appDesign = appDesign; 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String scr = e.getActionCommand();
		
		if("Start".equals(scr)) {
			StartAppDesign.main(null);
		}
		
		if("Stop".equals(scr))
		{
			StopAppDesign.main(null);
		}
		
	}

}

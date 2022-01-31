package com.OteoServices.OteoServices_ControlWorkStations.Models;

import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.OteoServices.OteoServices_ControlWorkStations.Interfaces.ICommandable;

public class Command implements ICommandable{
	private String command;
	
	public Command() {
		this.command = "";
	}
	
	public Command(String command) {
		this.command = command;
	}
	
	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public void executeCommand() {	
		System.out.println("Command.class --> executeCommand()");
		
	    try {	
	    	if (this.command == null || this.command == "") {
	    		JOptionPane.showMessageDialog(new JFrame(), "Param command: Null or empty value", "Command.java -> executeCommand()", JOptionPane.ERROR_MESSAGE);
	    		return;
	    	}
	    	
			Runtime.getRuntime().exec("cmd /c start cmd.exe /K " + this.command);
		} catch (IOException ex) {
			ex.printStackTrace();	
			JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), ex.getClass().toString(),JOptionPane.ERROR_MESSAGE);
		}
	}
}

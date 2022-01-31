package com.OteoServices.OteoServices_ControlWorkStations.Models;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.OteoServices.OteoServices_ControlWorkStations.Interfaces.IWorkStationActionable;

public class WorkStation implements IWorkStationActionable {
	public static final int REMOTE_DESKTOP_OPT = 1;
	public static final int WAKEUP_OPT = 2;
	public static final int REBOOT_OPT = 3;
	public static final int SHUTDOWN_OPT = 4;
	
	private int private_identify_number;
	
	private String label_text;
	private String name;
	private String subnet_mask;
	private String user;
	private String pwd;
	private String mac_address;
	private String port_wakeup;
	
	public WorkStation() {
		this.private_identify_number = -1;
		
		this.label_text = "";
		this.name = "";
		this.subnet_mask = "";
		this.user = "";
		this.pwd = "";
		this.mac_address = "";
		this.port_wakeup = "";		
	}
	
	public WorkStation(int private_identify_number, String label_text, String name, String subnet_mask, String user, String pwd, 
			String mac_address, String port_wakeup) {
		this.private_identify_number = private_identify_number;
		this.label_text = label_text;
		this.name = name;
		this.subnet_mask = subnet_mask;
		this.user = user;
		this.pwd = pwd;
		this.mac_address = mac_address;
		this.port_wakeup = port_wakeup;		
	}

	// INI GETTERS & SETTERS
	
	public String getLabel_text() {
		return label_text;
	}

	public void setLabel_text(String label_text) {
		this.label_text = label_text;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubnet_mask() {
		return subnet_mask;
	}

	public void setSubnet_mask(String subnet_mask) {
		this.subnet_mask = subnet_mask;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMac_address() {
		return mac_address;
	}

	public void setMac_address(String mac_address) {
		this.mac_address = mac_address;
	}

	public String getPort_wakeup() {
		return port_wakeup;
	}

	public void setPort_wakeup(String port_wakeup) {
		this.port_wakeup = port_wakeup;
	}
	
	public int getPrivate_identify_number() {
		return private_identify_number;
	}

	public void setPrivate_identify_number(int private_identify_number) {
		this.private_identify_number = private_identify_number;
	}

	// FIN GETTERS & SETTERS
	
	// INI IWorkStationActionable
	
	private boolean validateWsActionable(int option) {
		// 1 -> RemoteDesktop, 2 --> WakeUp, 3 --> Reboot, 4 --> Shutdown
		System.out.println("WorkStation.class --> validateWsActionable()");
		
		if (this.getName() == null || this.getName() == "") {
			JOptionPane.showMessageDialog(new JFrame(), "Param ServerName: Null or empty value", "WorkStation.java -> remoteConnection()", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if (option == 2) {
			if (this.getMac_address() == null || this.getMac_address() == "") {
				JOptionPane.showMessageDialog(new JFrame(), "Param MacAddress: Null or empty value", "WorkStation.java -> wakeUp()", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			if (this.getSubnet_mask() == null || this.getSubnet_mask() == "") {
				JOptionPane.showMessageDialog(new JFrame(), "Param SubnetMask: Null or empty value", "WorkStation.java -> wakeUp()", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			if (this.getPort_wakeup() == null || this.getPort_wakeup() == "") {
				JOptionPane.showMessageDialog(new JFrame(), "Param WakeUpPort: Null or empty value", "WorkStation.java -> wakeUp()", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		
		if (option == 3 || option == 4) {
			if (this.getUser() == null || this.getUser() == "") {
				JOptionPane.showMessageDialog(new JFrame(), "Param User: Null or empty value", "WorkStation.java -> reboot()", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			if (this.getPwd() == null || this.getPwd() == "") {
				JOptionPane.showMessageDialog(new JFrame(), "Param UserPwd: Null or empty value", "WorkStation.java -> reboot()", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		
		return true;
	}
	
	private String createIActionableCommand(StringBuilder params, String batName) {
		System.out.println("WorkStation.class --> createIActionableCommand()");
		
		StringBuilder command = new StringBuilder();
		//command.append(Bat.WS_BATS_PATH_TEST);
		command.append(Bat.WS_BATS_PATH_PROD);
		command.append(batName);
		command.append(params.toString());
		
		return command.toString();
	}
	
	public void remoteConnection() {
		System.out.println("WorkStation.class --> remoteConnection()");
		
		validateWsActionable(WorkStation.REMOTE_DESKTOP_OPT);
		
		StringBuilder params = new StringBuilder();
		params.append(" " + this.getName());	
			
		Command cmdCommand = new Command(createIActionableCommand(params, Bat.WORK_STATION_REMOTE_DESKTOP));
		cmdCommand.executeCommand();
	}
	
	public void wakeUp() {
		System.out.println("WorkStation.class --> wakeUp()");
		
		validateWsActionable(WorkStation.WAKEUP_OPT);
		
		StringBuilder params = new StringBuilder();
		params.append(" " + this.getMac_address());
		params.append(" " + this.getName());
		params.append(" " + this.getSubnet_mask());
		params.append(" " + this.getPort_wakeup());
		
		Command cmdCommand = new Command(createIActionableCommand(params, Bat.WORK_STATION_WAKEUP));
		cmdCommand.executeCommand();
	}
	
	public void reboot() {
		System.out.println("WorkStation.class --> reboot()");
		
		validateWsActionable(WorkStation.REBOOT_OPT);
		
		StringBuilder params = new StringBuilder();
		params.append(" " + this.getName());
		params.append(" " + this.getUser());
		params.append(" " + this.getPwd());
		
		Command cmdCommand = new Command(createIActionableCommand(params, Bat.WORK_STATION_REBOOT));
		cmdCommand.executeCommand();
	}
	
	public void shutDown() {
		System.out.println("WorkStation.class --> shutDown()");
		
		validateWsActionable(WorkStation.SHUTDOWN_OPT);
		
		StringBuilder params = new StringBuilder();
		params.append(" " + this.getName());
		params.append(" " + this.getUser());
		params.append(" " + this.getPwd());
		
		Command cmdCommand = new Command(createIActionableCommand(params, Bat.WORK_STATION_SHUTDOWN));
		cmdCommand.executeCommand();
	}

	// FIN IWorkStationActionable
	
	public String toString() {
		return this.label_text;
	}
}

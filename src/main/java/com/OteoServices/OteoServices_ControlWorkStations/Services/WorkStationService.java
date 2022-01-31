package com.OteoServices.OteoServices_ControlWorkStations.Services;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.OteoServices.OteoServices_ControlWorkStations.Interfaces.IFileServiceable;
import com.OteoServices.OteoServices_ControlWorkStations.Interfaces.IWSServiceable;
import com.OteoServices.OteoServices_ControlWorkStations.Models.WorkStation;

public class WorkStationService implements IWSServiceable{
	
	private static IFileServiceable FILE_SERVICE = new FileService();
	
	public ArrayList<WorkStation> BuildWorkStationsFromConfigFile() {
		System.out.println("WorkStationService.java --> BuildAllWorkStationsFromConfigFile()");
		
		try {
			int totalWorkStationsParam = Integer.parseInt(FILE_SERVICE.readConfigFileParameter("TOTAL_WS_COUNT"));
			
			if (totalWorkStationsParam <= 0) {
				JOptionPane.showMessageDialog(new JFrame(), "No work stations configured at ConfigWs.txt", "Total WorkStations 0",JOptionPane.ERROR_MESSAGE);
				System.exit(1);
			}
			
			return FillWorkStationList(totalWorkStationsParam);
		} catch (Exception ex) {
			ex.printStackTrace();		
			JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), ex.getClass().toString(),JOptionPane.ERROR_MESSAGE);
			
			if  (ex.getClass() == java.lang.NumberFormatException.class) {
				System.exit(1);
			}
		}
		
		return new ArrayList<WorkStation>();
	}
	
	private ArrayList<WorkStation> FillWorkStationList(int totalWorkStationsParam) {
		System.out.println("WorkStationService.java --> FillWorkStationList()");
		
		ArrayList<WorkStation> workStations = new ArrayList<WorkStation>();		
		for (int i = 0; i < totalWorkStationsParam; i++) {
			int ws_number = i+1;

			WorkStation ws = new WorkStation();
			ws.setLabel_text(FILE_SERVICE.readConfigFileParameter("LABEL_WS_" + ws_number));
			ws.setName(FILE_SERVICE.readConfigFileParameter("NAME_WS_" + ws_number));
			ws.setSubnet_mask(FILE_SERVICE.readConfigFileParameter("SUBNET_MASK_WS_" + ws_number));
			ws.setUser(FILE_SERVICE.readConfigFileParameter("USER_WS_" + ws_number));
			ws.setPwd(FILE_SERVICE.readConfigFileParameter("PWD_WS_" + ws_number));
			ws.setMac_address(FILE_SERVICE.readConfigFileParameter("MAC_WS_" + ws_number));
			ws.setPort_wakeup(FILE_SERVICE.readConfigFileParameter("PORT_WAKEUP_WS_" + ws_number));

			workStations.add(ws);
		}
		
		return workStations;
	}
}

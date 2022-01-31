package com.OteoServices.OteoServices_ControlWorkStations.Services;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.OteoServices.OteoServices_ControlWorkStations.Interfaces.IPanelServiceable;
import com.OteoServices.OteoServices_ControlWorkStations.Models.WorkStation;
import com.OteoServices.OteoServices_ControlWorkStations.Panels.WsOptionsJPanel;

public class PanelService implements IPanelServiceable{
	
	public ArrayList<JPanel> fillWorkStationPanels(ArrayList<WorkStation> WORK_STATIONS){
		System.out.println("PanelService --> fillWorkStationPanels()");
		
		ArrayList<JPanel> panels = new ArrayList<>();
		try {
			for (int i = 0; i < WORK_STATIONS.size(); i++) {			
				WsOptionsJPanel wsPanel = new WsOptionsJPanel(WORK_STATIONS.get(i));
				wsPanel.setBackground(new Color(255, 235, 205));
				wsPanel.setBounds(55, (40*4), 300, 200);
				wsPanel.setVisible(true);
				
				panels.add(wsPanel);
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), ex.getClass().toString(),JOptionPane.ERROR_MESSAGE);
		}
		
		return panels;	
	}
}

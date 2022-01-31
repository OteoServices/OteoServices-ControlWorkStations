package com.OteoServices.OteoServices_ControlWorkStations.Interfaces;

import java.util.ArrayList;

import javax.swing.JPanel;

import com.OteoServices.OteoServices_ControlWorkStations.Models.WorkStation;

public interface IPanelServiceable {
	public ArrayList<JPanel> fillWorkStationPanels(ArrayList<WorkStation> WORK_STATIONS);
}

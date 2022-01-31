package com.OteoServices.OteoServices_ControlWorkStations.Interfaces;

import java.util.ArrayList;
import com.OteoServices.OteoServices_ControlWorkStations.Models.WorkStation;

public interface IWorkStationServiceable {
	public ArrayList<WorkStation> BuildWorkStationsFromConfigFile();
}

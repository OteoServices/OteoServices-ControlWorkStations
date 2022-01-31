package com.OteoServices.OteoServices_ControlWorkStations.Models;

public class Bat {
	public static final String WS_BATS_PATH_TEST = "src\\mock\\bats\\workStation\\"; 
	public static final String WS_BATS_PATH_PROD = System.getProperty("user.dir") + "\\bats\\workStation\\";
	
	public static final String WORK_STATION_REMOTE_DESKTOP = "REMOTE_DESKTOP_WS.bat";
	public static final String WORK_STATION_WAKEUP = "WAKEUP_WS.bat";
	public static final String WORK_STATION_REBOOT = "REBOOT_WS.bat";
	public static final String WORK_STATION_SHUTDOWN = "SHUTDOWN_WS.bat";
}

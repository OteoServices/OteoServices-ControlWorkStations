package com.OteoServices.OteoServices_ControlWorkStations.Services;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.OteoServices.OteoServices_ControlWorkStations.Interfaces.IFileServiceable;

public class FileService implements IFileServiceable{
	
	/**
	 * @param parameter
	 * @return
	 */
	public String readConfigFileParameter(String parameter) {
		System.out.println("FileService.java --> readConfigFileParameter()");

		try {
			String path_prod = System.getProperty("user.dir") + "\\ConfigWs.txt";
			String path_test = "..\\OteoServices-ControlWorkStations\\src\\mock\\ConfigWs.txt"; // Used for test
			
			FileReader fr = new FileReader(path_prod);
			BufferedReader br = new BufferedReader(fr);
	 
			String line = "";
			while((line = br.readLine()) != null) {
				int equal_position = -1;
				
				if (!line.startsWith("#") && line.startsWith(parameter)) {
					if (!line.contains("=")) {
						closeFileAndBufferReaders(fr, br);
						JOptionPane.showMessageDialog(new JFrame(), "Parameter " + parameter + " incorrect format", "Param format isn't correct", JOptionPane.ERROR_MESSAGE);
						return "";
					}
					
					equal_position = line.indexOf("=");
	    		  
					if (equal_position == -1) {
						closeFileAndBufferReaders(fr, br);
						JOptionPane.showMessageDialog(new JFrame(), "Parameter " + parameter + " incorrect format", "Param format isn't correct", JOptionPane.ERROR_MESSAGE);
						return "";
					}
	    		  
					closeFileAndBufferReaders(fr, br);
					return line.substring((equal_position+1)).replace("'", "");
				}	
			}
			
			closeFileAndBufferReaders(fr, br);
			JOptionPane.showMessageDialog(new JFrame(), "Parameter " + parameter + " not found", "Param Not Found", JOptionPane.ERROR_MESSAGE);
			return "";
		} catch(Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), ex.getClass().toString(),JOptionPane.ERROR_MESSAGE);
	    }
		
		return "";
	}
	
	private void closeFileAndBufferReaders(FileReader fr, BufferedReader br) {	
		System.out.println("FileService.java --> closeFileAndBufferReaders()");
		
		try {
			br.close();
			fr.close();
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), ex.getClass().toString(),JOptionPane.ERROR_MESSAGE);
		}
	}
}

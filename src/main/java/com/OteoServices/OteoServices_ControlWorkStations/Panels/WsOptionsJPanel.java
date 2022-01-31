package com.OteoServices.OteoServices_ControlWorkStations.Panels;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.OteoServices.OteoServices_ControlWorkStations.Models.WorkStation;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class WsOptionsJPanel extends JPanel {
	
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public WsOptionsJPanel(final WorkStation WORKSTATION) throws Exception {
		setBackground(new Color(204, 153, 102));
		setLayout(null);
		
		if (WORKSTATION == null) {
			throw new Exception();
		}
		
		JLabel lblWS_LabelText = new JLabel(WORKSTATION.getLabel_text());
		lblWS_LabelText.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWS_LabelText.setHorizontalAlignment(SwingConstants.LEFT);
		lblWS_LabelText.setBounds(10, 11, 180, 28);
		add(lblWS_LabelText);
		
		JButton btnWS_RemoteDesktop = new JButton("Remote Desktop");
		btnWS_RemoteDesktop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("btnWS_RemoteDesktop --> actionPerformed()");
				
				WORKSTATION.remoteConnection();
			}
		});
		btnWS_RemoteDesktop.setBounds(35, 50, 180, 23);
		add(btnWS_RemoteDesktop);
		
		JButton btnWS_WakeUp = new JButton("Wake Up");
		btnWS_WakeUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("btnWS_WakeUp --> actionPerformed()");
				
				WORKSTATION.wakeUp();
			}
		});
		btnWS_WakeUp.setBounds(35, 90, 180, 23);
		add(btnWS_WakeUp);
		
		JButton btnWS_Reboot = new JButton("Reboot");
		btnWS_Reboot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("btnWS_Reboot --> actionPerformed()");
				
				WORKSTATION.reboot();
			}
		});
		btnWS_Reboot.setBounds(35, 130, 180, 23);
		add(btnWS_Reboot);
		
		JButton btnWS_Shutdown = new JButton("Shutdown");
		btnWS_Shutdown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("btnWS_Shutdown --> actionPerformed()");
				
				WORKSTATION.shutDown();
			}
		});
		btnWS_Shutdown.setBounds(35, 170, 180, 23);
		add(btnWS_Shutdown);
	}
}

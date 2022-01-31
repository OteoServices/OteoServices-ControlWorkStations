package com.OteoServices.OteoServices_ControlWorkStations.App;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.util.ArrayList;

import com.OteoServices.OteoServices_ControlWorkStations.Interfaces.IPanelServiceable;
import com.OteoServices.OteoServices_ControlWorkStations.Interfaces.IWorkStationServiceable;
import com.OteoServices.OteoServices_ControlWorkStations.Models.WorkStation;
import com.OteoServices.OteoServices_ControlWorkStations.Panels.WsOptionsJPanel;
import com.OteoServices.OteoServices_ControlWorkStations.Services.PanelService;
import com.OteoServices.OteoServices_ControlWorkStations.Services.WorkStationService;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class App extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;	
	private JPanel panel;	
	private JComboBox<WorkStation> comboBoxWS;
	
	private static final IWorkStationServiceable WS_SERVICE = new WorkStationService();
	private static final IPanelServiceable PANEL_SERVICE = new PanelService();
	
	private static boolean INIT = true;
	
	private static final ArrayList<WorkStation> WORK_STATIONS = WS_SERVICE.BuildWorkStationsFromConfigFile();
	private static final ArrayList<JPanel> WS_PANELS = PANEL_SERVICE.fillWorkStationPanels(WORK_STATIONS);
	private static JPanel CURRENT_PANEL;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					//Test route
				    //frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src/mock/img/TopLeft-Icon-App(15).png")); 
					//Production route
				    frame.setIconImage(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir") + "\\img\\" + "TopLeft-Icon-App(15).png")); 
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public App() {
		
		this.setTitle("Inicio");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 235, 205));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblTittle = new JLabel("WorkStations Control");
		lblTittle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTittle.setForeground(new Color(105, 105, 105));
		lblTittle.setFont(new Font("Segoe UI Black", Font.BOLD, 30));
		lblTittle.setBounds(10, 11, 414, 39);
		panel.add(lblTittle);
		
		comboBoxWS = new JComboBox<WorkStation>();
		comboBoxWS.setBounds(62, 61, 300, 22);
		for (int i = 0; i < WORK_STATIONS.size(); i++) {
			comboBoxWS.addItem(WORK_STATIONS.get(i));
		}	
		panel.add(comboBoxWS);
		comboBoxWS.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
		    	try {
		    		WorkStation ws = (WorkStation) comboBoxWS.getSelectedItem();
		    		
		    		panel.setVisible(false);
		    		panel.remove(CURRENT_PANEL);	
		    		
		    		CURRENT_PANEL = WS_PANELS.get(ws.getPrivate_identify_number()-1);	
		    		
					panel.add(CURRENT_PANEL);
					panel.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}   	
			}
		});
		
		if (INIT) {
			CURRENT_PANEL =  WS_PANELS.get(0);
			panel.add(CURRENT_PANEL);	
			
			INIT = false;
		}
	}
	
	
}

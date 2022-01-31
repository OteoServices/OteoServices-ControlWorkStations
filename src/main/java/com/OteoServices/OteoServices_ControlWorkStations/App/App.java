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
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import java.util.ArrayList;
import com.OteoServices.OteoServices_ControlWorkStations.Interfaces.IWSServiceable;
import com.OteoServices.OteoServices_ControlWorkStations.Models.WorkStation;
import com.OteoServices.OteoServices_ControlWorkStations.Services.WorkStationService;

public class App extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private JButton btnServer1RemoteConn;
	private JButton btnServer1WakeUp;
	private JButton btnServer1Reboot;
	private JButton btnServer1Shutdown;
	
	private JButton btnServer2RemoteConn;
	private JButton btnServer2WakeUp;
	private JButton btnServer2Reboot;
	private JButton btnServer2Shutdown;
	
	private static final IWSServiceable WS_SERVICE = new WorkStationService();
	private static final ArrayList<WorkStation> WORK_STATIONS = WS_SERVICE.BuildWorkStationsFromConfigFile();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
				    //frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src/mock/img/TopLeft-Icon-App(15).png")); 
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
		setBounds(200, 200, 389, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 235, 205));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblTittle = new JLabel("WorkStations Control");
		lblTittle.setForeground(new Color(105, 105, 105));
		lblTittle.setFont(new Font("Segoe UI Black", Font.BOLD, 30));
		lblTittle.setBounds(10, 11, 656, 39);
		panel.add(lblTittle);
		
		JRadioButton rdbtnServer1 = new JRadioButton(WORK_STATIONS.get(0).getLabel_text());
		rdbtnServer1.setBackground(new Color(240, 255, 240));
		rdbtnServer1.setBounds(10, 68, 130, 23);
		panel.add(rdbtnServer1);
		rdbtnServer1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("rdbtnServer1 --> actionPerformed()");
				
				btnServer1RemoteConn.setEnabled(true);
				btnServer1WakeUp.setEnabled(true);
				btnServer1Reboot.setEnabled(true);
				btnServer1Shutdown.setEnabled(true);
				
				btnServer2RemoteConn.setEnabled(false);
				btnServer2WakeUp.setEnabled(false);
				btnServer2Reboot.setEnabled(false);
				btnServer2Shutdown.setEnabled(false);
			}
		});
		
		JRadioButton rdbtnServer2 = new JRadioButton(WORK_STATIONS.get(1).getLabel_text());
		rdbtnServer2.setBackground(new Color(240, 255, 240));
		rdbtnServer2.setBounds(150, 68, 130, 23);
		panel.add(rdbtnServer2);
		rdbtnServer2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("rdbtnServer2 --> actionPerformed()");
				
				btnServer1RemoteConn.setEnabled(false);
				btnServer1WakeUp.setEnabled(false);
				btnServer1Reboot.setEnabled(false);
				btnServer1Shutdown.setEnabled(false);
				
				btnServer2RemoteConn.setEnabled(true);
				btnServer2WakeUp.setEnabled(true);
				btnServer2Reboot.setEnabled(true);
				btnServer2Shutdown.setEnabled(true);
			}
		});
		
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(rdbtnServer1);
		radioGroup.add(rdbtnServer2);
		
		//***** INI SERVER 1 PANEL *****
		
		JPanel panel_Action_Server1 = new JPanel();
		panel_Action_Server1.setBackground(new Color(255, 228, 225));
		panel_Action_Server1.setBounds(10, 105, 130, 234);
		panel.add(panel_Action_Server1);
		panel_Action_Server1.setLayout(null);
		
		btnServer1RemoteConn = new JButton("Remote Desktop");
		btnServer1RemoteConn.setEnabled(false);
		btnServer1RemoteConn.setBounds(10, 25, 111, 34);
		panel_Action_Server1.add(btnServer1RemoteConn);
		btnServer1RemoteConn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				try {
					System.out.println("btnServer1RemoteConn --> actionPerformed()");	
					
					WORK_STATIONS.get(0).remoteConnection();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnServer1WakeUp = new JButton("Wake Up");
		btnServer1WakeUp.setEnabled(false);
		btnServer1WakeUp.setBounds(10, 76, 111, 34);
		panel_Action_Server1.add(btnServer1WakeUp);
		btnServer1WakeUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println("btnServer1WakeUp --> actionPerformed()");
					
					WORK_STATIONS.get(0).wakeUp();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnServer1Reboot = new JButton("Reboot");
		btnServer1Reboot.setEnabled(false);
		btnServer1Reboot.setBounds(10, 130, 111, 34);
		panel_Action_Server1.add(btnServer1Reboot);
		btnServer1Reboot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println("btnServer1Reboot --> actionPerformed()");
					
					WORK_STATIONS.get(0).reboot();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnServer1Shutdown = new JButton("Shutdown");
		btnServer1Shutdown.setEnabled(false);
		btnServer1Shutdown.setBounds(10, 181, 111, 34);
		panel_Action_Server1.add(btnServer1Shutdown);
		btnServer1Shutdown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println("btnServer1Shutdown --> actionPerformed()");
					
					WORK_STATIONS.get(0).shutDown();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//***** FIN SERVER 1 PANEL *****
		
		//***** INI SERVER 2 PANEL *****
		
		JPanel panel_Action_Server2 = new JPanel();
		panel_Action_Server2.setBackground(new Color(255, 228, 225));
		panel_Action_Server2.setLayout(null);
		panel_Action_Server2.setBounds(150, 105, 130, 234);
		panel.add(panel_Action_Server2);
		
		btnServer2RemoteConn = new JButton("Remote Connection");
		btnServer2RemoteConn.setEnabled(false);
		btnServer2RemoteConn.setBounds(10, 25, 111, 34);
		panel_Action_Server2.add(btnServer2RemoteConn);
		btnServer2RemoteConn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				try {
					System.out.println("btnServer2RemoteConn --> actionPerformed()");	
					
					WORK_STATIONS.get(1).remoteConnection();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	
		
		btnServer2WakeUp = new JButton("Wake Up");
		btnServer2WakeUp.setEnabled(false);
		btnServer2WakeUp.setBounds(10, 76, 111, 34);
		panel_Action_Server2.add(btnServer2WakeUp);
		btnServer2WakeUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println("btnServer2WakeUp --> actionPerformed()");	
					
					WORK_STATIONS.get(1).wakeUp();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	
		
		btnServer2Reboot = new JButton("Reboot");
		btnServer2Reboot.setEnabled(false);
		btnServer2Reboot.setBounds(10, 130, 111, 34);
		panel_Action_Server2.add(btnServer2Reboot);
		btnServer2Reboot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				try {
					System.out.println("btnServer2Reboot --> actionPerformed()");	
					
					WORK_STATIONS.get(1).reboot();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	
		
		btnServer2Shutdown = new JButton("Shutdown");		
		btnServer2Shutdown.setEnabled(false);
		btnServer2Shutdown.setBounds(10, 181, 111, 34);
		panel_Action_Server2.add(btnServer2Shutdown);
		btnServer2Shutdown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println("btnServer2Shutdown --> actionPerformed()");		
					
					WORK_STATIONS.get(1).shutDown();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//***** FIN SERVER 2 PANEL *****
		
	}
}

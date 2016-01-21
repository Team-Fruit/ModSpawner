package com.kamesuta.mc.modspawner.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DLGui {
	/**
	 * 表示する名前
	 */
	public static final String displayName = "Mod Spawner";

	private JFrame frame;
	private DLCalculate cal = new DLCalculate();
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DLGui window = new DLGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DLGui() {
		initialize();
	}

	/**
	 * Show the application.
	 */
	public void makeGUI()
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				frame.setVisible(true);
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				requestClose("ウィンドウを閉じるとMinecraftを起動することができません。\nそれでもよろしいですか？");
			}
		});
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(DLGui.class.getResource("modspawner_icon.png")));
		frame.setSize(680, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setTitle(displayName);
		frame.setResizable(true);

		JPanel panel = new DLBackground();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setForeground(new Color(32, 43, 54));
		panel.setBackground(new Color(86, 84, 102));

				DLDetailsGraph panelDetails = new DLDetailsGraph();
				panelDetails.setForeground(Color.LIGHT_GRAY);
				panelDetails.setOpaque(false);
				cal.details.setDetailsGraph(panelDetails);

				JPanel panelLog = new JPanel();
				panelLog.setOpaque(false);

				JPanel panelList = new JPanel();
				panelList.setOpaque(false);

				JPanel panelTitle = new JPanel();
				panelTitle.setOpaque(false);

				JLabel labelIcon = new JLabel();
				labelIcon.setIcon(new ImageIcon(DLGui.class.getResource("modspawner_icon.png")));

				JLabel labelLogo = new JLabel();
				labelLogo.setIcon(new ImageIcon(DLGui.class.getResource("logo.png")));

				JLabel lblVer = new JLabel("ver 1.0");
				lblVer.setForeground(Color.WHITE);
				GroupLayout gl_panelTitle = new GroupLayout(panelTitle);
				gl_panelTitle.setHorizontalGroup(
					gl_panelTitle.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTitle.createSequentialGroup()
							.addComponent(labelIcon)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(labelLogo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblVer)
							.addContainerGap(141, Short.MAX_VALUE))
				);
				gl_panelTitle.setVerticalGroup(
					gl_panelTitle.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTitle.createSequentialGroup()
							.addGroup(gl_panelTitle.createParallelGroup(Alignment.LEADING)
								.addComponent(labelIcon)
								.addGroup(gl_panelTitle.createSequentialGroup()
									.addContainerGap()
									.addGroup(gl_panelTitle.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblVer)
										.addComponent(labelLogo))))
							.addContainerGap(2, Short.MAX_VALUE))
				);
				panelTitle.setLayout(gl_panelTitle);

				JPanel panelText = new JPanel();
				panelText.setOpaque(false);
				GroupLayout gl_panel = new GroupLayout(panel);
				gl_panel.setHorizontalGroup(
					gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(panelDetails, GroupLayout.PREFERRED_SIZE, 664, GroupLayout.PREFERRED_SIZE)
							.addGap(0))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(panelList, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 225, Short.MAX_VALUE)
									.addComponent(panelLog, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(panelTitle, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panelText, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)))
							.addContainerGap())
				);
				gl_panel.setVerticalGroup(
					gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(panelTitle, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
								.addComponent(panelText, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(panelLog, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
								.addComponent(panelList, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelDetails, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
				);
				panelText.setLayout(new BorderLayout(0, 0));

				table_1 = new JTable();
				table_1.setOpaque(false);
				panelText.add(table_1, BorderLayout.CENTER);
				panelList.setLayout(new BorderLayout(0, 0));

				table = new JTable();
				table.setOpaque(false);
				panelList.add(table, BorderLayout.CENTER);
				panelLog.setLayout(new BorderLayout(0, 0));

				JTextArea textArea = new JTextArea();
				textArea.setOpaque(false);
				panelLog.add(textArea, BorderLayout.CENTER);
				panel.setLayout(gl_panel);

		JPanel panelProgress = new JPanel();
		frame.getContentPane().add(panelProgress, BorderLayout.SOUTH);
				panelProgress.setLayout(new GridLayout(0, 1, 0, 0));

				JProgressBar progressBarOne = new JProgressBar();
				panelProgress.add(progressBarOne);
				progressBarOne.setIndeterminate(true);
				progressBarOne.setForeground(Color.RED);
				progressBarOne.setStringPainted(true);
				progressBarOne.setBackground(Color.LIGHT_GRAY);
				progressBarOne.setBorderPainted(false);
				progressBarOne.setString("Loading...");
				cal.progressOne.setProgressBar(progressBarOne);

				JProgressBar progressBarAll = new JProgressBar();
				progressBarAll.setIndeterminate(true);
				progressBarAll.setForeground(Color.RED);
				progressBarAll.setStringPainted(true);
				progressBarAll.setBackground(Color.LIGHT_GRAY);
				progressBarAll.setBorderPainted(false);
				progressBarAll.setString("Loading...");
				cal.progressAll.setProgressBar(progressBarAll);
				panelProgress.add(progressBarAll);
	}

	protected void requestClose(String message) {
		int shouldClose = JOptionPane.showConfirmDialog(frame, message, "本当に終了しますか？", JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE);
		if (shouldClose == JOptionPane.YES_OPTION)
			frame.dispose();
		cal.requestClose();
	}

	public DLCalculate getCalculate()
	{
		return cal;
	}
}

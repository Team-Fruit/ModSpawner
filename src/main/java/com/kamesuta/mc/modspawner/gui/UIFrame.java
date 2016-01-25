package com.kamesuta.mc.modspawner.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.kamesuta.mc.modspawner.gui.dl.DLCalculate;
import com.kamesuta.mc.modspawner.gui.dl.DLGui;

public class UIFrame {
	/**
	 * 表示する名前
	 */
	public static final String displayName = "Mod Spawner";

	private JFrame status;
	private DLCalculate cal = new DLCalculate();

	/**
	 * Create the application.
	 */
	public UIFrame() {
		initialize();
	}

	/**
	 * Show the application.
	 */
	public void makeGUI()
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				status.setVisible(true);
			}
		});
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		status = new JFrame();
		status.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				requestClose("ウィンドウを閉じるとMinecraftを起動することができません。\nそれでもよろしいですか？");
			}
		});
		status.setIconImage(Toolkit.getDefaultToolkit().getImage(DLGui.class.getResource("modspawner_icon.png")));
		status.setSize(680, 400);
		status.setLocationRelativeTo(null);
		status.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		status.getContentPane().setLayout(new BorderLayout(0, 0));
		status.setTitle(displayName);
		status.setResizable(true);

		DLGui gui = new DLGui();
		status.getContentPane().add(gui, BorderLayout.CENTER);
	}
	
	protected void requestClose(String message) {
		int shouldClose = JOptionPane.showConfirmDialog(status, message, "本当に終了しますか？", JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE);
		if (shouldClose == JOptionPane.YES_OPTION)
			status.dispose();
		cal.requestClose();
	}

	public DLCalculate getCalculate()
	{
		return cal;
	}
}

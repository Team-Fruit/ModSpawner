package com.kamesuta.mc.modspawner.gui.dl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DLGui extends JPanel {
	private DLDetailsGraph panelDetailsGraph;
	private DLDetailsText panelDetailsText;
	private JProgressBar progressBarOne;
	private JProgressBar progressBarAll;

	/**
	 * Initialize the contents of the frame.
	 */
	public DLGui() {

			DLBackground panelMain = new DLBackground();
			panelMain.setForeground(new Color(32, 43, 54));
			panelMain.setBackground(new Color(86, 84, 102));

					panelDetailsGraph = new DLDetailsGraph();
					panelDetailsGraph.setForeground(Color.LIGHT_GRAY);
					panelDetailsGraph.setOpaque(false);

					JPanel panelLog = new JPanel();
					panelLog.setOpaque(false);

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

					panelDetailsText = new DLDetailsText();
					panelDetailsText.setOpaque(false);
					GroupLayout gl_panelMain = new GroupLayout(panelMain);
					gl_panelMain.setHorizontalGroup(
						gl_panelMain.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelMain.createSequentialGroup()
								.addComponent(panelDetailsGraph, GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
								.addGap(0))
							.addGroup(gl_panelMain.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_panelMain.createParallelGroup(Alignment.LEADING)
									.addComponent(panelLog, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_panelMain.createSequentialGroup()
										.addComponent(panelTitle, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(panelDetailsText, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)))
								.addContainerGap())
					);
					gl_panelMain.setVerticalGroup(
						gl_panelMain.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panelMain.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_panelMain.createParallelGroup(Alignment.LEADING, false)
									.addComponent(panelTitle, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
									.addComponent(panelDetailsText, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panelLog, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panelDetailsGraph, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
					);
					panelLog.setLayout(new BorderLayout(0, 0));

					JTextArea textArea = new JTextArea();
					textArea.setOpaque(false);
					panelLog.add(textArea, BorderLayout.CENTER);
					panelMain.setLayout(gl_panelMain);

			JPanel panelProgress = new JPanel();
					panelProgress.setLayout(new GridLayout(0, 1, 0, 0));

					progressBarOne = new JProgressBar();
					panelProgress.add(progressBarOne);
					progressBarOne.setIndeterminate(true);
					progressBarOne.setForeground(Color.RED);
					progressBarOne.setStringPainted(true);
					progressBarOne.setBackground(Color.LIGHT_GRAY);
					progressBarOne.setBorderPainted(false);
					progressBarOne.setString("Loading...");

					progressBarAll = new JProgressBar();
					progressBarAll.setIndeterminate(true);
					progressBarAll.setForeground(Color.RED);
					progressBarAll.setStringPainted(true);
					progressBarAll.setBackground(Color.LIGHT_GRAY);
					progressBarAll.setBorderPainted(false);
					progressBarAll.setString("Loading...");
					panelProgress.add(progressBarAll);
		setLayout(new BorderLayout(0, 0));
		add(panelMain, BorderLayout.CENTER);
		add(panelProgress, BorderLayout.SOUTH);
	}
}

package com.kamesuta.mc.modspawner.gui.dl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 * Show some details.
 * @author Kamesuta
 */
public class DLDetailsText extends JPanel {
	public final JTextArea FieldServer;
	public final JTextArea FieldSpeed;
	public final JTextArea FieldTimeRemaining;
	public final JTextArea FieldTimeRemainingAll;
	public final JTextArea FieldStatus;

	public DLDetailsText() {
		setBackground(Color.BLACK);

		Border paddingBorder = BorderFactory.createEmptyBorder(0,5,0,5);

		JPanel LabelStatus = new JPanel();
		LabelStatus.setOpaque(false);

		JPanel panel = new JPanel();
		panel.setOpaque(false);

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
				.addComponent(LabelStatus, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(LabelStatus, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
		);
				panel_1.setLayout(new GridLayout(0, 2, 0, 0));

				JPanel LabelTimeRemaining = new JPanel();
				panel_1.add(LabelTimeRemaining);
				LabelTimeRemaining.setOpaque(false);
				LabelTimeRemaining.setLayout(new BorderLayout(0, 0));

						JLabel lblTimeRemaining = new JLabel("TimeLeft:");
						lblTimeRemaining.setForeground(Color.WHITE);
						lblTimeRemaining.setBorder(paddingBorder);
						LabelTimeRemaining.add(lblTimeRemaining, BorderLayout.WEST);

								FieldTimeRemaining = new JTextArea();
								FieldTimeRemaining.setForeground(Color.WHITE);
								FieldTimeRemaining.setOpaque(false);
								FieldTimeRemaining.setEditable(false);
								LabelTimeRemaining.add(FieldTimeRemaining, BorderLayout.CENTER);
								FieldTimeRemaining.setColumns(10);

										JPanel LabelTimeRemainingAll = new JPanel();
										panel_1.add(LabelTimeRemainingAll);
										LabelTimeRemainingAll.setOpaque(false);
										LabelTimeRemainingAll.setLayout(new BorderLayout(0, 0));

												JLabel lblTimeRemainingAll = new JLabel("TimeLeftAll:");
												lblTimeRemainingAll.setForeground(Color.WHITE);
												lblTimeRemainingAll.setBorder(paddingBorder);
												LabelTimeRemainingAll.add(lblTimeRemainingAll, BorderLayout.WEST);

														FieldTimeRemainingAll = new JTextArea();
														FieldTimeRemainingAll.setForeground(Color.WHITE);
														FieldTimeRemainingAll.setOpaque(false);
														FieldTimeRemainingAll.setEditable(false);
														LabelTimeRemainingAll.add(FieldTimeRemainingAll, BorderLayout.CENTER);
														FieldTimeRemainingAll.setColumns(10);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		JPanel LabelServer = new JPanel();
		panel.add(LabelServer);
		LabelServer.setOpaque(false);
		LabelServer.setLayout(new BorderLayout(0, 0));

				JLabel lblServer = new JLabel("Server:");
				lblServer.setForeground(Color.WHITE);
				lblServer.setBorder(paddingBorder);
				LabelServer.add(lblServer, BorderLayout.WEST);

						FieldServer = new JTextArea();
						FieldServer.setForeground(Color.WHITE);
						FieldServer.setOpaque(false);
						FieldServer.setEditable(false);
						LabelServer.add(FieldServer, BorderLayout.CENTER);
						FieldServer.setColumns(10);

								JPanel LabelSpeed = new JPanel();
								panel.add(LabelSpeed);
								LabelSpeed.setOpaque(false);
								LabelSpeed.setLayout(new BorderLayout(0, 0));

										JLabel lblSpeed = new JLabel("Speed:");
										lblSpeed.setForeground(Color.WHITE);
										lblSpeed.setBorder(paddingBorder);
										LabelSpeed.add(lblSpeed, BorderLayout.WEST);

												FieldSpeed = new JTextArea();
												FieldSpeed.setForeground(Color.WHITE);
												FieldSpeed.setOpaque(false);
												FieldSpeed.setEditable(false);
												LabelSpeed.add(FieldSpeed, BorderLayout.CENTER);
												FieldSpeed.setColumns(10);
		LabelStatus.setLayout(new BorderLayout(0, 0));

		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setForeground(Color.WHITE);
		lblStatus.setBorder(paddingBorder);
		LabelStatus.add(lblStatus, BorderLayout.WEST);

		FieldStatus = new JTextArea();
		FieldStatus.setForeground(Color.WHITE);
		FieldStatus.setOpaque(false);
		FieldStatus.setEditable(false);
		LabelStatus.add(FieldStatus, BorderLayout.CENTER);
		FieldStatus.setColumns(10);
		setLayout(groupLayout);
	}
}

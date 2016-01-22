package com.kamesuta.mc.modspawner.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * Show some details.
 * @author Kamesuta
 */
public class DLDetailsText extends JPanel {
	public final JTextField FieldServer;
	public final JTextField FieldSpeed;
	public final JTextField FieldTimeRemaining;
	public final JTextField FieldTimeRemainingAll;
	public final JTextField FieldStatus;

	public DLDetailsText() {
		setOpaque(false);

		JPanel LabelServer = new JPanel();
		LabelServer.setBackground(Color.BLACK);

		JPanel LabelSpeed = new JPanel();
		LabelSpeed.setBackground(Color.BLACK);

		JPanel LabelTimeRemaining = new JPanel();
		LabelTimeRemaining.setBackground(Color.BLACK);

		JPanel LabelTimeRemainingAll = new JPanel();
		LabelTimeRemainingAll.setBackground(Color.BLACK);

		JPanel LabelStatus = new JPanel();
		LabelStatus.setBackground(Color.BLACK);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(LabelStatus, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
						.addComponent(LabelTimeRemainingAll, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
						.addComponent(LabelTimeRemaining, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
						.addComponent(LabelSpeed, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
						.addComponent(LabelServer, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(LabelServer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(LabelSpeed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(LabelTimeRemaining, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(LabelTimeRemainingAll, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(LabelStatus, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
					.addContainerGap())
		);
		LabelStatus.setLayout(new BorderLayout(0, 0));

		JLabel lblStatus = new JLabel("Status");
		lblStatus.setForeground(Color.WHITE);
		LabelStatus.add(lblStatus, BorderLayout.WEST);

		FieldStatus = new JTextField();
		FieldStatus.setBackground(Color.WHITE);
		FieldStatus.setEditable(false);
		LabelStatus.add(FieldStatus, BorderLayout.CENTER);
		FieldStatus.setColumns(10);
		LabelTimeRemainingAll.setLayout(new BorderLayout(0, 0));

		JLabel lblTimeRemainingAll = new JLabel("Time Remaining All");
		lblTimeRemainingAll.setForeground(Color.WHITE);
		LabelTimeRemainingAll.add(lblTimeRemainingAll, BorderLayout.WEST);

		FieldTimeRemainingAll = new JTextField();
		FieldTimeRemainingAll.setBackground(Color.WHITE);
		FieldTimeRemainingAll.setEditable(false);
		LabelTimeRemainingAll.add(FieldTimeRemainingAll, BorderLayout.CENTER);
		FieldTimeRemainingAll.setColumns(10);
		LabelTimeRemaining.setLayout(new BorderLayout(0, 0));

		JLabel lblTimeRemaining = new JLabel("Time Remaining");
		lblTimeRemaining.setForeground(Color.WHITE);
		LabelTimeRemaining.add(lblTimeRemaining, BorderLayout.WEST);

		FieldTimeRemaining = new JTextField();
		FieldTimeRemaining.setBackground(Color.WHITE);
		FieldTimeRemaining.setEditable(false);
		LabelTimeRemaining.add(FieldTimeRemaining, BorderLayout.CENTER);
		FieldTimeRemaining.setColumns(10);
		LabelSpeed.setLayout(new BorderLayout(0, 0));

		JLabel lblSpeed = new JLabel("Speed");
		lblSpeed.setForeground(Color.WHITE);
		LabelSpeed.add(lblSpeed, BorderLayout.WEST);

		FieldSpeed = new JTextField();
		FieldSpeed.setBackground(Color.WHITE);
		FieldSpeed.setEditable(false);
		LabelSpeed.add(FieldSpeed, BorderLayout.CENTER);
		FieldSpeed.setColumns(10);
		LabelServer.setLayout(new BorderLayout(0, 0));

		JLabel lblServer = new JLabel("Server");
		lblServer.setForeground(Color.WHITE);
		LabelServer.add(lblServer, BorderLayout.WEST);

		FieldServer = new JTextField();
		FieldServer.setBackground(Color.WHITE);
		FieldServer.setEditable(false);
		LabelServer.add(FieldServer, BorderLayout.CENTER);
		FieldServer.setColumns(10);
		setLayout(groupLayout);
	}
}

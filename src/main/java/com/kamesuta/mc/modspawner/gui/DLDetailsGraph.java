package com.kamesuta.mc.modspawner.gui;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

public class DLDetailsGraph extends JPanel {
	public static final int objwidth = 5;
	public static final int objspace = 2;

	private List<Integer> objects = new ArrayList<Integer>();

	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);

		Graphics2D g = (Graphics2D) graphics;

		int width = this.getWidth();
		int height = this.getHeight();

		Color f = this.getForeground();
		g.setColor(f);

		if (!objects.isEmpty()) {
			int max = DLSize.SPEED.getMeasure(Collections.max(objects));

			FontMetrics fm = g.getFontMetrics();
			g.drawString(DLSize.SPEED.getFormatSizeString(max, 0), 0, fm.getAscent());
			g.drawString("0", 0, height - (fm.getHeight() - fm.getAscent()));

			for (int i = 0; i < objects.size(); i++) {
				if ((objwidth + objspace) * i < width) {
					int objlength = objects.get(i) * height / max;
					g.fillRect(width - ((objwidth + objspace) * (objects.size() - i)), height - objlength, objwidth,
							objlength);
				} else {
					objects.remove(0);
					break;
				}
			}
		}
	}

	public void addObj(double speed) {
		objects.add((int)speed);
		repaint();
	}
}
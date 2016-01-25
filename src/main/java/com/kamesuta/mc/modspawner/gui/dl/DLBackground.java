package com.kamesuta.mc.modspawner.gui.dl;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class DLBackground extends JPanel {
	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);

		Graphics2D g = (Graphics2D) graphics;

		int width = this.getWidth();
		int height = this.getHeight();
		int heightFade = height / 6;

		Color a = this.getBackground();
		Color b = this.getForeground();

		g.setPaint(new GradientPaint(0, 0, b, 0, heightFade, a));
		g.fillRect(0, 0, width, heightFade);

		g.setPaint(new GradientPaint(0, height - heightFade, a, 0, height, b));
		g.fillRect(0, height - heightFade, width, heightFade);
	}
}
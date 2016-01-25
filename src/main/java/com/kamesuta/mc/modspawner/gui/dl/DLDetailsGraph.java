package com.kamesuta.mc.modspawner.gui.dl;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Collections;

import javax.swing.JPanel;

import com.kamesuta.mc.modspawner.util.PushList;
import com.kamesuta.mc.modspawner.util.SizeUnit;
import com.kamesuta.mc.modspawner.util.Speed;

public class DLDetailsGraph extends JPanel {
	public static final int objwidth = 5;
	public static final int objspace = 2;
	public static final int objcenter = (int) Math.ceil(objwidth * 0.5);
	public static final int objunit = objwidth + objspace;

	public static final Color textColor = Color.WHITE;
	public static final Color speedColor = Color.GRAY;
	public static final Color speedaveColor = Color.LIGHT_GRAY;
	
	private PushList<Integer> speed = new PushList<Integer>();
	private PushList<Integer> speedave = new PushList<Integer>();

	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);

		Graphics2D g = (Graphics2D) graphics;

		int width = this.getWidth();
		int height = this.getHeight();
		int size = (width / (objwidth + objspace)) + 1;
		speed.setMax(size);
		speedave.setMax(size);


		if (!speed.isEmpty() && !speedave.isEmpty()) {
			int max = SizeUnit.SPEED.getMeasure(Math.max(Collections.max(speed), Collections.max(speedave)));

			// 棒グラフ
			g.setColor(speedColor);
			for (int i = 0; i < speed.size(); i++) {
				int objlength = speed.get(i) * height / max;
				g.fillRect(width - (objunit * (speed.size() - i)), height - objlength, objwidth, objlength);
			}
			
			// 折れ線グラフ
			g.setColor(speedaveColor);
			for (int ib = 1; ib < speedave.size(); ib++) {
				int ia = ib-1;
				
				int la = speedave.get(ia) * height / max;
				int lb = speedave.get(ib) * height / max;
				
				int a = width - (objunit * (speed.size() - ia)) + objcenter;
				int b = width - (objunit * (speed.size() - ib)) + objcenter;
				g.drawLine(a, height - la, b, height - lb);
			}

			// テキスト
			g.setColor(textColor);
			FontMetrics fm = g.getFontMetrics();
			g.drawString(SizeUnit.SPEED.getFormatSizeString(max, 0), 0, fm.getAscent());
			g.drawString("0", 0, height - (fm.getHeight() - fm.getAscent()));
		}
	}

	public DLDetailsGraph addSpeed(Speed sp) {
		speed.add((int)sp.getSpeed());
		speedave.add((int)sp.getAverageSpeed());
		return this;
	}
}
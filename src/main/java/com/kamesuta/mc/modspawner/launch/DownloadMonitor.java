package com.kamesuta.mc.modspawner.launch;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

public class DownloadMonitor {
	public static final String displayName = "Mod Spawner";

	public static class DonwloadDisplay extends JFrame {
		boolean stopIt = false;

		public DonwloadDisplay() {
			setTitle(displayName);
			setResizable(true);
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			setIconImage(new ImageIcon(getClass().getResource("modspawner_icon.png")).getImage());
			setSize(680, 400);
			setLocationRelativeTo(null);
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					requestClose("このウィンドウを閉じて、Minecraftの起動を中断しますか？");
				}
			});
		}

		public void makeDisplay() {
			this.setVisible(true);
		}

		protected void requestClose(String message) {
			int shouldClose = JOptionPane.showConfirmDialog(this, message, "本当に終了しますか？", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE);
			if (shouldClose == JOptionPane.YES_OPTION)
				this.dispose();

			stopIt = true;
			// if (pokeThread != null)
			// pokeThread.interrupt();
		}

		public boolean shouldStopIt() {
			return stopIt;
		}

	}

	public static interface IDownloadCloser {
		void setPokeThread(Thread currentThread);

		void requestClose();

		boolean shouldStopIt();
	}

	public static interface IDownloadProgress {
		void setProgressBar(JProgressBar p);

		void updateGuess(int sizeGuess);

		void updateProgress(int fullLength);

		void updateString(String string);
	}

	public static class DLBackground extends JPanel {
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

	public static class DLImage extends JPanel {
		private ImageIcon image;
		private int rotation = 0;

		public DLImage setImage(ImageIcon img) {
			image = img;
			this.setPreferredSize(new Dimension(image.getIconWidth(), image.getIconHeight()));
			return this;
		}

		public DLImage setRotation(int rot) {
			rotation = rot;
			return this;
		}

		@Override
		public void paintComponent(Graphics graphics) {
			super.paintComponent(graphics);

			if (image != null)
			{
				Graphics2D g = (Graphics2D) graphics;
				g.setColor(Color.white);
				g.fillRect(0, 0, getWidth(), getHeight());

				g.rotate(rotation * Math.PI / 180, getWidth() / 2.0, getHeight() / 2.0);
				g.drawImage(image.getImage(), (getWidth() - image.getIconWidth()) / 2,
						(getHeight() - image.getIconHeight()) / 2, this);
			}
		}
	}

	public static class DLDetailsGraph extends JPanel {
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
				int max = DLSize.getMeasure(Collections.max(objects));

				FontMetrics fm = g.getFontMetrics();
				g.drawString(DLSize.getFormatSizeString(max, "bps"), 0, fm.getAscent());
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

		public void addObj(int size) {
			objects.add(size);
			repaint();
		}
	}

	public static class DLDetailsText extends JTextArea {

		String server = "";
		String speed = "";
		String timeremaining = "";
		String timeremainingAll = "";
		String status = "";

		public void updateDetails(String key, String value)
		{
			this.setText(new StringBuilder()
			.append(server)
			.append("速度 : " + speed)
			.append("現在のダウンロードの推定残り時間 : " + timeremaining)
			.append("すべてのダウンロードの推定残り時間 : " + timeremainingAll)
			.append(status).toString()
			);
		}
	}

	public static class DLSize {
		private static int p = 1024;
		private static int q = 2;

		public static String getFormatSizeString(float size, String unit) {
			// Return null string when size is zero.
			if (size == 0) return "";

			String[] suffix = { "", "K", "M", "G", "T", "P", "E", "Z", "Y" };
			int index = 0;

			while (size >= p) {
				size /= p;
				index++;
			}

			return String.format("%s%s%s", Integer.toString((int) size), (index < suffix.length ? suffix[index] : "-"), unit);
		}

		public static int getMeasure(float size) {
			int index = 0;

			while (size >= q) {
				size /= q;
				index++;
			}

			return (int) Math.pow(q, index + 1);
		}
	}
}

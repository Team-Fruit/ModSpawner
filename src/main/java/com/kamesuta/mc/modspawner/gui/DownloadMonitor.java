package com.kamesuta.mc.modspawner.gui;

import javax.swing.JProgressBar;

public class DownloadMonitor {
	public static final String displayName = "Mod Spawner";



	public static interface IDownloadProgress {
		void setProgressBar(JProgressBar p);

		void updateGuess(int sizeGuess);

		void updateProgress(int fullLength);

		void updateString(String string);
	}
}

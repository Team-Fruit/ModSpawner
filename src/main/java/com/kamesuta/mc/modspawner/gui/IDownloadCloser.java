package com.kamesuta.mc.modspawner.gui;
public interface IDownloadCloser {
	void setPokeThread(Thread currentThread);

	void requestClose();

	boolean shouldStopIt();
}
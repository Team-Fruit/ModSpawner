package com.kamesuta.mc.modspawner.gui.dl;

/**
 * ダウンロード終了を担当します。
 * @author Kamesuta
 */
public interface IDLCloser {
	void setPokeThread(Thread currentThread);

	void requestClose();

	boolean shouldStopIt();
}
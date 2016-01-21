package com.kamesuta.mc.modspawner.gui;

import javax.swing.JProgressBar;

/**
 * ダウンロード進行をコントロールします
 * @author Kamesuta
 */
public interface IDownloadProgress {
	/**
	 * 進行バーオブジェクトをセットします
	 * @param p
	 */
	void setProgressBar(JProgressBar p);

	/**
	 * 予想サイズを更新します
	 * @param sizeGuess
	 */
	void updateGuess(int sizeGuess);

	/**
	 * 進行サイズを更新します
	 * @param fullLength
	 */
	void updateProgress(int fullLength);

	/**
	 * 表示文字を変更します。
	 * @param string
	 */
	void updateString(String string);
}
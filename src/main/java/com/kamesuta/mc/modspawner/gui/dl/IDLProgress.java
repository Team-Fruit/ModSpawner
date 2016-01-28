package com.kamesuta.mc.modspawner.gui.dl;

import com.kamesuta.mc.modspawner.download.status.Status;

/**
 * ダウンロード進行をコントロールします
 * @author Kamesuta
 */
public interface IDLProgress {
	/**
	 * 進行サイズを更新します
	 * @param status 進行度
	 */
	void update(Status status);
}
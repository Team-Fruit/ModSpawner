package com.kamesuta.mc.modspawner.download.status;

/**
 * ダウンロード進行状況を管理します
 * @author Kamesuta
 */
public interface IStatus {
	/**
	 * 初期メッセージ
	 */
	public static final String DEFAULT_MESSAGE = "Loading...";

	/**
	 * 精密度
	 */
	public static final int PRECISION = 1000;

	/**
	 * 進行度 precision分率
	 * @param precision 精密度
	 * @return precision分率
	 */
	public int getStatus(int precision);

	/**
	 * 進行度 PRECISION分率
	 * @return PRECISION分率
	 */
	public int getStatus();

	/**
	 * バーメッセージ + 進行度
	 * @return メッセージ
	 */
	public String getMessageStatus();
}

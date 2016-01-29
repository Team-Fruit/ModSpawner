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
	 * メッセージ取得
	 * @return メッセージ
	 */
	public String getStatusmessage();

	/**
	 * メッセージ設定
	 * @param statusmessage メッセージ取得
	 */
	public void setStatusmessage(String statusmessage);

	/**
	 * 最大値取得
	 * @return 最大値
	 */
	public long getMax();

	/**
	 * 最大値設定
	 * @param max 最大値
	 */
	public void setMax(long max);

	/**
	 * 進行度取得
	 * @return 進行度
	 */
	public long getStatus();

	/**
	 * 進行度設定
	 * @param status 進行度
	 */
	public void setStatus(long status);

	/**
	 * 進行度 precision分率
	 * @param precision 精密度
	 * @return precision分率
	 */
	public int getStatusPercent(int precision);

	/**
	 * 進行度 PRECISION分率
	 * @return PRECISION分率
	 */
	public int getStatusPercent();

	/**
	 * 進行度テキスト
	 * @return 進行度
	 */
	public String getStatusString();

	/**
	 * バーメッセージ + 進行度
	 * @return メッセージ
	 */
	public String getMessageStatus();
}

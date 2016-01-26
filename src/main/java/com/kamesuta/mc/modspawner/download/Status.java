package com.kamesuta.mc.modspawner.download;

/**
 * ダウンロード進行状況を管理します
 * @author Kamesuta
 */
public class Status {
	/**
	 * 初期メッセージ
	 */
	public static final String DEFAULT_MESSAGE = "Loading...";
	/**
	 * 精密度
	 */
	public static final int PRECISION = 1000;

	/**
	 * 全体のメッセージ
	 */
	public String message = DEFAULT_MESSAGE;
	/**
	 * 新着進行
	 */
	public int updateSize;

	/**
	 * 一括更新をします
	 * @param update 更新サイズ
	 * @param length 更新サイズ
	 */
	public void update(int update, int length)
	{
		narrowStatus = length;
		updateSize = update;
		wideStatus += update;
	}

	/**
	 * 狭域バーメッセージ
	 */
	public String narrowMessage = DEFAULT_MESSAGE;
	/**
	 * 狭域バー進行度
	 */
	public long narrowStatus;
	/**
	 * 狭域バー長さ
	 */
	public long narrowLength;
	/**
	 * 狭域進行度 PRECISION分率
	 * @param precision 精密度
	 * @return precision分率
	 */
	public int getNarrowStatus(int precision)
	{
		if (narrowLength > 0)
			return (int) (narrowStatus * precision / narrowLength);
		else
			return 0;
	}
	/**
	 * 狭域進行度 PRECISION分率
	 * @return PRECISION分率
	 */
	public int getNarrowStatus()
	{
		return getNarrowStatus(PRECISION);
	}
	/**
	 * 狭域バーメッセージ + 進行度
	 * @return メッセージ
	 */
	public String getNarrowMessage()
	{
		return narrowMessage + " - " + String.valueOf(getNarrowStatus(100)) + "%";
	}

	/**
	 * 広域バーメッセージ
	 */
	public String wideMessage = DEFAULT_MESSAGE;
	/**
	 * 広域バー進行度
	 */
	public long wideStatus;
	/**
	 * 広域バー長さ
	 */
	public long wideLength;
	/**
	 * 広域進行度 PRECISION分率
	 * @param precision 精密度
	 * @return precision分率
	 */
	public int getWideStatus(int precision)
	{
		if (wideLength > 0)
			return (int) (wideStatus * precision / wideLength);
		else
			return 0;
	}
	/**
	 * 広域進行度 PRECISION分率
	 * @return PRECISION分率
	 */
	public int getWideStatus()
	{
		return getWideStatus(PRECISION);
	}
	/**
	 * 広義バーメッセージ + 進行度
	 * @return メッセージ
	 */
	public String getWideMessage()
	{
		return wideMessage + " - " + String.valueOf(getWideStatus(100)) + "%";
	}
}

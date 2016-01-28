package com.kamesuta.mc.modspawner.download.status;

/**
 * 全体のダウンロード進行状況を管理します
 * @author Kamesuta
 */
public class Status implements IStatus {
	/**
	 * 全体のメッセージ
	 */
	public String statusmessage = DEFAULT_MESSAGE;

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
		updateSize = update;
		status += update;
	}

	/**
	 * バーメッセージ
	 */
	public String message = DEFAULT_MESSAGE;
	/**
	 * バー進行度
	 */
	public long status;
	/**
	 * バー長さ
	 */
	public long max;

	@Override
	public int getStatus(int precision)
	{
		if (max > 0)
			return (int) (status * precision / max);
		else
			return 0;
	}

	public int getStatus()
	{
		return getStatus(PRECISION);
	}

	public String getMessageStatus()
	{
		return message + " - " + String.valueOf(getStatus(100)) + "%";
	}
}

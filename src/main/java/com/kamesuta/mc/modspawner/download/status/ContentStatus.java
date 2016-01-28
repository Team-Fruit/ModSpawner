package com.kamesuta.mc.modspawner.download.status;

/**
 * コンテンツダウンロード進行状況を管理します
 * @author Kamesuta
 */
public class ContentStatus implements IStatus {
	/**
	 * バーメッセージ
	 */
	public String statusmessage = DEFAULT_MESSAGE;

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

	@Override
	public int getStatus()
	{
		return getStatus(PRECISION);
	}

	@Override
	public String getMessageStatus()
	{
		return statusmessage + " - " + String.valueOf(getStatus(100)) + "%";
	}
}

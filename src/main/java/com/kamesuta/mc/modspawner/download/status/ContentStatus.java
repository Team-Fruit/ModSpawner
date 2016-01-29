package com.kamesuta.mc.modspawner.download.status;

import com.kamesuta.mc.modspawner.util.SizeUnit;

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

	public ContentStatus() {
	}

	public ContentStatus(long max) {
		this.max = max;
	}

	public ContentStatus(long max, String statusmessage) {
		this.max = max;
		this.statusmessage = statusmessage;
	}

	public String getStatusmessage() {
		return statusmessage;
	}

	public void setStatusmessage(String statusmessage) {
		this.statusmessage = statusmessage;
	}

	public long getMax() {
		return max;
	}

	public void setMax(long max) {
		this.max = max;
	}

	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	@Override
	public int getStatusPercent(int precision)
	{
		if (max > 0)
			return (int) (status * precision / max);
		else
			return 0;
	}

	@Override
	public int getStatusPercent()
	{
		return getStatusPercent(PRECISION);
	}

	@Override
	public String getStatusString()
	{
		return SizeUnit.STORAGE.getFormatSizeString(status, 0) + " / " + SizeUnit.STORAGE.getFormatSizeString(max, 0);
	}

	@Override
	public String getMessageStatus()
	{
		return statusmessage + " - " + getStatusString();
	}
}

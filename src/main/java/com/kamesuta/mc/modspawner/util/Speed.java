package com.kamesuta.mc.modspawner.util;

/**
 * ダウンロードの速度を計算します。
 * @author Kamesuta
 */
public class Speed {
	/**
	 * ナノ秒と秒の比率
	 */
	public static final double NANOS_PER_SECOND = 1000000000.0;
	/**
	 * ビットとバイトの比率
	 */
	public static final int BIT_PER_BYTE = 8;

	private long newTime;
	private long oldTime;

	private int lastCount;
	private int lastTime;
	private PushList<Integer> aveCount;
	private PushList<Integer> aveTime;

	/**
	 * 平均の蓄積量を指定してください。
	 * @param averagesize 蓄積量
	 */
	public Speed(int averagesize)
	{
		aveCount = new PushList<Integer>(averagesize);
		aveTime = new PushList<Integer>(averagesize);
	}

	/**
	 * 情報を更新します
	 * @param count 前回との差
	 * @return this
	 */
	public Speed update(int count)
	{
		// get current time
		newTime = System.nanoTime();

		// update count
		aveCount.add(lastCount = count);
		aveTime.add(lastTime = (int)(newTime-oldTime));

		// reset
		oldTime = newTime;

		// method chain
		return this;
	}

	/**
	 * update間の回数を返す
	 */
	public int getCount()
	{
		return lastCount;
	}

	/**
	 * update間の平均回数を返す
	 */
	public int getAverageCount()
	{
		return (int) Util.average(aveCount);
	}

	/**
	 * update間の時間を返す
	 */
	public int getTime()
	{
		return lastTime;
	}

	/**
	 * update間の平均時間を返す
	 */
	public int getAverageTime()
	{
		return (int) Util.average(aveTime);
	}

	/**
	 * 速度を返す
	 * @return byte/seconds
	 */
	public double getByteSpeed()
	{
		if (lastTime>0 && oldTime>0 && lastCount>0) {
			return NANOS_PER_SECOND * lastCount / lastTime;
		} else {
			return -1;
		}
	}

	/**
	 * 平均速度を返す
	 * @return byte/seconds
	 */
	public double getAverageByteSpeed()
	{
		double timeave = Util.average(aveTime);
		double countave = Util.average(aveCount);
		if (timeave>0 && oldTime>0 && countave>0) {
			return NANOS_PER_SECOND * countave / timeave;
		} else {
			return -1;
		}
	}

	/**
	 * 速度を返す
	 * @return bit/seconds
	 */
	public double getSpeed()
	{
		return getByteSpeed() * BIT_PER_BYTE;
	}

	/**
	 * 平均速度を返す
	 * @return bit/seconds
	 */
	public double getAverageSpeed()
	{
		return getAverageByteSpeed() * BIT_PER_BYTE;
	}

	/**
	 * 推定残り時間を返す
	 * @return seconds
	 */
	public int getFull(long bytes)
	{
		double speed = getByteSpeed();
		if (speed>0) {
			return (int) (bytes / speed);
		} else {
			return -1;
		}
	}

	/**
	 * 推定残り時間を返す
	 * @return seconds
	 */
	public int getAverageFull(long bytes)
	{
		double speed = getAverageByteSpeed();
		if (speed>0) {
			return (int) (bytes / speed);
		} else {
			return -1;
		}
	}
}
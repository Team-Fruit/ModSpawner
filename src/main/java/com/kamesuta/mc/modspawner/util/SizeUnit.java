package com.kamesuta.mc.modspawner.util;

/**
 * ファイルのサイズについて扱います
 * @author Kamesuta
 *
 */
public enum SizeUnit {
	/**
	 * 保存領域のサイズを計算します。
	 */
	STORAGE(1024, 2, new String[]{"", "K", "M", "G", "T", "P", "E", "Z", "Y"}, "B"),
	/**
	 * 速度などのサイズを計算します。
	 */
	SPEED(1024, 2, new String[]{"", "k", "M", "G", "T", "P", "E", "Z", "Y"}, "bps");

	private final int pow;
	private final int bottom;
	private final String[] suffix;
	private final String unit;

	private SizeUnit(int pow, int bottom, String[] suffix, String unit)
	{
		this.pow = pow;
		this.bottom = bottom;
		this.suffix = suffix;
		this.unit = unit;
	}

	/**
	 * サイズを単位を付けてフォーマットします。
	 * @param size サイズ
	 * @param digit 小数桁数
	 * @return フォーマット済み文字列
	 */
	public String getFormatSizeString(double size, int digit) {
		int index = 0;

		while (size >= pow) {
			size /= pow;
			index++;
		}

		return String.format(("%."+Integer.toString(digit)+"f%s%s"), size, (index < suffix.length ? suffix[index] : "-"), unit);
	}

	/**
	 * サイズに適した最大値を返します
	 * @param size サイズ
	 * @return 単位の最大値
	 */
	public int getMeasure(float size) {
		int index = 0;

		while (size >= bottom) {
			size /= bottom;
			index++;
		}

		return (int) Math.pow(bottom, index + 1);
	}
}
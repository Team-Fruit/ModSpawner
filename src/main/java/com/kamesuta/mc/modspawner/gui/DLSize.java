package com.kamesuta.mc.modspawner.gui;

/**
 * ファイルのサイズについて扱います
 * @author Kamesuta
 *
 */
public enum DLSize {
	/**
	 * 保存領域のサイズを計算します。
	 */
	STORAGE(1024, 2, new String[]{"", "K", "M", "G", "T", "P", "E", "Z", "Y"}),
	/**
	 * 速度などのサイズを計算します。
	 */
	SPEED(1000, 10, new String[]{"", "k", "M", "G", "T", "P", "E", "Z", "Y"});

	private final int pow;
	private final int bottom;
	private final String[] suffix;

	private DLSize(int pow, int bottom, String[] suffix)
	{
		this.pow = pow;
		this.bottom = bottom;
		this.suffix = suffix;
	}

	/**
	 * サイズを単位を付けてフォーマットします。
	 * @param size サイズ
	 * @param unit 単位
	 * @return フォーマット済み文字列
	 */
	public String getFormatSizeString(float size, String unit) {
		// Return null string when size is zero.
		if (size == 0) return "";

		int index = 0;

		while (size >= pow) {
			size /= pow;
			index++;
		}

		return String.format("%s%s%s", Integer.toString((int) size), (index < suffix.length ? suffix[index] : "-"), unit);
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
package com.kamesuta.mc.modspawner.gui;

public class DLSize {
	private static int p = 1024;
	private static int q = 2;

	public static String getFormatSizeString(float size, String unit) {
		// Return null string when size is zero.
		if (size == 0) return "";

		String[] suffix = { "", "K", "M", "G", "T", "P", "E", "Z", "Y" };
		int index = 0;

		while (size >= p) {
			size /= p;
			index++;
		}

		return String.format("%s%s%s", Integer.toString((int) size), (index < suffix.length ? suffix[index] : "-"), unit);
	}

	public static int getMeasure(float size) {
		int index = 0;

		while (size >= q) {
			size /= q;
			index++;
		}

		return (int) Math.pow(q, index + 1);
	}
}
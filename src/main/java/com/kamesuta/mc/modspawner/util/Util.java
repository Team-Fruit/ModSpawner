package com.kamesuta.mc.modspawner.util;

import java.util.List;

/**
 * ユーティリティクラス
 * @author Kamesuta
 */
public class Util
{
	/**
	 * 平均を求めます
	 * @param list リスト
	 * @return 平均
	 */
	public static double average(List<? extends Number> list)
	{
		double d = 0d;
		for (Number n : list) {
			d += n.doubleValue();
		}
		return (d/list.size());
	}
}
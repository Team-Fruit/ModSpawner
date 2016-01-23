package com.kamesuta.mc.modspawner.util;

import java.util.LinkedList;
import java.util.List;

/**
 * 平均を計算、保持します。
 * @author Kamesuta
 */
public class Average
{
	private final int size;
	private List<Double> list;

	public Average(int length)
	{
		size = length;
		list = new LinkedList<Double>();
	}

	/**
	 * 要素を更新
	 * @param add 要素
	 */
	public void update(double add)
	{
		list.add(add);
		while (list.size() > size) {
			list.remove(0);
		}
	}

	/**
	 * 平均を求めます
	 * @return 平均
	 */
	public double average()
	{
		int num = 0;
		for (double l : list) {
			num += l;
		}
		return num/size;
	}
}
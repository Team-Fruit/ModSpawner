package com.kamesuta.mc.modspawner.util;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Run experimental code
 * @author Kamesuta
 */
public class TestMain {
	static Logger logger = LogManager.getLogger("Experimental");

	public static void main(String[] args) {
		PushList<Integer> l = new PushList<Integer>(16);

		for (int i=0; i<100; i++)
		{
			if(i==50) l.addAll(0,Arrays.asList(new Integer[]{384,786,432,876,352,562,0}));
			l.push(i);
			logger.info(l);
		}

	}

}

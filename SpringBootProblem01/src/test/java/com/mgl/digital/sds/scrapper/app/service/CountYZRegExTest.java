package com.mgl.digital.sds.scrapper.app.service;

import static org.junit.Assert.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * Problem 03
 */
public class CountYZRegExTest {

	/*
	 * Counts the number of words ending in 'y' or 'z' (not case sensitive). 'y' or
	 * 'z' is at the end of a word if there is not an alphabetic letter immediately
	 * following it.
	 */
	public int countYZ(String str) {
		Matcher m = Pattern.compile("(?i)[yz]\\b").matcher(str);
		int count = 0;
		while (m.find())
			count++;
		return count;
	}

	@Test
	public void shouldPass() throws Exception {
		assertEquals(2, countYZ("fez day"));
		assertEquals(2, countYZ("day fez"));
		assertEquals(1, countYZ("day yak"));
		assertEquals(1, countYZ("day:yak"));
		assertEquals(2, countYZ("!!day--yaz!!"));
		assertEquals(2, countYZ("DAY abc XYZ"));
		assertEquals(3, countYZ("aaz yyz my"));
		assertEquals(1, countYZ("y2bz"));
		assertEquals(0, countYZ("zxyx"));
		assertEquals(1, countYZ("zxyx aedf asfz^&("));
	}
}
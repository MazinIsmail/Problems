package com.mgl.digital.sds.scrapper.app.service;

import static org.junit.Assert.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.springframework.util.StringUtils;

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
		int count = 0;
		String[] stringArray = str.split("[^a-zA-Z]");
		for (String stringWord : stringArray) {
			Matcher m = Pattern.compile("(?i)[yz]\\b").matcher(stringWord);
			if (m.find()) {
				count++;
			}
		}
		return count;
	}

	public int countAZ(String str) {
		int count = 0;
		String[] stringArray = str.split("[^a-zA-Z0-9]");
		for (String stringWord : stringArray) {
			Matcher m = Pattern.compile("(?i)[yz]\\b").matcher(stringWord);
			if (m.find()) {
				count++;
			}
		}
		return count;
	}

	public int countYZ1(String str) {
		if (StringUtils.isNotBlank(str)) {
			Matcher matcher = Pattern.compile("[yz](?!\\p{L})").matcher(str.toLowerCase());
			int count = 0;
			while (matcher.find()) {
				count++;
			}
			return count;
		}
		return 0;
	}

	@Test
	public void shouldPassYZ() throws Exception {
		assertEquals(2, countYZ("fez day"));
		assertEquals(2, countYZ("day fez"));
		assertEquals(1, countYZ("day yak"));
		assertEquals(1, countYZ("day:yak"));
		assertEquals(2, countYZ("!!day--yaz!!"));
		assertEquals(2, countYZ("DAY abc XYZ"));
		assertEquals(3, countYZ("aaz yyz my"));
		assertEquals(2, countYZ("y2bz"));
		assertEquals(0, countYZ("zxyx"));
		assertEquals(1, countYZ("zxyx aedf asfz^&("));
	}

	@Test
	public void shouldPassAZ() throws Exception {
		assertEquals(2, countAZ("fez day"));
		assertEquals(2, countAZ("day fez"));
		assertEquals(1, countAZ("day yak"));
		assertEquals(1, countAZ("day:yak"));
		assertEquals(2, countAZ("!!day--yaz!!"));
		assertEquals(2, countAZ("DAY abc XYZ"));
		assertEquals(3, countAZ("aaz yyz my"));
		assertEquals(1, countAZ("y2bz"));
		assertEquals(0, countAZ("zxyx"));
		assertEquals(1, countAZ("zxyx aedf asfz^&("));
	}
}
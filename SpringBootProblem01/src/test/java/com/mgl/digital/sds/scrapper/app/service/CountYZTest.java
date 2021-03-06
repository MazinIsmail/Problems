package com.mgl.digital.sds.scrapper.app.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Problem 03
 */
public class CountYZTest {

	/*
	 * Counts the number of words ending in 'y' or 'z' (not case sensitive). 'y' or
	 * 'z' is at the end of a word if there is not an alphabetic letter immediately
	 * following it.
	 */
	public int countYZ(String str) {
		char[] charString = str.toCharArray();
		int count = 0;
		Integer startWordCharIndex = null;
		for (int i = 0; i < charString.length; i++) {
			char charValue = charString[i];
			boolean alphaCheck = isAlpha(charValue);
			if (alphaCheck) {
				// Word Starting Point
				for (int j = i; j < charString.length; j++) {
					charValue = charString[j];
					alphaCheck = isAlpha(charValue);
					if (alphaCheck) {
						if (j == charString.length - 1) {
							if (isZYCheck(charString[j])) {
								count++;
							}
							i = j;
							break;
						}
						continue;
					} else {
						i = j;
						if (isZYCheck(charString[--j])) {
							count++;
						}
						break;
					}
				}
			}
		}
		return count;
	}

	/**
	 * Checks if the char is a alphabet or not.
	 */
	private boolean isAlpha(char charValue) {
		return (charValue >= 65 && charValue <= 90) || (charValue >= 97 && charValue <= 122);
	}

	/**
	 * Checks if the char is 'z', 'Z', 'y', 'Y' or not.
	 */
	private boolean isZYCheck(char c) {
		char[] zyChar = { 'z', 'Z', 'y', 'Y' };
		for (char x : zyChar) {
			if (x == c) {
				return true;
			}
		}
		return false;
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
		assertEquals(2, countYZ("y2bz"));
		assertEquals(0, countYZ("zxyx"));
		assertEquals(1, countYZ("zxyx aedf asfz^&("));
	}
}
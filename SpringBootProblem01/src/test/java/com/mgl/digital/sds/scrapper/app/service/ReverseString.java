package com.mgl.digital.sds.scrapper.app.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReverseString {

	public static String reverseString(String sval) {
		StringBuilder result = new StringBuilder();
		String[] wordList = sval.split(" ");
		for (int i = 0; i < wordList.length; i++) {
			String singleWord = wordList[i];
			StringBuilder sb = new StringBuilder(singleWord);
			result.append(sb.reverse());
			if (i + 1 == wordList.length) {

			} else {
				result.append(" ");
			}
		}
		return result.toString();
	}

	@Test
	public void testReverse() {
		assertEquals("ih", reverseString("hi"));
		assertEquals("olleh dlrow", reverseString("hello world"));
	}
}

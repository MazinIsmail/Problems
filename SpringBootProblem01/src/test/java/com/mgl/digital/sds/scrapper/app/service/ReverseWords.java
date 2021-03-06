package com.mgl.digital.sds.scrapper.app.service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class ReverseWords {

	public static String reverseString(String sval) {
		String[] wordList = sval.split(" ");
		List<String> temp = Arrays.asList(wordList);
		Collections.reverse(temp);
		return temp.stream().collect(Collectors.joining(" "));

	}

	@Test
	public void testReverse() {
		assertEquals("world hello", reverseString("hello world"));
	}
}

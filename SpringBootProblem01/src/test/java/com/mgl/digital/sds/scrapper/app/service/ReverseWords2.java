package com.mgl.digital.sds.scrapper.app.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class ReverseWords2 {

	public static String consequetiveDuplicates(String sval) {
		String[] wordList = sval.split(" ");
		List<String> newList = new ArrayList<>();
		for (int i = 0; i < wordList.length; i++) {
			String singleWord = wordList[i];
			if (i == 0 || !singleWord.equalsIgnoreCase(newList.get(newList.size() - 1))) {
				newList.add(singleWord);
			}
		}
		Collections.reverse(newList);
		return newList.stream().collect(Collectors.joining(" "));

	}

	@Test
	public void testReverse() {
		assertEquals("sydney to sydney to welcome",
				consequetiveDuplicates("welcome welcome to sydney to to sydney sydney"));
	}
}

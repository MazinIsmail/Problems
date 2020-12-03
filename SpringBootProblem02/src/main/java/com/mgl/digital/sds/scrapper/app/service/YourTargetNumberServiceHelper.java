package com.mgl.digital.sds.scrapper.app.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class YourTargetNumberServiceHelper {

	public int[] findSumTargetIndex(int[] nums, int target) {
		Map<Integer, Integer> numMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int singleValue = nums[i];
			int complementaryNumber = target - singleValue;
			if (numMap.containsKey(complementaryNumber)) {
				return new int[] { numMap.get(complementaryNumber), i };
			} else {
				numMap.put(nums[i], i);
			}
		}
		return new int[] {};
	}

}

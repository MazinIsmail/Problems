package com.mgl.digital.sds.scrapper.app.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Given an array and a target value, return the indices of two numbers whose
 * sum will equal the target. array = [0, 29, 10, 8, 19, 2], target = 37 should
 * return [1, 3]
 */
@Service
public class YourTargetNumberService implements TargetNumberService {

	public int[] indices(int[] arr, int target) throws IllegalStateException {
		if (arr == null || arr.length == 0)
			throw new IllegalStateException("wrong input");
		else {
			return findSumTargetIndex(arr, target);
		}
	}

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

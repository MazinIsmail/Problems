package com.mgl.digital.sds.scrapper.app.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

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
			return findSumTargetIndexMemoryTechnique(arr, target);
		}
	}

	/**
	 * Returns the indices of two numbers whose sum will equal the target. Using
	 * memory technique.
	 */
	public int[] findSumTargetIndexMemoryTechnique(int[] nums, int target) {
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

	/**
	 * Returns the indices of two numbers whose sum will equal the target. Brute
	 * Force technique.
	 */
	public int[] findSumTargetIndexBruteForce(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		return new int[] {};
	}

	public int[] findSumTargetIndexBruteForceUsingStreams(int[] nums, int target) {
		// TODO:
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		return new int[] {};
	}

	/**
	 * Returns the indices of two numbers whose sum will equal the target. Brute
	 * Force technique.
	 */
	public int[] findSumTargetIndexSorted(int[] nums, int target) {
		Arrays.sort(nums);
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			if (nums[left] + nums[right] == target) {
				return new int[] { left, right };
			} else if (nums[left] + nums[right] < target) {
				left++;
			} else {
				right--;
			}
		}
		return new int[] {};
	}

	public int[] getindicies(int[] arr, int targetvalue) {
		Map<Integer, Integer> map = new HashMap<>();
		IntStream.range(0, arr.length).forEach(i -> IntStream.range(0, arr.length)
				.filter(j -> arr[i] + arr[j] == targetvalue).forEach(ind -> map.put(i, arr[i])));
		return map.keySet().stream().mapToInt(i -> i).toArray();
	}

}

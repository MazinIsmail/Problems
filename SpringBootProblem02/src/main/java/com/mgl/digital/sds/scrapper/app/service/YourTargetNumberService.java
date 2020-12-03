package com.mgl.digital.sds.scrapper.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Given an array and a target value, return the indices of two numbers whose
 * sum will equal the target. array = [0, 29, 10, 8, 19, 2], target = 37 should
 * return [1, 3]
 */
@Service
public class YourTargetNumberService implements TargetNumberService {

	@Autowired
	private YourTargetNumberServiceHelper yourTargetNumberServiceHelper;

	public int[] indices(int[] arr, int target) throws IllegalStateException {
		if (arr == null || arr.length == 0)
			throw new IllegalStateException("wrong input");
		else {
			return yourTargetNumberServiceHelper.findSumTargetIndex(arr, target);
		}
	}

}

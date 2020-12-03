package com.mgl.digital.sds.scrapper.app.service;

/**
 * Given an array and a target value, return the indices of two numbers whose
 * sum will equal the target. array = [0, 29, 10, 8, 19, 2], target = 37 should
 * return [1, 3]
 */
public interface TargetNumberService {
	int[] indices(int[] arr, int target) throws IllegalStateException;
}

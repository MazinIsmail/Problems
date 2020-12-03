package com.mgl.digital.sds.scrapper.app.testHelper;

import com.mgl.digital.sds.scrapper.app.models.TargetInputs;

public class TestHelper {

	public static TargetInputs sampleTargetInputs1() {
		TargetInputs targetInputs = new TargetInputs();
		int[] arrayInput = numsValue1();
		targetInputs.setArrayInput(arrayInput);
		targetInputs.setTarget(targetValue1());
		return targetInputs;
	}

	public static TargetInputs sampleTargetInputsEmpty() {
		TargetInputs targetInputs = new TargetInputs();
		targetInputs.setTarget(targetValue1());
		return targetInputs;
	}

	public static TargetInputs sampleTargetInputsFullEmpty() {
		TargetInputs targetInputs = new TargetInputs();
		return targetInputs;
	}

	public static int[] numsValue1() {
		int[] nums = { 0, 29, 10, 8, 19, 2 };
		return nums;
	}

	public static String targetValue1() {
		return "37";
	}

	public static int[] indicesValue1() {
		int[] nums = { 1, 3 };
		return nums;
	}

	public static int[] indicesValue2() {
		int[] nums = { 1, 4 };
		return nums;
	}
}

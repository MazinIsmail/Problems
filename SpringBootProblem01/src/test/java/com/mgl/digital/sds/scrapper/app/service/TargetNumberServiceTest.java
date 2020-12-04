package com.mgl.digital.sds.scrapper.app.service;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { YourTargetNumberService.class })
public class TargetNumberServiceTest {

	@Autowired
	private TargetNumberService targetNumberService;

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void indicesSuccessTest() {
		int[] expectedIndices = { 1, 3 };
		int[] nums = { 0, 29, 10, 8, 19, 2 };
		int[] actualIndices = targetNumberService.indices(nums, Integer.parseInt("37"));
		assertArrayEquals(expectedIndices, actualIndices);
	}

	@Test
	public void indicesNotEqualTest() {
		int[] expectedIndices = { 1, 4 };
		int[] nums = { 0, 29, 10, 8, 19, 2 };
		int[] actualIndices = targetNumberService.indices(nums, Integer.parseInt("37"));
		assertFalse(Arrays.equals(expectedIndices, actualIndices));
	}

	@Test
	public void indicesEmptyValidationTest() {
		expectedException.expect(IllegalStateException.class);
		expectedException.expectMessage("wrong input");
		int[] expectedIndices = { 1, 4 };
		int[] actualIndices = targetNumberService.indices(null, Integer.parseInt("37"));

	}

}

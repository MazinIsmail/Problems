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

import com.mgl.digital.sds.scrapper.app.testHelper.TestHelper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { YourTargetNumberService.class, YourTargetNumberServiceHelper.class })
public class TargetNumberServiceTest {

	@Autowired
	private TargetNumberService targetNumberService;

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void indicesSuccessTest() {
		int[] expectedIndices = TestHelper.indicesValue1();
		int[] actualIndices = targetNumberService.indices(TestHelper.numsValue1(),
				Integer.parseInt(TestHelper.targetValue1()));
		assertArrayEquals(expectedIndices, actualIndices);
	}

	@Test
	public void indicesNotEqualTest() {
		int[] expectedIndices = TestHelper.indicesValue2();
		int[] actualIndices = targetNumberService.indices(TestHelper.numsValue1(),
				Integer.parseInt(TestHelper.targetValue1()));
		assertFalse(Arrays.equals(expectedIndices, actualIndices));
	}

	@Test
	public void indicesEmptyValidationTest() {
		expectedException.expect(IllegalStateException.class);
		expectedException.expectMessage("wrong input");
		int[] expectedIndices = TestHelper.indicesValue2();
		int[] actualIndices = targetNumberService.indices(null, Integer.parseInt(TestHelper.targetValue1()));

	}

}

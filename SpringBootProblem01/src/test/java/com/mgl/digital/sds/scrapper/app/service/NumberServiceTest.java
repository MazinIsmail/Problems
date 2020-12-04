package com.mgl.digital.sds.scrapper.app.service;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.mgl.digital.sds.scrapper.app.testHelper.TestHelper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { DefaultNumberService.class })
public class NumberServiceTest {

	@Autowired
	private NumberService numberService;

	@Test
	public void defaultNumberServiceGetNumbersTest() {
		Map<String, Object> mockData = TestHelper.getResponse();
		Map<String, Object> getNumbersResponseActual = numberService.getNumbers();
		assertEquals(mockData.get(0), getNumbersResponseActual.get(0));
	}
	
	@Test
	public void defaultNumberServiceGetNumbersFailTest() {
		Map<String, Object> mockData = TestHelper.getResponse1();
		Map<String, Object> getNumbersResponseActual = numberService.getNumbers();
		assertEquals(mockData.get(0), getNumbersResponseActual.get(0));
	}

}

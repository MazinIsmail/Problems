package com.mgl.digital.sds.scrapper.app.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { DefaultNumberService.class })
public class NumberServiceTest {

	@Autowired
	private NumberService numberService;

	@Test
	public void defaultNumberServiceGetNumbersTest() {
		Map<String, Object> mockData = new HashMap<>();
		List<Integer> result = new ArrayList<>();
		result.add(9);
		result.add(25);
		result.add(36);
		result.add(81);
		result.add(100);
		result.add(144);
		result.add(225);
		result.add(324);
		result.add(400);
		result.add(441);
		mockData.put("data", result);
		mockData.put("time_taken", 0);
		Map<String, Object> getNumbersResponseActual = numberService.getNumbers();
		assertEquals(mockData.get(0), getNumbersResponseActual.get(0));
	}

	@Test
	public void defaultNumberServiceGetNumbersFailTest() {
		Map<String, Object> mockData = new HashMap<>();
		List<Integer> result = new ArrayList<>();
		result.add(0);
		result.add(25);
		result.add(36);
		result.add(81);
		result.add(100);
		result.add(144);
		mockData.put("data", result);
		mockData.put("time_taken", 0);
		Map<String, Object> getNumbersResponseActual = numberService.getNumbers();
		Object temp = mockData.get("data");
		ArrayList<Integer> mockValue = (ArrayList) temp;
		Object temp1 = getNumbersResponseActual.get("data");
		ArrayList<Integer> actualValue = (ArrayList) temp1;
		assertNotEquals(mockValue.get(0), actualValue.get(0));
	}

}

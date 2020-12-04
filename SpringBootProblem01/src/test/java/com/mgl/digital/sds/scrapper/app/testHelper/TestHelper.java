package com.mgl.digital.sds.scrapper.app.testHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestHelper {
	public static Map<String, Object> getResponse() {
		Map<String, Object> response = new HashMap<>();
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
		response.put("data", result);
		response.put("time_taken", 0);
		return response;
	}
	
	public static Map<String, Object> getResponse1() {
		Map<String, Object> response = new HashMap<>();
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
		response.put("data", result);
		response.put("time_taken", 0);
		return response;
	}
}

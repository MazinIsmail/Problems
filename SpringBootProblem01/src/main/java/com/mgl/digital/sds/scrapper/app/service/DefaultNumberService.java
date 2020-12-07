package com.mgl.digital.sds.scrapper.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

/**
 * Class that returns a map with ...
 * 
 */
@Service
public class DefaultNumberService implements NumberService {

	/**
	 * Method generates a sequence of numbers between 1 and 1000 inclusive. It then
	 * keeps only the ones which are multiples of 3 or 5 and then squares them. It
	 * returns the first 10 numbers from the series.
	 */
	@Override
	public Map<String, Object> getNumbers() {
		List<Integer> result = new ArrayList<>();
		long startTime = System.nanoTime();
		result = IntStream.rangeClosed(1, 1000).boxed().filter(str -> str % 3 == 0 || str % 5 == 0).limit(10)
				.map(n -> n * n).collect(Collectors.toList());
		Map<String, Object> response = new HashMap<>();
		response.put("data", result);
		long elapsedTime = System.nanoTime() - startTime;
		response.put("time_taken", elapsedTime + " ns");
		return response;
	}
	
	@Override
	public Map<String, Object> getNumbersRange(int lowwerRange, int upperRange) {
		List<Integer> result = new ArrayList<>();
		long startTime = System.nanoTime();
		result = IntStream.rangeClosed(lowwerRange, upperRange).boxed().filter(str -> str % 3 == 0 || str % 5 == 0).limit(10)
				.map(n -> n * n).collect(Collectors.toList());
		Map<String, Object> response = new HashMap<>();
		response.put("data", result);
		long elapsedTime = System.nanoTime() - startTime;
		response.put("time_taken", elapsedTime + " ns");
		return response;
	}

}
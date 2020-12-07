package com.mgl.digital.sds.scrapper.app.service;

import java.util.Map;

public interface NumberService {
	Map<String, Object> getNumbers();

	Map<String, Object> getNumbersRange(int lowwerRange, int upperRange);
}

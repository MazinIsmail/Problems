package com.mgl.digital.sds.scrapper.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mgl.digital.sds.scrapper.app.service.NumberService;

@Controller
public class NumberController {

	@Autowired
	private NumberService numberService;

	@ResponseBody
	@RequestMapping("/numbers")
	public Map<String, Object> numbers() {
		// TODO - inject a Number Service and call getNumbers(), and return the result
		Map<String, Object> numbers = numberService.getNumbers();
		return numbers;
	}
}
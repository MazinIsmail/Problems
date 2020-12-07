package com.mgl.digital.sds.scrapper.app.controller;

import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Digits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mgl.digital.sds.scrapper.app.models.TargetInputs;
import com.mgl.digital.sds.scrapper.app.service.NumberService;
import com.mgl.digital.sds.scrapper.app.service.TargetNumberService;

/**
 * Problem 01 and 02 Controller.
 */
@Controller
public class NumberTargetController {

	@Autowired
	private NumberService numberService;

	@Autowired
	private TargetNumberService targetNumberService;

	@ResponseBody
	@RequestMapping("/numbers")
	public Map<String, Object> numbers() {
		Map<String, Object> numbers = numberService.getNumbers();
		return numbers;
	}

	@ResponseBody
	@RequestMapping("/numbers/{lowwerRange}/{upperRange}")
	public Map<String, Object> numbersRange(
			@PathVariable("lowwerRange") @Digits(fraction = 0, integer = 0) String lowwerRange,
			@PathVariable("upperRange") @Digits(fraction = 0, integer = 0) String upperRange) {

		Map<String, Object> numbers = numberService.getNumbersRange(Integer.parseInt(lowwerRange),
				Integer.parseInt(upperRange));
		return numbers;
	}

	@ResponseBody
	@RequestMapping(value = "/numbersRParam")
	public Map<String, Object> numbersRangeRParam(
			@RequestParam("lowwerRange") @Digits(fraction = 0, integer = 0) String lowwerRange,
			@RequestParam("upperRange") @Digits(fraction = 0, integer = 0) String upperRange) {

		Map<String, Object> numbers = numberService.getNumbersRange(Integer.parseInt(lowwerRange),
				Integer.parseInt(upperRange));
		return numbers;
	}

	@ResponseBody
	@RequestMapping(value = "/indices", method = RequestMethod.GET)
	public ResponseEntity<?> numbers(@RequestBody @Valid TargetInputs targetInputs) {
		int[] indices = null;
		try {
			indices = targetNumberService.indices(targetInputs.getArrayInput(),
					Integer.parseInt(targetInputs.getTarget()));
		} catch (IllegalStateException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(indices, HttpStatus.OK);
	}

	/*
	 * http://localhost:8080/indicesPathVariable/{target}
	 */
	@ResponseBody
	@RequestMapping(value = "/indicesPathVariable/{target}", method = RequestMethod.GET)
	public ResponseEntity<?> numbersPathVariable(@RequestBody TargetInputs targetInputs,
			@PathVariable("target") String target) {
		int[] indices = null;
		try {
			targetInputs.setTarget(target);
			indices = targetNumberService.indices(targetInputs.getArrayInput(),
					Integer.parseInt(targetInputs.getTarget()));
		} catch (IllegalStateException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(indices, HttpStatus.OK);
	}

	/*
	 * http://localhost:8080/indicesRequestParam?target={}
	 */
	@ResponseBody
	@RequestMapping(value = "/indicesRequestParam", method = RequestMethod.GET)
	public ResponseEntity<?> numbersParam(@RequestBody TargetInputs targetInputs,
			@RequestParam(name = "target") String target) {
		int[] indices = null;
		try {
			targetInputs.setTarget(target);
			indices = targetNumberService.indices(targetInputs.getArrayInput(),
					Integer.parseInt(targetInputs.getTarget()));
		} catch (IllegalStateException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(indices, HttpStatus.OK);
	}
}
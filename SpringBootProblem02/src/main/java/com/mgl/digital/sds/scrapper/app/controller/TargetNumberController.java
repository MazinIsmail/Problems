package com.mgl.digital.sds.scrapper.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mgl.digital.sds.scrapper.app.models.TargetInputs;
import com.mgl.digital.sds.scrapper.app.service.TargetNumberService;

@Controller
public class TargetNumberController {

	@Autowired
	private TargetNumberService targetNumberService;

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
}
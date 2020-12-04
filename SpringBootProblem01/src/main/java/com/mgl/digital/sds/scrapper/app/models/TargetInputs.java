package com.mgl.digital.sds.scrapper.app.models;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

public class TargetInputs {

	private int[] arrayInput;

	@Digits(fraction = 0, integer = 10)
	@NotBlank
	private String target;

	public int[] getArrayInput() {
		return arrayInput;
	}

	public void setArrayInput(int[] arrayInput) {
		this.arrayInput = arrayInput;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

}

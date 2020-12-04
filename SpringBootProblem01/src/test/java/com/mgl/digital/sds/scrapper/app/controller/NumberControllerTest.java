package com.mgl.digital.sds.scrapper.app.controller;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mgl.digital.sds.scrapper.app.models.TargetInputs;
import com.mgl.digital.sds.scrapper.app.service.NumberService;
import com.mgl.digital.sds.scrapper.app.service.TargetNumberService;
import com.mgl.digital.sds.scrapper.app.testHelper.TestHelper;

@SpringBootTest
@WebMvcTest(value = NumberController.class)
public class NumberControllerTest {

	private static final String NUMBER_URL = "/numbers";
	private static final String INDICES_URL = "/indices";

	@InjectMocks
	private NumberController numberController;

	@Mock
	private NumberService numberService;

	@Mock
	private TargetNumberService targetNumberService;

	private MockMvc mockMvc;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(numberController).build();
	}

	@Test
	public void numberFullValueTest() throws Exception {
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
		Mockito.when(numberService.getNumbers()).thenReturn(mockData);
		mockMvc.perform(get(NUMBER_URL).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.data", hasItem(9)));
		Mockito.reset(numberService);
	}

	@Test
	public void indicesNullTest() throws Exception {
		mockMvc.perform(get(INDICES_URL).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
	}

	@Test
	public void indicesValidationTest() throws Exception {
		TargetInputs targetInputs = new TargetInputs();
		String json = new ObjectMapper().writeValueAsString(targetInputs);
		mockMvc.perform(get(INDICES_URL).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void indicesSucessTest() throws Exception {
		TargetInputs targetInputs = new TargetInputs();
		int[] arrayInput = { 0, 29, 10, 8, 19, 2 };
		targetInputs.setArrayInput(arrayInput);
		targetInputs.setTarget("37");
		int[] nums = { 0, 29, 10, 8, 19, 2 };
		Mockito.when(targetNumberService.indices(nums, Integer.parseInt("37")))
				.thenReturn(TestHelper.indicesValue1());
		String json = new ObjectMapper().writeValueAsString(targetInputs);
		mockMvc.perform(get(INDICES_URL).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$", hasItem(1))).andExpect(jsonPath("$", hasItem(3)));
	}

}

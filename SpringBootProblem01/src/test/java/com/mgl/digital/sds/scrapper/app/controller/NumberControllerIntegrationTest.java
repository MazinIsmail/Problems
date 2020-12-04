package com.mgl.digital.sds.scrapper.app.controller;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mgl.digital.sds.scrapper.app.main.SpringLearningsProblem01Application;
import com.mgl.digital.sds.scrapper.app.models.TargetInputs;

@SpringBootTest(classes = SpringLearningsProblem01Application.class)
@RunWith(SpringRunner.class)
public class NumberControllerIntegrationTest {

	private static final String NUMBER_URL = "/numbers";
	private static final String INDICES_URL = "/indices";

	@Autowired
	private NumberTargetController numberTargetController;

	private MockMvc mockMvc;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(numberTargetController).build();
	}

	@Test
	public void numberFullValueTest() throws Exception {
		mockMvc.perform(get(NUMBER_URL).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.data", hasItem(9)));
	}

	@Test
	public void indicesNullTest() throws Exception {
		mockMvc.perform(get(INDICES_URL).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
	}

	@Test
	public void indicesFailMessageTest() throws Exception {
		TargetInputs targetInputs = new TargetInputs();
		targetInputs.setTarget("37");
		String json = new ObjectMapper().writeValueAsString(targetInputs);
		mockMvc.perform(get(INDICES_URL).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest()).andExpect(content().string("wrong input"));
	}

	@Test
	public void indicesSucessTest() throws Exception {
		TargetInputs targetInputs = new TargetInputs();
		int[] arrayInput = { 0, 29, 10, 8, 19, 2 };
		targetInputs.setArrayInput(arrayInput);
		targetInputs.setTarget("37");
		String json = new ObjectMapper().writeValueAsString(targetInputs);
		mockMvc.perform(get(INDICES_URL).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$", hasItem(1))).andExpect(jsonPath("$", hasItem(3)));
	}

}

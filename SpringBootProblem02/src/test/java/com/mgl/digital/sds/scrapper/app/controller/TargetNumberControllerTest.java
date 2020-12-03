package com.mgl.digital.sds.scrapper.app.controller;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.mgl.digital.sds.scrapper.app.service.TargetNumberService;
import com.mgl.digital.sds.scrapper.app.testHelper.TestHelper;

@SpringBootTest
@WebMvcTest(value = TargetNumberController.class)
public class TargetNumberControllerTest {

	private static final String NUMBER_URL = "/indices";

	@InjectMocks
	private TargetNumberController targetNumberController;

	@Mock
	private TargetNumberService targetNumberService;

	private MockMvc mockMvc;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(targetNumberController).build();
	}

	@Test
	public void indicesNullTest() throws Exception {
		mockMvc.perform(get(NUMBER_URL).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
	}

	@Test
	public void indicesValidationTest() throws Exception {
		TargetInputs targetInputs = TestHelper.sampleTargetInputsFullEmpty();
		String json = new ObjectMapper().writeValueAsString(targetInputs);
		mockMvc.perform(get(NUMBER_URL).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void indicesSucessTest() throws Exception {
		TargetInputs targetInputs = TestHelper.sampleTargetInputs1();
		Mockito.when(targetNumberService.indices(TestHelper.numsValue1(), Integer.parseInt(TestHelper.targetValue1())))
				.thenReturn(TestHelper.indicesValue1());
		String json = new ObjectMapper().writeValueAsString(targetInputs);
		mockMvc.perform(get(NUMBER_URL).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$", hasItem(1))).andExpect(jsonPath("$", hasItem(3)));
	}

}

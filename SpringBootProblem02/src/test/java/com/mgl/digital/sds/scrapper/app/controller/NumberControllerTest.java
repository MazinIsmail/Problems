package com.mgl.digital.sds.scrapper.app.controller;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

import com.mgl.digital.sds.scrapper.app.service.NumberService;
import com.mgl.digital.sds.scrapper.app.testHelper.TestHelper;

@SpringBootTest
@WebMvcTest(value = TargetNumberController.class)
public class NumberControllerTest {

	private static final String NUMBER_URL = "/numbers";

	@InjectMocks
	private TargetNumberController numberController;

	@Mock
	private NumberService numberService;

	private MockMvc mockMvc;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(numberController).build();
	}

	@Test
	public void numberFullValueTest() throws Exception {
		Map<String, Object> mockData = TestHelper.getResponse();
		Mockito.when(numberService.getNumbers()).thenReturn(mockData);
		mockMvc.perform(get(NUMBER_URL).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.data", hasItem(9)));
		Mockito.reset(numberService);
	}

}

package com.mgl.digital.sds.scrapper.app.controller;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mgl.digital.sds.scrapper.app.service.NumberService;

//@RunWith(SpringRunner.class)
@SpringBootTest
@WebMvcTest(value = NumberController.class)
public class NumberControllerTest {

	private static final String NUMBER_URL = "/numbers";

	@InjectMocks
	private NumberController numberController;

	@Mock
	private NumberService numberService;

	private MockMvc mockMvc;

	/**
	 * If it is not using the MockitoJUnitRunner class approach, then is need to use
	 * the static method MockitoAnnotations.initMocks(). This method also, upon
	 * initialization of junit tests, initializes the mock objects.
	 */
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(numberController).build();
	}

	@Test
	public void fetchAllAccountsTest() throws Exception {
		Map<String, Object> response = TestHelper.getResponse();
		Mockito.when(numberService.getNumbers()).thenReturn(response);
		mockMvc.perform(get(NUMBER_URL).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.data", hasItem(9)));
		Mockito.reset(numberService);

	}

}

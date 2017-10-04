package com.olx.sac.sacwebbff.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestOperations;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class AttendanceControllerTest {
	
	@Mock
	private RestOperations restOperationsMock;
	
	private MockMvc mockMvc;

	private MvcResult resultService;

	@InjectMocks
	private AttendanceController attendanceController;
	
	@Before
	public void configure() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(attendanceController).build();
	}
	
	@Test
	public void listAttendancesTestSucess() throws Exception {
		
		resultService = mockMvc.perform(MockMvcRequestBuilders.get("/olx/attendances"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
		assertNotNull(resultService);
		Assert.assertTrue(resultService.getResponse().getContentAsString().contains(""));
		
	}
}

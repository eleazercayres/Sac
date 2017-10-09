package com.olx.sac.test.sacwebbff.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.util.NestedServletException;

import com.olx.sac.sacserviceapi.attendance.CallDTO;
import com.olx.sac.sacserviceapi.attendance.StateDTO;
import com.olx.sac.sacserviceapi.constants.ReasonCalled;
import com.olx.sac.sacserviceapi.constants.TypeOfCall;
import com.olx.sac.sacwebbff.controller.AttendanceController;
import com.olx.sac.sacwebbff.controller.StateController;
import com.olx.sac.sacwebbff.exception.CallServiceException;
import com.olx.sac.sacwebbff.service.AttendanceService;
import com.olx.sac.sacwebbff.service.StateService;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class StateControllerTest {
	
	@Mock
	private RestOperations restOperationsMock;
	
	private MockMvc mockMvc;

	private MvcResult resultService;

	@InjectMocks
	private StateController stateController;
	
	@Mock
	private StateService stateService;
	
	@Before
	public void configure() throws Exception {
		
		List<StateDTO> states = listStateDTO();
		
		when(stateService.findAll()).thenReturn(states);
		
		mockMvc = MockMvcBuilders.standaloneSetup(stateController).build();
	}

	@Test
	public void findAllStateTestSucess() throws Exception {
		
		resultService = mockMvc.perform(MockMvcRequestBuilders.get("/olx/states"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
		assertNotNull(resultService);
	}
	
	@Test(expected=NestedServletException.class)
	public void findCallGroupByCareDayAndUfOrderByCareDayDescException() throws Exception {
		
		doThrow(CallServiceException.class).when(stateService).findAll();
		
		resultService = mockMvc.perform(MockMvcRequestBuilders.get("/olx/states"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
	}


	private List<StateDTO> listStateDTO() {
		List<StateDTO> states = new ArrayList<>();
		StateDTO stateDTO = new StateDTO();
		
		stateDTO.setIdState(1);
		stateDTO.setNome("Rio de Janeiro");
		stateDTO.setUf("RJ");
		
		states.add(stateDTO);
		return states;
	}

}

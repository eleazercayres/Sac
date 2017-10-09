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
import com.olx.sac.sacwebbff.exception.CallServiceException;
import com.olx.sac.sacwebbff.service.AttendanceService;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class AttendanceControllerTest {
	
	@Mock
	private RestOperations restOperationsMock;
	
	private MockMvc mockMvc;

	private MvcResult resultService;

	@InjectMocks
	private AttendanceController attendanceController;
	
	@Mock
	private AttendanceService attendanceService;
	
	@Before
	public void configure() throws Exception {
		
		List<String> reasons = listReasons();
		List<String> types = listTypes();
		List<CallDTO> attendances = listCalls();
		
		when(attendanceService.findAllReasonCalleds()).thenReturn(reasons );
		when(attendanceService.findAllTypeOfCalls()).thenReturn(types);
		when(attendanceService.findCallGroupByCareDayAndUfOrderByCareDayDesc()).thenReturn(attendances );
		
		mockMvc = MockMvcBuilders.standaloneSetup(attendanceController).build();
	}

	@Test
	public void listAttendancesTestSucess() throws Exception {
		
		resultService = mockMvc.perform(MockMvcRequestBuilders.get("/olx/attendances"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
		assertNotNull(resultService);
	}
	
	@Test(expected=NestedServletException.class)
	public void findCallGroupByCareDayAndUfOrderByCareDayDescException() throws Exception {
		
		doThrow(CallServiceException.class).when(attendanceService).findCallGroupByCareDayAndUfOrderByCareDayDesc();
		
		resultService = mockMvc.perform(MockMvcRequestBuilders.get("/olx/attendances"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
	}
	
	@Test
	public void findAllTypeOfCalls() throws Exception {
		
		resultService = mockMvc.perform(MockMvcRequestBuilders.get("/olx/typeCalled"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
		assertNotNull(resultService);
		Assert.assertTrue(resultService.getResponse().getContentAsString().contains("[\"Telefone\",\"Chat\",\"E-mail\"]"));
		
	}
	
	@Test(expected=NestedServletException.class)
	public void findAllTypeOfCallsException() throws Exception {
		
		doThrow(CallServiceException.class).when(attendanceService).findAllTypeOfCalls();
		
		resultService = mockMvc.perform(MockMvcRequestBuilders.get("/olx/typeCalled"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
	}
	
	@Test
	public void findAllreasonCalled() throws Exception {
		
		resultService = mockMvc.perform(MockMvcRequestBuilders.get("/olx/reasonCalled"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
		assertNotNull(resultService);
		Assert.assertTrue(resultService.getResponse().getContentAsString().contains("[\"Elogios\",\"Duvidas\",\"Sugestoes\"]"));
		
	}
	
	@Test(expected=NestedServletException.class)
	public void findAllreasonCalledException() throws Exception {
		
		doThrow(CallServiceException.class).when(attendanceService).findAllReasonCalleds();
		
		resultService = mockMvc.perform(MockMvcRequestBuilders.get("/olx/reasonCalled"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
	}

	private List<CallDTO> listCalls() {
		List<CallDTO> attendances = new ArrayList<>();

		CallDTO callDTO = new CallDTO();
		callDTO.setCareDay(new Date());
		callDTO.setDetails("Details");
		callDTO.setReasonCalled(ReasonCalled.DOUBTS);
		callDTO.setTypeOfCall(TypeOfCall.CHAT);
		callDTO.setUf(new StateDTO());
		
		attendances.add(callDTO);
		
		return attendances;
	}

	private List<String> listTypes() {
		List<String> types = new ArrayList<>();
		types.add("Telefone");
		types.add("Chat");
		types.add("E-mail");
		return types;
	}

	private List<String> listReasons() {
		List<String> reasons = new ArrayList<>();
		reasons.add("Elogios");
		reasons.add("Duvidas");
		reasons.add("Sugestoes");
		return reasons;
	}

}

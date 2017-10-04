package com.olx.sac.sacwebbff.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/olx/")
public class AttendanceController {

	@RequestMapping("/attendances")
	public @ResponseBody List<String> listAlarms() throws Exception {

		List<String> lastSent = null;

		try {

			//logic
			
		} catch (Exception e) {
			throw new Exception(e);
		}

		return lastSent;
	}
}

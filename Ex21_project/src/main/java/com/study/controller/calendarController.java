package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class calendarController {

	@GetMapping("calendarForm")
	public String calendarForm() {
		return "calendar/calendarForm";
	}
}

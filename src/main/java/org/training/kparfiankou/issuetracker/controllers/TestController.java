package org.training.kparfiankou.issuetracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/testController")
@Controller
public class TestController {

	@RequestMapping(method = RequestMethod.GET)
	public String doGet(Model uiModel) {
		return performTask();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String goPost(Model uiModel) {
		return performTask();
	}

	private String performTask(){
		return "test";
	}
}
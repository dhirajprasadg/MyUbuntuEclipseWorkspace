package org.timesheet.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexpagesController {
	@RequestMapping(value= "/", method = RequestMethod.GET)
		public String callindexpage(){
		return "index";
	}

}

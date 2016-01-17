/**
 * 
 */
package com.mysite.fitnesstracker.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Arun J
 *
 */

@Controller
public class HelloController {
	
	private static final Logger logger = Logger.getLogger(HelloController.class);
	
	@RequestMapping("/hello")
	public String sayHello(Model model) {
		logger.info("Entering HelloController.sayHello");
		model.addAttribute("name", "Arun");
		logger.info("Exiting HelloController.sayHello");
		return "hello";
	}

}

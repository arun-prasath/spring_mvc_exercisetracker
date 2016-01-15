/**
 * 
 */
package com.mysite.fitnesstracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Arun J
 *
 */

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String sayHello(Model model) {
		model.addAttribute("name", "Arun");
		return "hello";
	}

}

/**
 * 
 */
package com.mysite.fitnesstracker.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysite.fitnesstracker.model.Exercise;

/**
 * @author Arun J
 *
 */
@Controller
public class MinutesController {

	private static final Logger logger = Logger.getLogger(MinutesController.class);
	
	@RequestMapping("/addMinutes")
	public String addMinutes(@ModelAttribute("exercise") Exercise exercise) {
		logger.info("Entering MinutesController.addMinutes");
		exercise.setMinutes(5);
		logger.info("Exiting MinutesController.addMinutes");
		return "minutes";
	}
}

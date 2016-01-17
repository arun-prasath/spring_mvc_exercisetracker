/**
 * 
 */
package com.mysite.fitnesstracker.controller;

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

	@RequestMapping("/addMinutes")
	public String addMinutes(@ModelAttribute("exercise") Exercise exercise) {
		exercise.setMinutes(5);
		return "minutes";
	}
}

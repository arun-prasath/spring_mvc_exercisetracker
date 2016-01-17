/**
 * 
 */
package com.mysite.fitnesstracker.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mysite.fitnesstracker.model.Goal;

/**
 * @author Arun J
 *
 */

@Controller
@SessionAttributes("goal")
public class GoalController {
	
	private static final Logger logger = Logger.getLogger(GoalController.class);
	
	@RequestMapping(value = "addGoal", method = RequestMethod.GET)
	public String addGoal(Model model) {
		Goal goal = new Goal();
		goal.setMinutes(10);
		model.addAttribute(goal);
		return "goal";
	}
	
	@RequestMapping(value = "addGoal", method = RequestMethod.POST)
	public String submitGoal(@ModelAttribute Goal goal) {
		logger.info(goal.getMinutes());
		return "redirect:addMinutes.html";
	}
	

}

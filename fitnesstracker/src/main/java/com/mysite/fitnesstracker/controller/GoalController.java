/**
 * 
 */
package com.mysite.fitnesstracker.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mysite.fitnesstracker.model.Goal;
import com.mysite.fitnesstracker.service.GoalService;

/**
 * @author Arun J
 *
 */

@Controller
@SessionAttributes("goal")
public class GoalController {
	
	private static final Logger logger = Logger.getLogger(GoalController.class);
	
	@Autowired
	GoalService goalService;
	
	@RequestMapping(value = "addGoal", method = RequestMethod.GET)
	public String addGoal(Model model, HttpSession session) {
		Goal goal = (Goal) session.getAttribute("goal");
		
		if(goal == null) {
			goal = new Goal();
			goal.setMinutes(10);
		}
		
		model.addAttribute(goal);
		return "goal";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') and hasPermission(#goal, 'createGoal')")
	@RequestMapping(value = "addGoal", method = RequestMethod.POST)
	public String submitGoal(@Valid @ModelAttribute Goal goal, BindingResult result) {
		logger.info("Has errors: " + result.hasErrors());
		logger.info(goal.getMinutes());
		
		if(result.hasErrors()) {
			return "goal";
		} else {
			try {
				goalService.saveGoal(goal);
			} catch (Exception e) {
				logger.error("An exception occurred");
				logger.error("Exception message is: " + e.getMessage());
				ObjectError objErr = new ObjectError("ErrorObject", e.getMessage());
				result.addError(objErr);
				return "goal";
			}
		}
		
		return "redirect:addMinutes.html";
	}
	
	@RequestMapping(value = "showGoal", method = RequestMethod.GET)
	public String showGoal(Model model) {
		model.addAttribute("goals", goalService.findAllGoals());
		return "showGoal";
	}
	
	@RequestMapping(value = "goalReports", method = RequestMethod.GET)
	public String goalReports(Model model) {
		model.addAttribute("goalReport", goalService.getGoalReports());
		return "goalReports";
	}
	

}

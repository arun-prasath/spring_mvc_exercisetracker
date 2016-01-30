/**
 * 
 */
package com.mysite.fitnesstracker.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysite.fitnesstracker.model.Activity;
import com.mysite.fitnesstracker.model.Exercise;
import com.mysite.fitnesstracker.model.Goal;
import com.mysite.fitnesstracker.service.ExerciseService;

/**
 * @author Arun J
 *
 */
@Controller
public class MinutesController {
	
	private static final Logger logger = Logger.getLogger(MinutesController.class);
	
	@Autowired
	private ExerciseService exerciseService;

	@RequestMapping("/addMinutes")
	public String getMinutes(@ModelAttribute("exercise") Exercise exercise) {
		exercise.setMinutes(5);
		logger.info(exercise.getMinutes() + " minutes");
		return "minutes";
	}
	
	@RequestMapping(value = "/addMinutes", method = RequestMethod.POST)
	public String addMinutes(@Valid @ModelAttribute("exercise") Exercise exercise, HttpSession session, BindingResult result) {
		if(result.hasErrors()) {
			return "minutes";
		} else {
			Goal goal = (Goal) session.getAttribute("goal");
			exercise.setGoal(goal);
			
			exerciseService.save(exercise);
		}
		return "minutes";
	}
	
	@RequestMapping(value = "/activities", method = RequestMethod.GET)
	public @ResponseBody List<Activity> getAllActivities() {
		List<Activity> activities = new ArrayList<Activity>();
		
		Activity walking = new Activity();
		walking.setActivityName("Walking");
		activities.add(walking);
		
		Activity biking = new Activity();
		biking.setActivityName("Biking");
		activities.add(biking);
		
		Activity swimming = new Activity();
		swimming.setActivityName("Swimming");
		activities.add(swimming);
		
		return activities;
	}
}

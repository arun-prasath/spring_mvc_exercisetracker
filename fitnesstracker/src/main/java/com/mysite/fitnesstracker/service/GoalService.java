package com.mysite.fitnesstracker.service;

import java.util.List;

import com.mysite.fitnesstracker.model.Goal;
import com.mysite.fitnesstracker.model.GoalReport;

public interface GoalService {

	Goal saveGoal(Goal goal);

	List<Goal> findAllGoals();
	
	List<GoalReport> getGoalReports();

}
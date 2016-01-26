package com.mysite.fitnesstracker.repository;

import java.util.List;

import com.mysite.fitnesstracker.model.Goal;
import com.mysite.fitnesstracker.model.GoalReport;

public interface GoalRepository {
	
	Goal saveGoal(Goal goal);

	List<Goal> findAllGoals();
	
	List<GoalReport> getGoalReports();

}

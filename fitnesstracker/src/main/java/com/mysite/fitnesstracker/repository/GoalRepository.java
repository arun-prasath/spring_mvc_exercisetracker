package com.mysite.fitnesstracker.repository;

import java.util.List;

import com.mysite.fitnesstracker.model.Goal;

public interface GoalRepository {
	
	Goal saveGoal(Goal goal);

	List<Goal> findAllGoals();

}

package com.mysite.fitnesstracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.fitnesstracker.model.Goal;
import com.mysite.fitnesstracker.model.GoalReport;
import com.mysite.fitnesstracker.repository.GoalRepository;

@Service
public class GoalServiceImpl implements GoalService {
	
	@Autowired
	private GoalRepository goalRepository;
	
	/* (non-Javadoc)
	 * @see com.mysite.fitnesstracker.service.GoalService#saveGoal(com.mysite.fitnesstracker.model.Goal)
	 */
	@Override
	public Goal saveGoal(Goal goal) {
		return goalRepository.save(goal);
	}

	@Override
	public List<Goal> findAllGoals() {
		return goalRepository.findAll();
	}
	
	@Override
	public List<GoalReport> getGoalReports() {
		return goalRepository.getGoalReports();
	}

}

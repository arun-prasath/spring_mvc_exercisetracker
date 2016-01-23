package com.mysite.fitnesstracker.service;

import org.springframework.stereotype.Service;

import com.mysite.fitnesstracker.model.Goal;

@Service
public class GoalServiceImpl implements GoalService {
	
	/* (non-Javadoc)
	 * @see com.mysite.fitnesstracker.service.GoalService#saveGoal(com.mysite.fitnesstracker.model.Goal)
	 */
	@Override
	public Goal saveGoal(Goal goal) {
		System.out.println(goal.getMinutes());
		return goal;
	}

}

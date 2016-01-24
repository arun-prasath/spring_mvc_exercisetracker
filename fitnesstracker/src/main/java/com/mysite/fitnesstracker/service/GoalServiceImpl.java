package com.mysite.fitnesstracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysite.fitnesstracker.model.Goal;
import com.mysite.fitnesstracker.repository.GoalRepository;

@Service
public class GoalServiceImpl implements GoalService {
	
	@Autowired
	private GoalRepository goalRepository;
	
	/* (non-Javadoc)
	 * @see com.mysite.fitnesstracker.service.GoalService#saveGoal(com.mysite.fitnesstracker.model.Goal)
	 */
	@Override
	@Transactional
	public Goal saveGoal(Goal goal) {
		return goalRepository.saveGoal(goal);
	}

}

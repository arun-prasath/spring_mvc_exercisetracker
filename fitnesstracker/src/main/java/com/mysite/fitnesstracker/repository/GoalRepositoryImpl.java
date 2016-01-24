package com.mysite.fitnesstracker.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mysite.fitnesstracker.model.Goal;

@Repository
public class GoalRepositoryImpl implements GoalRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public Goal saveGoal(Goal goal) {
		try {
			entityManager.persist(goal);
			entityManager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goal;
	}

}

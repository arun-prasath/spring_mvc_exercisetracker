package com.mysite.fitnesstracker.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mysite.fitnesstracker.model.Goal;
import com.mysite.fitnesstracker.model.GoalReport;

@Repository
public class GoalRepositoryImpl implements GoalRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public Goal saveGoal(Goal goal) {
		
		if(goal.getGoalId() == null) {
			entityManager.persist(goal);
			entityManager.flush();
		} else {
			return entityManager.merge(goal);
		}
		
		return goal;
	}

	@Override
	public List<Goal> findAllGoals() {
		TypedQuery<Goal> findGoalsQuery =  entityManager.createNamedQuery(Goal.GET_GOAL, Goal.class);
		return findGoalsQuery.getResultList();
	}

	@Override
	public List<GoalReport> getGoalReports() {
		TypedQuery<GoalReport> goalReportQuery =  entityManager.createNamedQuery(Goal.GET_GOAL_REPORTS, GoalReport.class);
		return goalReportQuery.getResultList();
	}
}

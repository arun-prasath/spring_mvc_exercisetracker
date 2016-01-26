package com.mysite.fitnesstracker.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
		entityManager.persist(goal);
		entityManager.flush();
		return goal;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Goal> findAllGoals() {
		String findGoalsQueryStr = "from Goal";
		Query findGoalsQuery = entityManager.createQuery(findGoalsQueryStr);
		return findGoalsQuery.getResultList();
	}

	@Override
	public List<GoalReport> getGoalReports() {
		String goalReportQueryStr = "select new com.mysite.fitnesstracker.model.GoalReport(e.minutes, g.minutes) "
			 + "from Goal g, Exercise e";
		Query goalReportQuery = entityManager.createQuery(goalReportQueryStr);
		return goalReportQuery.getResultList();
	}
}

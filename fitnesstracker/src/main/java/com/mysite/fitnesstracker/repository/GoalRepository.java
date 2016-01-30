package com.mysite.fitnesstracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mysite.fitnesstracker.model.Goal;
import com.mysite.fitnesstracker.model.GoalReport;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {
	
	@Query("select new com.mysite.fitnesstracker.model.GoalReport(e.minutes, g.minutes) "
			 + "from Goal g, Exercise e")
	List<GoalReport> getGoalReports();

}

/**
 * 
 */
package com.mysite.fitnesstracker.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

/**
 * @author Arun J
 *
 */

@Entity
@Table(name="goals")
public class Goal {
	
	public static final String GET_GOAL_REPORTS = "getGoalReports";
	public static final String GET_GOAL = "getGoal";

	@Id
	@GeneratedValue
	@Column(name="GOAL_ID")
	private Long goalId;

	@Column(name="MINUTES")
	@Range(min = 1, max = 120)
	private int minutes;
	
	@OneToMany(mappedBy="goal", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Exercise> exercise = new ArrayList<Exercise>();

	public Long getGoalId() {
		return goalId;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setGoalId(Long goalId) {
		this.goalId = goalId;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public List<Exercise> getExercise() {
		return exercise;
	}

	public void setExercise(List<Exercise> exercise) {
		this.exercise = exercise;
	}

}

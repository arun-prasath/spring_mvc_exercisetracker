package com.mysite.fitnesstracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Exercise {

	@Id
	@GeneratedValue
	@Column(name="EXERCISE_ID")
	private long exerciseId;
	
	@ManyToOne
	@JoinColumn(name="GOAL_ID")
	private Goal goal;
	
	@Column(name="MINUTES")
	private int minutes;

	public long getExerciseId() {
		return exerciseId;
	}

	public Goal getGoal() {
		return goal;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setExerciseId(long exerciseId) {
		this.exerciseId = exerciseId;
	}

	public void setGoal(Goal goal) {
		this.goal = goal;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
}

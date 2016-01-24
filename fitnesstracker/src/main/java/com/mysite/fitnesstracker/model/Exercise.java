package com.mysite.fitnesstracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Exercise {

	@Id
	@GeneratedValue
	@Column(name="EXERCISE_ID")
	private long exerciseId;
	
	private int minutes;

	public long getExerciseId() {
		return exerciseId;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setExerciseId(long exerciseId) {
		this.exerciseId = exerciseId;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
}

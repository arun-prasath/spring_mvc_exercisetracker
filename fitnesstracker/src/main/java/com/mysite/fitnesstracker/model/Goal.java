/**
 * 
 */
package com.mysite.fitnesstracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Range;

/**
 * @author Arun J
 *
 */

@Entity
public class Goal {

	@Id
	@GeneratedValue
	@Column(name="GOAL_ID")
	private Long goalId;

	@Column(name="MINUTES")
	@Range(min = 1, max = 120)
	private int minutes;

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

}

/**
 * 
 */
package com.mysite.fitnesstracker.model;

/**
 * @author Arun J
 *
 */
public class GoalReport {
	
	private int exerciseMinutes;
	private int goalMinutes;
	
	public GoalReport() {}
	
	public GoalReport(int exerciseMinutes, int goalMinutes) {
		this.exerciseMinutes = exerciseMinutes;
		this.goalMinutes = goalMinutes;
	}
	
	public int getExerciseMinutes() {
		return exerciseMinutes;
	}
	public int getGoalMinutes() {
		return goalMinutes;
	}
	public void setExerciseMinutes(int exerciseMinutes) {
		this.exerciseMinutes = exerciseMinutes;
	}
	public void setGoalMinutes(int goalMinutes) {
		this.goalMinutes = goalMinutes;
	}

}

/**
 * 
 */
package com.mysite.fitnesstracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.fitnesstracker.model.Exercise;
import com.mysite.fitnesstracker.repository.ExerciseRepository;

/**
 * @author Arun J
 *
 */
@Service
public class ExerciseServiceImpl implements ExerciseService {
	
	@Autowired
	private ExerciseRepository exerciseRepository;

	/* (non-Javadoc)
	 * @see com.mysite.fitnesstracker.service.ExerciseService#saveExercise(com.mysite.fitnesstracker.model.Exercise)
	 */
	@Override
	public Exercise saveExercise(Exercise exercise) {
		return exerciseRepository.saveExercise(exercise);
	}
}

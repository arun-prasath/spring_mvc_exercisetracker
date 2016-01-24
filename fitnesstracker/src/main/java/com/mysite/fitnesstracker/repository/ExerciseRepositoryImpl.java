/**
 * 
 */
package com.mysite.fitnesstracker.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mysite.fitnesstracker.model.Exercise;

/**
 * @author Arun J
 *
 */
@Repository
public class ExerciseRepositoryImpl implements ExerciseRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see com.mysite.fitnesstracker.repository.ExerciseRepository#saveExercise(com.mysite.fitnesstracker.model.Exercise)
	 */
	@Override
	@Transactional
	public Exercise saveExercise(Exercise exercise) {
		entityManager.persist(exercise);
		entityManager.flush();
		return exercise;
	}

}

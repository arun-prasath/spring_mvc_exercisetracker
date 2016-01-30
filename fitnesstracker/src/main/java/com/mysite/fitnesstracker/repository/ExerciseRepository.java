/**
 * 
 */
package com.mysite.fitnesstracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mysite.fitnesstracker.model.Exercise;

/**
 * @author Arun J
 *
 */
@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

}

package by.ninjas.gymuniverse.gymms.persistence.repositories;

import by.ninjas.gymuniverse.gymms.persistence.entities.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * JPA repository for working with {@link Exercise}.
 *
 * @author Artyom Drobysh (artyom.drobysh96@gmail.com)
 * @version 0.2.0
 * @since 0.2.0
 */
public interface ExerciseRepository extends JpaRepository<Exercise, Short> {

    /**
     * Find all exercises with fetched muscle groups.
     *
     * @return {@link List} of {@link Exercise}
     * @since 0.2.0
     */
    @Query("""
        SELECT e
          FROM Exercise e
            LEFT JOIN FETCH e.muscleGroups
        """)
    List<Exercise> findAllWithMuscleGroups();

    /**
     * Find exercises with the corresponding muscle group.
     *
     * @return {@link List} of {@link Exercise}
     * @since 0.2.0
     */
    @Query("""
        SELECT e
          FROM Exercise e
            LEFT JOIN FETCH e.muscleGroups mg
            WHERE mg.muscleGroupId = ?1
        """)
    List<Exercise> findAllByMuscleGroupId(short muscleGroupId);
}

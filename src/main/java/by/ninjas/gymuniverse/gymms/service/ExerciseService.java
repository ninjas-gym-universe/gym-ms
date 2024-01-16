package by.ninjas.gymuniverse.gymms.service;

import by.ninjas.gymuniverse.gymms.dto.ExerciseData;
import by.ninjas.gymuniverse.gymms.persistence.entities.Exercise;
import by.ninjas.gymuniverse.gymms.persistence.entities.MuscleGroup;

import java.util.List;

/**
 * Service for working with {@link Exercise}.
 *
 * @author dziomin
 * @version 0.2.0
 * @since 0.2.0
 */
public interface ExerciseService {

    /**
     * Fetch all of {@link Exercise} by given {@link MuscleGroup}
     *
     * @param muscleGroupId id of muscleGroup
     * @return {@link List} of {@link Exercise}
     * @since 0.2.0
     */
    List<ExerciseData> findAllByMuscleGroupId(short muscleGroupId);

}

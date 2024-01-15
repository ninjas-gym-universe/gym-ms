package by.ninjas.gymuniverse.gymms.service;

import by.ninjas.gymuniverse.gymms.dto.MuscleGroupData;
import by.ninjas.gymuniverse.gymms.persistence.entities.MuscleGroup;

import java.util.List;

/**
 * Service for working with {@link MuscleGroup}.
 *
 * @author dziomin
 * @version 0.2.0
 * @since 0.2.0
 */
public interface MuscleGroupsService {

    /**
     * Fetch all of {@link MuscleGroupData}
     *
     * @return List of {@link MuscleGroupData}
     * @since 0.2.0
     */
    List<MuscleGroupData> findAll();

}

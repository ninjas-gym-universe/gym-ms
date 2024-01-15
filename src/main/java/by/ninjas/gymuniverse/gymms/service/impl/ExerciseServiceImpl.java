package by.ninjas.gymuniverse.gymms.service.impl;

import by.ninjas.gymuniverse.gymms.dto.ExerciseData;
import by.ninjas.gymuniverse.gymms.persistence.entities.MuscleGroup;
import by.ninjas.gymuniverse.gymms.persistence.repositories.ExerciseRepository;
import by.ninjas.gymuniverse.gymms.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * JPA service implementation for working with {@link MuscleGroup}.
 *
 * @author dziomin
 * @version 0.2.0
 * @since 0.2.0
 */
@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;

    @Override
    public List<ExerciseData> findAllByMuscleGroupId(short muscleGroupId) {
        return exerciseRepository.findAllByMuscleGroupsMuscleGroupId(muscleGroupId).stream()
            .map(ExerciseData::new).toList();
    }
}

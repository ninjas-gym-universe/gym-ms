package by.ninjas.gymuniverse.gymms.service.impl;

import by.ninjas.gymuniverse.gymms.dto.MuscleGroupData;
import by.ninjas.gymuniverse.gymms.persistence.entities.MuscleGroup;
import by.ninjas.gymuniverse.gymms.persistence.repositories.MuscleGroupRepository;
import by.ninjas.gymuniverse.gymms.service.MuscleGroupsService;
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
public class MuscleGroupsServiceImpl implements MuscleGroupsService {

    private final MuscleGroupRepository muscleGroupRepository;

    @Override
    public List<MuscleGroupData> findAll() {
        return muscleGroupRepository.findAll().stream()
            .map(MuscleGroupData::new).toList();
    }
}

package by.ninjas.gymuniverse.gymms.persistence.repositories;

import by.ninjas.gymuniverse.gymms.persistence.entities.ExerciseResource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repository for working with {@link ExerciseResource}.
 *
 * @author dziomin
 * @version 0.2.0
 * @since 0.2.0
 */
public interface ExerciseResourceRepository extends JpaRepository<ExerciseResource, Short> {

}

package by.ninjas.gymuniverse.gymms.persistence.repositories;

import by.ninjas.gymuniverse.gymms.persistence.embeddable.ExerciseMuscleGroup;
import by.ninjas.gymuniverse.gymms.persistence.entities.Exercise;
import by.ninjas.gymuniverse.gymms.testutils.EmbeddedPostgres;
import by.ninjas.gymuniverse.gymms.testutils.slices.DbTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for {@link ExerciseRepository}.
 *
 * @author Artyom Drobysh (artyom.drobysh96@gmail.com)
 * @version 0.2.0
 * @since 0.2.0
 */
@DbTest
@Sql(scripts = "classpath:sql/exercises-with-muscle-groups.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
@Sql(scripts = "classpath:sql/clear-all.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_CLASS)
class ExerciseRepositoryTests extends EmbeddedPostgres {

    @Autowired
    ExerciseRepository repository;

    @Test
    void findAllWithMuscleGroups() {
        var actual = repository.findAllWithMuscleGroups();

        assertAll(
            () -> assertEquals(3, actual.size()),
            () -> assertThat(actual)
                .extracting(Exercise::getId, Exercise::getName)
                .containsExactlyInAnyOrder(
                    tuple((short) 1, "bench press"),
                    tuple((short) 2, "standing dumbbell fly"),
                    tuple((short) 3, "high pull")),
            () -> assertThat(actual)
                .flatExtracting(Exercise::getMuscleGroups)
                .containsExactlyInAnyOrder(
                    new ExerciseMuscleGroup((short) 2, (short) 100),
                    new ExerciseMuscleGroup((short) 3, (short) 30),
                    new ExerciseMuscleGroup((short) 3, (short) 40),
                    new ExerciseMuscleGroup((short) 4, (short) 100))
        );
    }

    @Test
    void findAllByMuscleGroupId() {
        var actual = repository.findAllByMuscleGroupsMuscleGroupId((short) 3);

        assertAll(
            () -> assertEquals(2, actual.size()),
            () -> assertThat(actual)
                .extracting(Exercise::getId, Exercise::getName)
                .containsExactlyInAnyOrder(
                    tuple((short) 1, "bench press"),
                    tuple((short) 2, "standing dumbbell fly")),
            () -> assertThat(actual)
                .flatExtracting(Exercise::getMuscleGroups)
                .containsExactlyInAnyOrder(
                    new ExerciseMuscleGroup((short) 3, (short) 30),
                    new ExerciseMuscleGroup((short) 3, (short) 40))
        );
    }

}

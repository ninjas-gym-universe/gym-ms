package by.ninjas.gymuniverse.gymms.persistence.repositories;

import by.ninjas.gymuniverse.gymms.persistence.entities.MuscleGroup;
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
 * Tests for {@link MuscleGroupRepository}.
 *
 * @author dziomin
 * @version 0.2.0
 * @since 0.2.0
 */
@DbTest
@Sql("classpath:sql/muscle-groups.sql")
class MuscleGroupsRepositoryTests extends EmbeddedPostgres {

    @Autowired
    MuscleGroupRepository repository;

    @Test
    void findAllMuscleGroups() {
        var actual = repository.findAll();

        assertAll(
            () -> assertEquals(5, actual.size()),
            () -> assertThat(actual)
                .extracting(MuscleGroup::getId, MuscleGroup::getName)
                .containsExactlyInAnyOrder(
                    tuple((short) 1, "shoulders"),
                    tuple((short) 2, "chest"),
                    tuple((short) 3, "anterior delta"),
                    tuple((short) 4, "average delta"),
                    tuple((short) 5, "rear delta"))
        );
    }
}

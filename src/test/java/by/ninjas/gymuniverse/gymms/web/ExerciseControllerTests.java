package by.ninjas.gymuniverse.gymms.web;

import by.ninjas.gymuniverse.gymms.dto.ExerciseData;
import by.ninjas.gymuniverse.gymms.persistence.embeddable.ExerciseMuscleGroup;
import by.ninjas.gymuniverse.gymms.persistence.entities.Exercise;
import by.ninjas.gymuniverse.gymms.service.ExerciseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;

import static net.javacrumbs.jsonunit.spring.JsonUnitResultMatchers.json;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests for {@link MuscleGroupController}.
 *
 * @author dziomin
 * @version 0.2.0
 * @since 0.2.0
 */

@ActiveProfiles("test")
@WebMvcTest(controllers = ExerciseController.class)
class ExerciseControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ExerciseService exerciseService;
    @Autowired
    private ResourceLoader resourceLoader;

    @Test
    void findAllMuscleGroups() throws Exception {
        ExerciseMuscleGroup exerciseMuscleGroup = new ExerciseMuscleGroup((short) 3, (short) 33);
        Exercise testExercise = new Exercise();
        testExercise.setId((short) 1);
        testExercise.setName("test");
        testExercise.setMuscleGroups(Set.of(exerciseMuscleGroup));

        when(exerciseService.findAllByMuscleGroupId((short) 3)).thenReturn(List.of(new ExerciseData(testExercise)));
        mockMvc.perform(get("/exercises").param("muscleGroupId", "3"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(json().isEqualTo(resourceLoader.getResource("classpath:json/exercise-controller.json").getContentAsString(StandardCharsets.UTF_8)));
    }
}

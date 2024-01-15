package by.ninjas.gymuniverse.gymms.web;

import by.ninjas.gymuniverse.gymms.dto.ExerciseData;
import by.ninjas.gymuniverse.gymms.dto.ExerciseMuscleGroupData;
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
        when(exerciseService.findAllByMuscleGroupId((short) 3)).thenReturn(List.of(
            new ExerciseData((short) 1, "test", Set.of(new ExerciseMuscleGroupData((short) 3, (short) 33)))));

        mockMvc.perform(get("/exercise").param("muscleGroupId", "3"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(json().isEqualTo(resourceLoader.getResource("classpath:json/exercise-controller.json").getContentAsString(StandardCharsets.UTF_8)));
    }
}

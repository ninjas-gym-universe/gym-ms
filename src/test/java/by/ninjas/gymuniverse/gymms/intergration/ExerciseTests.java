package by.ninjas.gymuniverse.gymms.intergration;

import by.ninjas.gymuniverse.gymms.persistence.entities.Exercise;
import by.ninjas.gymuniverse.gymms.testutils.EmbeddedPostgres;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;

import static net.javacrumbs.jsonunit.spring.JsonUnitResultMatchers.json;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Integration tests for {@link Exercise}.
 *
 * @author dziomin
 * @version 0.2.0
 * @since 0.2.0
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(value = "classpath:sql/exercises-with-muscle-groups.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
@Sql(scripts = "classpath:sql/clear-all.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_CLASS)
class ExerciseTests extends EmbeddedPostgres {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ResourceLoader resourceLoader;

    @Test
    void findAllMuscleGroups() throws Exception {

        mockMvc.perform(get("/exercise").param("muscleGroupId", "3"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(json().isArray())
            .andExpect(json().isEqualTo(resourceLoader.getResource("classpath:json/exercise-integration.json").getContentAsString(StandardCharsets.UTF_8)));
    }
}

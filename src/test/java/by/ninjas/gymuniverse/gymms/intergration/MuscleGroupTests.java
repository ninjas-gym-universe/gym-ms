package by.ninjas.gymuniverse.gymms.intergration;

import by.ninjas.gymuniverse.gymms.persistence.entities.MuscleGroup;
import by.ninjas.gymuniverse.gymms.testutils.EmbeddedPostgres;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;

import static net.javacrumbs.jsonunit.spring.JsonUnitResultMatchers.json;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Integration tests for {@link MuscleGroup}.
 *
 * @author dziomin
 * @version 0.2.0
 * @since 0.2.0
 */
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql("classpath:sql/muscle-groups.sql")
class MuscleGroupTests extends EmbeddedPostgres {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ResourceLoader resourceLoader;

    @Test
    void findAllMuscleGroups() throws Exception {

        mockMvc.perform(get("/muscle-groups"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(json().isArray())
            .andExpect(json().isEqualTo(resourceLoader.getResource("classpath:json/muscle-groups-integration.json").getContentAsString(StandardCharsets.UTF_8)));
    }
}

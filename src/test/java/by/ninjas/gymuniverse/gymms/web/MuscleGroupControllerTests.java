package by.ninjas.gymuniverse.gymms.web;

import by.ninjas.gymuniverse.gymms.dto.MuscleGroupData;
import by.ninjas.gymuniverse.gymms.service.MuscleGroupsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;
import java.util.List;

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
@WebMvcTest(controllers = MuscleGroupController.class)
class MuscleGroupControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MuscleGroupsService muscleGroupsService;
    @Autowired
    private ResourceLoader resourceLoader;

    @Test
    void findAllMuscleGroups() throws Exception {
        when(muscleGroupsService.findAll()).thenReturn(List.of(
            new MuscleGroupData((short) 1, "test", null),
            new MuscleGroupData((short) 2, "test2", new MuscleGroupData((short) 1, "test", null))));

        mockMvc.perform(get("/muscle-groups"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(json().isEqualTo(resourceLoader.getResource("classpath:json/muscle-groups.json").getContentAsString(StandardCharsets.UTF_8)));
//            .andExpect(content().json(resourceLoader.getResource("classpath:json/muscle-groups.json").getContentAsString(StandardCharsets.UTF_8)));
    }
}

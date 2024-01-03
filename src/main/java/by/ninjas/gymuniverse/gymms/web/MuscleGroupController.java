package by.ninjas.gymuniverse.gymms.web;

import by.ninjas.gymuniverse.gymms.dto.MuscleGroupData;
import by.ninjas.gymuniverse.gymms.service.MuscleGroupsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Muscle group controller.
 *
 * @author dziomin
 * @version 0.2.0
 * @since 0.2.0
 */

@Tag(name = "API for muscle group")
@RestController
@RequiredArgsConstructor
@RequestMapping("/muscle-groups")
public class MuscleGroupController {

    private final MuscleGroupsService muscleGroupsService;

    /**
     * Gets all muscle groups
     *
     * @return {@link List} of {@link MuscleGroupData}
     * @since 0.2.0
     */
    @Operation(
        summary = "Get all muscle groups",
        responses = @ApiResponse(
            responseCode = "200",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = MuscleGroupData.class)))))
    @GetMapping
    public List<MuscleGroupData> getAllMuscleGroups() {
        return muscleGroupsService.findAll();
    }

}

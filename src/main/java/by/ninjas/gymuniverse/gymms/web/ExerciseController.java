package by.ninjas.gymuniverse.gymms.web;

import by.ninjas.gymuniverse.gymms.dto.ExerciseData;
import by.ninjas.gymuniverse.gymms.persistence.entities.Exercise;
import by.ninjas.gymuniverse.gymms.service.ExerciseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Exercise controller.
 *
 * @author dziomin
 * @version 0.2.0
 * @since 0.2.0
 */

@Tag(name = "API for exercise")
@RestController
@RequiredArgsConstructor
@RequestMapping("/exercises")
public class ExerciseController {

    private final ExerciseService exerciseService;

    /**
     * Get exercise list by given muscle group
     *
     * @return {@link List} of {@link Exercise}
     * @since 0.2.0
     */
    @Operation(
        summary = "Get exercise list by given muscle group",
        responses = @ApiResponse(
            responseCode = "200",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = ExerciseData.class)))))
    @GetMapping
    public List<ExerciseData> getAllMuscleGroups(@Parameter(description = "Muscle group id", required = true) @RequestParam short muscleGroupId) {
        return exerciseService.findAllByMuscleGroupId(muscleGroupId);
    }

}

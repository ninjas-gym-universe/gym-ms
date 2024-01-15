package by.ninjas.gymuniverse.gymms.dto;

import by.ninjas.gymuniverse.gymms.persistence.embeddable.ExerciseMuscleGroup;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serial;
import java.io.Serializable;

/**
 * DTO for representing exerciseMuscleGroups data
 *
 * @author dziomin
 * @version 0.2.0
 * @since 0.2.0
 */
@Schema(name = "ExerciseMuscleGroup data")
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ExerciseMuscleGroupData(
    @Schema(description = "ExerciseMuscleGroup data", requiredMode = Schema.RequiredMode.REQUIRED) short muscleGroupId,
    @Schema(description = "MuscleGroup percentage for exercise", requiredMode = Schema.RequiredMode.NOT_REQUIRED) Short percentage) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public ExerciseMuscleGroupData(ExerciseMuscleGroup entity) {
        this(entity.muscleGroupId(),
            entity.percentage());
    }
}

package by.ninjas.gymuniverse.gymms.dto;

import by.ninjas.gymuniverse.gymms.persistence.embeddable.ExerciseMuscleGroup;
import by.ninjas.gymuniverse.gymms.persistence.entities.Exercise;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * DTO for representing exercise data
 *
 * @author dziomin
 * @version 0.2.0
 * @since 0.2.0
 */
@Schema(name = "Exercise data")
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ExerciseData(
    @Schema(description = "Exercise id", requiredMode = Schema.RequiredMode.REQUIRED) short id,
    @Schema(description = "Exercise name", requiredMode = Schema.RequiredMode.REQUIRED) String name,
    @Schema(description = "MuscleGroup data", requiredMode = Schema.RequiredMode.NOT_REQUIRED) List<MuscleGroup> muscleGroups) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public ExerciseData(Exercise entity) {
        this(entity.getId(),
            entity.getName(),
            entity.getMuscleGroups() != null ? entity.getMuscleGroups().stream().map(MuscleGroup::new).toList() : null);
    }

    /**
     * DTO for representing exerciseMuscleGroups data
     *
     * @author dziomin
     * @version 0.2.0
     * @since 0.2.0
     */
    @Schema(name = "ExerciseMuscleGroup data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    record MuscleGroup(
        @Schema(description = "ExerciseMuscleGroup data", requiredMode = Schema.RequiredMode.REQUIRED) short muscleGroupId,
        @Schema(description = "MuscleGroup percentage for exercise", requiredMode = Schema.RequiredMode.NOT_REQUIRED) Short percentage) implements Serializable {

        @Serial
        private static final long serialVersionUID = 1L;

        MuscleGroup(ExerciseMuscleGroup entity) {
            this(entity.muscleGroupId(),
                entity.percentage());
        }
    }
}

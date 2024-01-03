package by.ninjas.gymuniverse.gymms.dto;

import by.ninjas.gymuniverse.gymms.persistence.entities.MuscleGroup;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serial;
import java.io.Serializable;

/**
 * DTO for representing muscle group data
 *
 * @author dziomin
 * @version 0.2.0
 * @since 0.2.0
 */
@Schema(name = "Muscle group data")
@JsonInclude(JsonInclude.Include.NON_NULL)
public record MuscleGroupData(
    @Schema(description = "Muscle group id", requiredMode = Schema.RequiredMode.REQUIRED) short id,
    @Schema(description = "Muscle group name", requiredMode = Schema.RequiredMode.REQUIRED) String name,
    @Schema(
        description = "Muscle group parent",
        requiredMode = Schema.RequiredMode.NOT_REQUIRED) MuscleGroupData parent) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public MuscleGroupData(MuscleGroup entity) {
        this(entity.getId(),
            entity.getName(),
            entity.getParent() != null ? new MuscleGroupData(entity.getParent()) : null);
    }
}

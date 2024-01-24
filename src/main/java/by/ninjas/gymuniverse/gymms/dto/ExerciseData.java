package by.ninjas.gymuniverse.gymms.dto;

import by.ninjas.gymuniverse.gymms.persistence.embeddable.ExerciseMuscleGroup;
import by.ninjas.gymuniverse.gymms.persistence.entities.Exercise;
import by.ninjas.gymuniverse.gymms.persistence.entities.ExerciseResource;
import by.ninjas.gymuniverse.gymms.persistence.enums.FileExtension;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
    @Schema(description = "MuscleGroup data", requiredMode = Schema.RequiredMode.NOT_REQUIRED) List<MuscleGroup> muscleGroups,
    @Schema(description = "ExerciseResource data", requiredMode = Schema.RequiredMode.NOT_REQUIRED) List<Resource> resources) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public ExerciseData(Exercise entity) {
        this(entity.getId(),
            entity.getName(),
            entity.getMuscleGroups() != null ? entity.getMuscleGroups().stream().map(MuscleGroup::new).toList() : null,
            entity.getResources() != null ? entity.getResources().stream().map(Resource::new).toList() : null);
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

    /**
     * DTO for representing exerciseResources data
     *
     * @author dziomin
     * @version 0.2.0
     * @since 0.2.0
     */
    @Schema(name = "ExerciseResource data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    record Resource(
        @Schema(description = "ExerciseResource content data", requiredMode = Schema.RequiredMode.REQUIRED) byte[] content,
        @Schema(description = "ExerciseResource fileName", requiredMode = Schema.RequiredMode.REQUIRED) String fileName,
        @Schema(description = "ExerciseResource fileExtension", requiredMode = Schema.RequiredMode.REQUIRED) FileExtension fileExtension) implements Serializable {

        @Serial
        private static final long serialVersionUID = 1L;

        Resource(ExerciseResource entity) {
            this(entity.getContent(),
                entity.getFileName(),
                entity.getFileExtension());
        }

        @Override
        public boolean equals(Object obj) {
            return obj == this || (obj instanceof Resource other &&
                                   Arrays.equals(content, other.content) &&
                                   Objects.equals(fileName, other.fileName) &&
                                   Objects.equals(fileExtension, other.fileExtension));
        }

        @Override
        public int hashCode() {
            return Objects.hash(Arrays.hashCode(content), fileName, fileExtension);
        }

        @Override
        public String toString() {
            return """
                content = %s
                fileName = %s
                fileExtension = %s
                """.formatted(Arrays.toString(content), fileName, fileExtension);
        }
    }

}

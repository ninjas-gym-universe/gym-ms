package by.ninjas.gymuniverse.gymms.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serial;
import java.io.Serializable;

/**
 * DTO for representing muscle group data
 *
 * @author dziomin
 * @version 0.2.0
 * @since 0.2.0
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public record MuscleGroupDto(
    Short id,
    String name,
    MuscleGroupDto parent) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}

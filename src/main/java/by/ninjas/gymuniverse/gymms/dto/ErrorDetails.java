package by.ninjas.gymuniverse.gymms.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serial;
import java.io.Serializable;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * Data with error details.
 *
 * @param message message
 * @author Artyom Drobysh (artyom.drobysh96@gmail.com)
 * @version 0.2.0
 * @since 0.2.0
 */
@JsonInclude(NON_NULL)
public record ErrorDetails(String message) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}

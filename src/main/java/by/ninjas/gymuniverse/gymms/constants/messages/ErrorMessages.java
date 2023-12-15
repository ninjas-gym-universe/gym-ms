package by.ninjas.gymuniverse.gymms.constants.messages;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

/**
 * Constants for error message keys.
 *
 * @author Artyom Drobysh (artyom.drobysh96@gmail.com)
 * @version 0.2.0
 * @since 0.2.0
 */
@NoArgsConstructor(access = PRIVATE)
public final class ErrorMessages {

    /**
     * Technical exception.
     *
     * @since 0.2.0
     */
    public static final String TECHNICAL = "technical";
    /**
     * Invalid client request exception.
     *
     * @since 0.2.0
     */
    public static final String INVALID_REQUEST = "invalid-request";
    /**
     * No such resource exception.
     *
     * @since 0.2.0
     */
    public static final String NO_SUCH_RESOURCE = "no-such-resource";
}

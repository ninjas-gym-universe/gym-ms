package by.ninjas.gymuniverse.gymms.exceptions;

import lombok.Getter;

/**
 * Represent that resource is not exist.
 *
 * @author Artyom Drobysh (artyom.drobysh96@gmail.com)
 * @version 0.2.0
 * @since 0.2.0
 */
@Getter
public class NoSuchResourceException extends RuntimeException {

    private final Object resource;

    public NoSuchResourceException(Object resource) {
        super("resource %s is not found".formatted(resource));
        this.resource = resource;
    }
}

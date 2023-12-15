package by.ninjas.gymuniverse.gymms.configs.handlers;

import by.ninjas.gymuniverse.gymms.dto.ErrorDetails;
import by.ninjas.gymuniverse.gymms.exceptions.InvalidRequestException;
import by.ninjas.gymuniverse.gymms.exceptions.NoSuchResourceException;
import by.ninjas.gymuniverse.gymms.exceptions.TechnicalException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static by.ninjas.gymuniverse.gymms.constants.messages.ErrorMessages.INVALID_REQUEST;
import static by.ninjas.gymuniverse.gymms.constants.messages.ErrorMessages.NO_SUCH_RESOURCE;
import static by.ninjas.gymuniverse.gymms.constants.messages.ErrorMessages.TECHNICAL;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * Web exception handler.
 *
 * @author Artyom Drobysh (artyom.drobysh96@gmail.com)
 * @version 0.2.0
 * @since 0.2.0
 */
@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class WebExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    /**
     * Handle {@link NoSuchResourceException}.
     * Return {@link HttpStatus#NOT_FOUND}.
     *
     * @param ex      {@link NoSuchResourceException}
     * @param request {@link WebRequest}
     * @return {@link ErrorDetails}
     * @since 0.2.0
     */
    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NoSuchResourceException.class)
    public ErrorDetails handleNoSuchResourceException(NoSuchResourceException ex, WebRequest request) {
        log.error("resource not found : " + ex.getResource(), ex);
        return new ErrorDetails(messageSource.getMessage(NO_SUCH_RESOURCE, new Object[]{ ex.getResource()}, request.getLocale()));
    }

    /**
     * Handle {@link InvalidRequestException}.
     * Return {@link HttpStatus#BAD_REQUEST}.
     *
     * @param ex      {@link InvalidRequestException}
     * @param request {@link WebRequest}
     * @return {@link ErrorDetails}
     * @since 0.2.0
     */
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(InvalidRequestException.class)
    public ErrorDetails handleInvalidRequestException(InvalidRequestException ex, WebRequest request) {
        log.error("client request is invalid", ex);
        return new ErrorDetails(messageSource.getMessage(INVALID_REQUEST, null, request.getLocale()));
    }

    /**
     * Handle {@link TechnicalException}.
     * Return {@link HttpStatus#INTERNAL_SERVER_ERROR}.
     *
     * @param ex      {@link TechnicalException}
     * @param request {@link WebRequest}
     * @return {@link ErrorDetails}
     * @since 0.2.0
     */
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(TechnicalException.class)
    public ErrorDetails handleTechnicalException(TechnicalException ex, WebRequest request) {
        log.error("technical exception", ex);
        return new ErrorDetails(messageSource.getMessage(TECHNICAL, null, request.getLocale()));
    }
}

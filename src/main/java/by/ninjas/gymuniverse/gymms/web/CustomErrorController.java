package by.ninjas.gymuniverse.gymms.web;

import by.ninjas.gymuniverse.gymms.dto.ErrorDetails;
import by.ninjas.gymuniverse.gymms.exceptions.InvalidRequestException;
import by.ninjas.gymuniverse.gymms.exceptions.TechnicalException;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static jakarta.servlet.RequestDispatcher.ERROR_STATUS_CODE;

/**
 * Custom error controller.
 * Handle <b>/error</b> path.
 * <br><br>
 * <b>Note:</b> disabled for Open doc.
 *
 * @author Artyom Drobysh (artyom.drobysh96@gmail.com)
 * @version 0.2.0
 * @since 0.2.0
 */
@Hidden
@RestController
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public ResponseEntity<ErrorDetails> handleException(HttpServletRequest request) {
        int statusCode = Integer.parseInt(request.getAttribute(ERROR_STATUS_CODE).toString());
        HttpStatus status = HttpStatus.valueOf(statusCode);
        return switch (status) {
            case BAD_REQUEST -> throw new InvalidRequestException();
            case INTERNAL_SERVER_ERROR -> throw new TechnicalException();
            default -> ResponseEntity.status(status).body(new ErrorDetails("unknown error"));
        };
    }
}

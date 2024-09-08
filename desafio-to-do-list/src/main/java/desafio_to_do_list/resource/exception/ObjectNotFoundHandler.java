package desafio_to_do_list.resource.exception;

import desafio_to_do_list.service.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ObjectNotFoundHandler {

    @ExceptionHandler({ObjectNotFoundException.class})
    public ResponseEntity <StandardError> resourceNotFound (ObjectNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        String error = "Resource not found";
        StandardError err = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}

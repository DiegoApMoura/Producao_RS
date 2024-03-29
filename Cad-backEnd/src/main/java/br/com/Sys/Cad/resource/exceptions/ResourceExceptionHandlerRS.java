package br.com.Sys.Cad.resource.exceptions;

import br.com.Sys.Cad.services.exceptions.DatabaseExceptionRS;
import br.com.Sys.Cad.services.exceptions.EntityNotFoundExceptionRS;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandlerRS {
    @ExceptionHandler(DatabaseExceptionRS.class)
    public ResponseEntity<StandardErrorRS>database(DatabaseExceptionRS e, HttpServletRequest request){
        StandardErrorRS err = new StandardErrorRS();
        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setError("Exceção de erro na base de dados!");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(EntityNotFoundExceptionRS.class)
    public ResponseEntity<StandardErrorRS>EntityNotFoundRS(EntityNotFoundExceptionRS e, HttpServletRequest request){
        StandardErrorRS err = new StandardErrorRS();
        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setError("Requisição não encontrada!");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}

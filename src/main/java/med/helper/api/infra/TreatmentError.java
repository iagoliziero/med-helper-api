package med.helper.api.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TreatmentError {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity treatmentError404() {
        return ResponseEntity.notFound().build();
    }
}

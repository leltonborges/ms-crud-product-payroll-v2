package org.ms.payroll.payroll.exceptions;

import org.ms.payroll.payroll.services.exceptions.NotFoundProductPayroll;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class PayrollExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundProductPayroll.class)
    public ResponseEntity<StandarError> notFoundProductPayrol(NotFoundProductPayroll ex, HttpServletRequest request){
        StandarError err =
                new StandarError(HttpStatus.NOT_FOUND, ex.getMessage(),
                        "Not found", System.currentTimeMillis(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}

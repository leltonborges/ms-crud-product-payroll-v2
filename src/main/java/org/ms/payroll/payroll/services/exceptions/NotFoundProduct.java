package org.ms.payroll.payroll.services.exceptions;


public class NotFoundProduct extends RuntimeException{
    public NotFoundProduct(String message) {
        super(message);
    }

    public NotFoundProduct(Throwable cause) {
        super(cause);
    }
}

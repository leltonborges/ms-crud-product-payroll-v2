package org.ms.payroll.payroll.services.exceptions;

import java.io.Serial;
import java.io.Serializable;

public class NotFoundProductPayroll extends RuntimeException implements Serializable {
    @Serial
    private static final long serialVersionUID = 8101943756770234552L;

    public NotFoundProductPayroll(String message) {
        super(message);
    }

    public NotFoundProductPayroll(String message, Throwable cause) {
        super(message, cause);
    }
}

package org.ms.payroll.payroll.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class StandarError implements Serializable {
    @Serial
    private static final long serialVersionUID = 6231992409790035399L;
    private HttpStatus status;
    private String message;
    private String error;
    private Long timestamp;
    private String path;

}

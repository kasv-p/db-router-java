package com.example.dbrouter.exceptions;

import com.example.dbrouter.enums.ErrorCode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
public class ApplicationException extends Exception {
    private int errorCode;
    private String errorDescription;

    public ApplicationException(int errorCode, String errorDescription) {
        super(errorDescription);
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }

    public ApplicationException(ErrorCode errorCode) {
        super(errorCode.getDescription());
        this.errorCode = errorCode.getCode();
        this.errorDescription = errorCode.getDescription();
    }


    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class Application400Exception extends ApplicationException {
        private int statusCode;
        private String errorDescription;

        public Application400Exception(String errorDescription) {
            super(400, errorDescription);
        }

    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class Application500Exception extends ApplicationException {
        private int statusCode;
        private String errorDescription;

        public Application500Exception(String errorDescription) {
            super(500, errorDescription);
        }

    }



}

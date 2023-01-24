package com.example.dw_1.exception;

public class WrongLoginCredentialException extends Throwable {
    private static final long serialVersionUID = 1L;
    private final Integer code;

    public WrongLoginCredentialException(Integer code) {
        /**
         * code = 0 -> ok
         * code = 1 -> error */
        this.code = code;
    }
    public Integer getCode() {
        return this.code;
    }
}


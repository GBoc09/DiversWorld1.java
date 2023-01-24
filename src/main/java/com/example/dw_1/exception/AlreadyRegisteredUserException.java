package com.example.dw_1.exception;

public class AlreadyRegisteredUserException extends Exception{
    private static final long serialVersionUID = 1L;
    private final Integer code;

    /**
     *
     * @param code Integer
     *             0 = no execption
     *             1 = email already used
     */
    public AlreadyRegisteredUserException(Integer code){
        this.code = code;
    }
    public Integer getCode () {
        return code;
    }

}

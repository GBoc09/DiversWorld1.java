package com.example.dw_1.exception;

public class AlreadyRegisteredEquipException extends Throwable{
    private static final long serialVersionUID = 1L;
    private final Integer code;

        /**
         *
         * @param code Integer
         *             0 = no exception
         *             1 = diving already inserted
         */
        public AlreadyRegisteredEquipException(Integer code){
            this.code = code;
        }
        public Integer getCode () {
            return code;
        }
}

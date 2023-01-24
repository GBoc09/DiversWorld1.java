package com.example.dw_1.controllerGrafico;

public class ProfileManagementGraphicControl {
    private static final Integer MIN_PASS_LENGHT = 8;
    private static final Integer MAX_PASS_LENGHT = 16;

    private static final Character[] forbiddenChar = {' ', '\t', '\n', '/', '\\', '|', '<', '>',
            '=', '?', '!', '#', '(', ')'};

    private static final String[] allowedChar = {"ABCDEFGHJKLMNOPQRSTUVWXYZ",
            "abcdefghijklmnopqrstuvwxyz",
            "0123456789",
            "@.$&£"};
    public static Integer getMinPassLenght(){
        return MIN_PASS_LENGHT;
    }
    public static Integer getMaxPassLenght(){
        return MAX_PASS_LENGHT;
    }

    public static Character[] getForbiddenChar() {
        return forbiddenChar;
    }
    public static String[] getAllowedChar(){
        return allowedChar;
    }
}

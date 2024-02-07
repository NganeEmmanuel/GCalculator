package com.gcalculator.gcalculator.service;

public class InputValidator {
    public static boolean isDouble(String value){
        try {
            Double.parseDouble(value);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}

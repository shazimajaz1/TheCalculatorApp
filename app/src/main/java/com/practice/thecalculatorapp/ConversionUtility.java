package com.practice.thecalculatorapp;

public class ConversionUtility {

    public static NumberProcessor numberStringToProcessor(int value){
        //Build a new number processor by enclosing each value into a number
        NumberProcessor numberProcessor = new NumberProcessor();

        String stringValue = String.valueOf(value);
        for(int i = 0 ; i < stringValue.length(); i++){
            int number = stringValue.charAt(i);
            number = number - 48;
            numberProcessor.put(number);

        }

        return numberProcessor;

    }
}

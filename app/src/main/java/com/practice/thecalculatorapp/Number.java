package com.practice.thecalculatorapp;

/*
    This class holds an integer value that is a single digit.
    Throws an exception if the user tries to add more than on digit.
 */
public class Number {
    /*
        Field variables
     */
    private int number;

    /*
        Main constructor: The value must be a single digit.
     */
    public Number(int value) {

        if(value > 9){
            throw new IllegalArgumentException("Only single digit numbers are accepted.");
        } else {
            this.number = value;
        }
    }

    /*
        toString: This method returns the value of the number in integer
     */
    public String toString() {
        return String.valueOf(number);
    }

    /*
        Getter method: Returns the value in integer format
     */
    public int get() {
        return number;
    }
}

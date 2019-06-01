package com.practice.thecalculatorapp;

import java.util.ArrayList;

/*
    This class uses Number class as an array.
    The array of numbers is kept in an array list.
    The operations on various Number arrays can be performed by calling the appropriate method.
 */
public class NumberProcessor {
    /*
        Field variables: Array of values
     */
    private ArrayList<Number> numbers;
    private boolean negative = false; //1 means negative and 0 means positive

    /*
        Main Constructor:
     */
    public NumberProcessor(ArrayList<Number> numbers, boolean negative) {
        this.numbers = numbers;
        this.negative = negative;
    }

    /*
        Default Constructor
     */
    public NumberProcessor(){
        numbers = new ArrayList<>();
    }

    /*
       Setter: put a new Number to the array list
     */
    public void put(Number number){
        numbers.add(number);
    }

    /*
        Setter: put a new Number in the array list: int
     */
    public void put(int number){
        if(number <= 9)
            numbers.add(new Number(number));
        else
            throw new IllegalArgumentException("Only single digit numbers are accepted");
    }

    /*
        Returns the array list that contains the numbers
     */
    public ArrayList<Number> get(){
        return numbers;
    }

    /*
        Add two numbers: This adds two numbers: One is the number in the object on which
        the method is called one and the other is the number is the object that is passed as
        a parameter
     */
    public int add(NumberProcessor numberProcessor2){
        //Get first number
        int number1 = decode(numbers);

        //Get second number
        int number2 = decode(numberProcessor2.get());

        //Add both numbers
        int sum = number1 + number2;

        //Return the sum
        return sum;
    }

    /*
        This is a helper method that decodes the value of the ArrayList<Number>
        and returns the result in an integer.
     */
    private int decode(ArrayList<Number> numbers) {
        //Extract the number from the list
        int listSize = numbers.size();
        String stringValue = "";
        for(int i = 0; i < listSize; i++){
            //Get the value at i.
            int number = (numbers.get(i)).get();
            //Get the integer value
            stringValue += number;

        }

        return Integer.valueOf(stringValue);
    }

    /*
        Return the values as an integer
     */
    public int getNumbersAsInteger() {
        return decode(numbers);
    }

    /*
        Subtracts the number in the parameter from the number object that the method is being
        called on.
     */
    public int sub(NumberProcessor numberProcessor2){
        //Get the first number
        int number1 = decode(numbers);

        //Get the second number
        int number2 = decode(numberProcessor2.get());

        //Subtract the second number from the first number
        int result = number1 - number2;

        //Return the result
        return result;
    }

    /*
        Divides numbers 1 by number 2, where number 1 is the object on which divide is being
        called on and number 2 is the object passed as a parameter.
     */
    public int divide(NumberProcessor numberProcessor2){
        //Get the first number
        int number1 = decode(numbers);

        //Get the second number
        int number2 = decode(numberProcessor2.get());

        //Divide the first number by the second number
        int result;
        if(number2 != 0) {
            result = number1 / number2;
        } else {
            throw new IllegalArgumentException("Cannot divide the number by 0");
        }

        //return the result
        return result;
    }

    /*
        Multiplies number1 by number2, where number1 is from the calling object and number2 is from
        the passed object
     */
    public int multiply(NumberProcessor numberProcessor2){
        //Get both numbers
        int number1 = decode(numbers);
        int number2 = decode(numberProcessor2.get());

        //Return the result
        return number1 * number2;
    }

    /*
       Percent operation: finds the percentage of the number.
       The number is in the original object and the percentage is in the passed object
     */
    public int percentage(NumberProcessor numberProcessor2){
        //Decode both numbers
        int number1 = decode(numbers);
        int percentage = decode(numberProcessor2.get());

        percentage /= 100;

        return Math.abs(number1 * percentage);
    }

    /*
        This changes the sign of the value
     */
    public void setNegative(boolean negative){
        this.negative = negative;
    }

    /*
        Getter: returns if the number is negative or not
     */
    public boolean isNegative(){
        return negative;
    }


}

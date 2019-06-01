package com.practice.thecalculatorapp;

/*
    This class selects the operations as provided.
    All fields are boolean
    Only one field can be true at a time.
    The supported operations are
    1. Add
    2. Sub
    3. Divide
    4. Multiply
    5. Percent
 */
public class OperationSelector {

    /*
        Field variables: Changes based on the operation is selected
        initially all are false
     */
    private boolean add, sub, div, mul, per;

    /*
        Main Constructor: all the values are initially set to false
     */
    public OperationSelector(){
        resetValues();
    }

    /*
        This is a helper method that reset all the values to false;
     */
    public void resetValues() {
        this.add = false;
        this.sub = false;
        this.div = false;
        this.mul = false;
        this.per = false;
    }

    /*
        Setter Methods: Set the values to true or false, ensure that no more than one value is
        true at once.
     */
    /*
        Select add operation
     */
    public void selectAdd(){
        resetValues();
        this.add = true;
    }

    /*
        Select sub operation
     */
    public void selectSub(){
        resetValues();
        this.sub = true;
    }

    /*
        Select divide operation
     */
    public void selectDiv(){
        resetValues();
        this.div = true;
    }

    /*
        set mul operation
     */
    public void selectMul() {
        resetValues();
        this.mul = true;
    }

    public void selectPer() {
        resetValues();
        this.per = true;
    }

    /*
        This method returns the operation that is selected
     */
    public String getOperationSelected() {
        //Find out which operation is selected
        if(add) return "ADD";
        else if(sub) return "SUB";
        else if(div) return "DIV";
        else if(mul) return "MUL";
        else if(per) return "PER";
        else return "NONE";

    }
}

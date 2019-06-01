package com.practice.thecalculatorapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/*
    This class implements the button listeners and their actions.
 */
public class MainActivity extends AppCompatActivity {

    private NumberProcessor numberProcessor;
    private TextView numberField;
    private OperationSelector operationSelector;
    private NumberProcessor currentNumberProcessor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setup the views
        numberField = findViewById(R.id.number_edit_text);

        //Setup the number processor
        numberProcessor = new NumberProcessor();

        //Setup the operation selector
        operationSelector = new OperationSelector();

    }

    /*
        These methods are invoked when their appropriate buttons are touched.
        There are two types of buttons:
        1. Value Buttons
        2. Operation Buttons
     */
    public void btnC(View view) {
        numberField.setText("");
        numberProcessor = new NumberProcessor();
        currentNumberProcessor = numberProcessor;
    }

    public void btn7(View view) {
        numberField.append("7");
    }

    public void btn4(View view) {
        numberField.append("4");
    }

    public void btn1(View view) {
        numberField.append("1");
    }

    public void btn8(View view) {
        numberField.append("8");
    }

    public void btn5(View view) {
        numberField.append("5");
    }

    public void btn2(View view) {
        numberField.append("2");
    }

    public void btn0(View view) {
        numberField.append("0");
    }

    public void btn9(View view) {
        numberField.append("9");
    }

    public void btn6(View view) {
        numberField.append("6");
    }

    public void btn3(View view) {
        numberField.append("3");
    }

    /*
        This method when called, reverses the sign of the numbers
     */
    public void btnSign(View view) {
        if (numberProcessor.isNegative()) {
            numberProcessor.setNegative(false);
        }
        else {
            numberProcessor.setNegative(true);
            numberField.setText(("-" + numberField.getText().toString()));
        }
    }

    /*
        This method adds the braces with a single button, if there there is
        an unclosed brace, it closed that brace first.
     */
    public void btnBraces(View view) {
        //TODO: implement a new class for this method that deals with the issue of putting braces
    }


    /*
        This method when called, calculates the percentage of two numbers
     */
    public void btnPercent(View view) {
        //When the percent is clicked, clear the field
        String text = numberField.getText().toString();
        numberProcessor = ConversionUtility.numberStringToProcessor(Integer.valueOf(text));
        operationSelector.selectPer();
        clearField();
    }

    /*
        Set the operation as divide
     */
    public void btnDivide(View view) {
        String text = numberField.getText().toString();
        numberProcessor = ConversionUtility.numberStringToProcessor(Integer.valueOf(text));
        operationSelector.selectDiv();
        clearField();
    }

    /*
        Set the operation as mul
     */
    public void btnMUL(View view) {
        String text = numberField.getText().toString();
        numberProcessor = ConversionUtility.numberStringToProcessor(Integer.valueOf(text));
        operationSelector.selectMul();
        clearField();
    }

    /*
        Set the operation as subtract
     */
    public void btnMINUS(View view) {
        String text = numberField.getText().toString();
        numberProcessor = ConversionUtility.numberStringToProcessor(Integer.valueOf(text));
        operationSelector.selectSub();
        clearField();
    }

    /*
        Set the operation as plus
     */
    public void btnPLUS(View view) {
        String text = numberField.getText().toString();
        numberProcessor = ConversionUtility.numberStringToProcessor(Integer.valueOf(text));
        operationSelector.selectAdd();
        clearField();

    }

    /*
        Clear Field method: This is a helper method that clears the field and saves the data from the
        last field
     */
    public void clearField() {
        //Clear the field
        numberField.setText("");

        //Save the data from the current field
        currentNumberProcessor = numberProcessor;



    }

    /*
        This method adds the functionality of dealing with decimal number. It is invoked when he decimal
        button is clicked.
     */

    public void btnDecimal(View view) {
        //TODO: Add functionality to support decimals
    }


    /*
        The queued operation is done when the equal button is clicked
     */
    public void btnEQUAL(View view) {
        currentNumberProcessor = ConversionUtility.numberStringToProcessor(Integer.valueOf(numberField.getText().toString()));
        //Get the operation
        String operationSelected = operationSelector.getOperationSelected();
        int result = 0;
        switch (operationSelected) {
            case "ADD":
                result = numberProcessor.add(currentNumberProcessor);

                break;

            case "SUB":
                //Get the second number and do the calculation
                result = numberProcessor.sub(currentNumberProcessor);
                break;
            case "DIV":


                break;
            case "MUL":


                break;
            case "PER":


                break;
            case "NONE":

                //Do nothing
                break;
        }
        //Get the result in String
        //Update the text field
        numberField.setText(String.valueOf(result));
        //Updating the current processor with new value
        currentNumberProcessor = ConversionUtility.numberStringToProcessor(result);


    }
}

package Advanced_Scientifique_Calculator;

import static Advanced_Scientifique_Calculator.__View.*;

import java.text.DecimalFormat;

public class __Model {

    private static boolean firstDigit = true;  // Mark whether the user pressed the first number of the entire expression, or the first number after the operator
    private static double resultNum = 0.0000;   // intermediate result of calculation
    private static String operator = "=";   // The operator of the current operation (you need to restore it to "=" when you press "C")
    private static boolean operateValidFlag = true;   // Determine whether the operation is legal

    public static void pressBackspace() {
        String text = resultText.getText();
        int i = text.length();
        if (i > 0) {
            text = text.substring(0, i - 1);  // Backspace, remove the last character of the text
            if (text.length() == 0) {
                // If the text has no content, initialize the various values ​​of the calculator
                resultText.setText("0");
                firstDigit = true;
                operator = "=";
            } else {
                // display new text
                resultText.setText(text);
            }
        }
    }

    /**
           * Handle the event that the C key is pressed
     */
    public static void pressC() {
        // Initialize various values ​​of the calculator
        resultText.setText("0");
        firstDigit = true;
        operator = "=";
    }

    /**
           * Handle the event that the number key is pressed
     */
    public static void pressNumber(String key) {
        if (firstDigit) {
            // The input is the first number
            resultText.setText(key);
        } else if ((key.equals(".")) && (!resultText.getText().contains("."))) {
            // The input is a decimal point, and there is no decimal point before, the decimal point will be attached to the back of the result text box
            resultText.setText(resultText.getText() + ".");
        } else if (!key.equals(".")) {
            // If the input is not a decimal point, append the number to the back of the result text box
            resultText.setText(resultText.getText() + key);
        }
        firstDigit = false;
    }

    /**
           * Handle the event that the operator key is pressed
     */
    //Only a number of operations
    public static void singleOperator(String key) {
        operator = key;  // The operator is the button pressed by the user
        switch (operator) {
            case "1⁄x":
                // reciprocal operation
                if (resultNum == 0) {
                    operateValidFlag = false;  //The operation is illegal
                    resultText.setText("Zero has no countdown");
                } else {
                    resultNum = 1 / getNumberFromText();
                    omitDecimal(resultNum);
                }
                break;
            case "√x":
                // Square root operation
                if (resultNum < 0) {
                    operateValidFlag = false;  //The operation is illegal
                    resultText.setText("The root sign cannot be negative");
                } else {
                    resultNum = Math.sqrt(getNumberFromText());
                    omitDecimal(resultNum);
                }
                break;
            case "x²":
                // Square operation
                resultNum = getNumberFromText() * getNumberFromText();
                omitDecimal(resultNum);
                break;
            case "%":
                // Percent sign operation, divide by 100
                resultNum = getNumberFromText() / 100;
                resultText.setText(String.valueOf(resultNum));
                break;
            case "+/-":
                // Positive and negative operations
                resultNum = getNumberFromText() * (-1);
                if (operateValidFlag) {
                    // When the operation is legal, the result is a decimal with 4 digits after the decimal point, and the integer is output normally
                    omitDecimal(resultNum);
                }
                firstDigit = true;
                operateValidFlag = true;
                break;
        }
    }

    //Need two operations
    public static void doubleOperator(String key) {
        switch (operator) {
            case "÷":
                // Division operation
                // If the value in the current result text box is equal to 0
                if (getNumberFromText() == 0.0) {
                    operateValidFlag = false;  //The operation is illegal
                    resultText.setText("Divisor cannot be zero");
                } else {
                    resultNum /= getNumberFromText();
                }
                break;
            case "+":
                // addition operation
                resultNum += getNumberFromText();
                break;
            case "-":
                // subtraction operation
                resultNum -= getNumberFromText();
                break;
            case "×":
                // multiplication
                resultNum *= getNumberFromText();
                break;
            case "=":
                // Assignment operation
                resultNum = getNumberFromText();
                break;
        }
        omitDecimal(resultNum);
        operator = key;  // The operator is the button pressed by the user
        firstDigit = true;
        operateValidFlag = true;
    }

    public static void omitDecimal(double resultNum) {
        long t1;
        double t2;
        t1 = (long) resultNum;
        t2 = resultNum - t1;
        if (t2 == 0) {
            resultText.setText(String.valueOf(t1));
        } else {
            resultText.setText(String.valueOf(new DecimalFormat("0.00000000").format(resultNum)));
        }
    }

    /**
           * Get the number from the result text box
     */
    public static double getNumberFromText() {
        double result = 0;
        try {
            result = Double.parseDouble(resultText.getText());
        } catch (NumberFormatException ignored) {
        }
        return result;
    }


}

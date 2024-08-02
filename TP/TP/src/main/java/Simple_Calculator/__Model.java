package Simple_Calculator;

import static Simple_Calculator.__View.resultText;

import java.text.DecimalFormat;

public class __Model {

    private static boolean firstDigit = true;  // Mark whether the user pressed the first number of the entire expression, or the first number after the operator
    private static double resultNum = 0.0000;   // intermediate result of calculation
    private static String operator = "=";   // The operator of the current operation (you need to restore it to "=" when you press "C")
    private static boolean operateValidFlag = true;   // Determine whether the operation is legal



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

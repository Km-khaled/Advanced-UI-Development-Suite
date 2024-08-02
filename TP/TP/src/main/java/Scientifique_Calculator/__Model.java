package Scientifique_Calculator;

import static Scientifique_Calculator.__View.*;

import java.text.DecimalFormat;

public class __Model {

     static boolean firstDigit = true;  // Mark whether the user pressed the first number of the entire expression, or the first number after the operator
     static double resultNum = 0.0000;   // intermediate result of calculation
     static String operator = "=";   // The operator of the current operation (you need to restore it to "=" when you press "C")
     static boolean operateValidFlag = true;   // Determine whether the operation is legal
     static boolean binary = false;   // Determine whether the operation is binary or not

     static int t = 0; // Determine whether the operation is binary or not
     private static String num1 = null; // First operand for binary operations

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
        if (binary==true) {
            // Convert operands to binary and perform operation in binary
        	
        	if (num1 == null) {
        		 num1 = String.valueOf(resultNum);
            } 
        	
        	String	num2 = String.valueOf(getNumberFromText());

         	num1 = num1.replaceAll("\\.0$", ""); 
      	  num2 =num2.replaceAll("\\.0$", "");
      	  
            String result = null;
            switch (operator) {
                case "+":
                	
               

                     result = add(num1,num2);
                	
             
                    break;
                case "-":
                    result = subtract(num1,num2);

                    break;
                case "*":
     
                    result = multiply(num1,num2);

                    break;
                case "/":

                    result = divide(num1,num2);

                    break;
            }
            resultText.setText(result);
        } else {
            omitDecimal(resultNum);
        }
        operator = key;  // The operator is the button pressed by the user
        firstDigit = true;
        operateValidFlag = true;
    }

    
    
    public static  String add(String a, String b) {
    	
    	

   

    	long num1 = Long.parseLong(a, 2);
        long num2 = Long.parseLong(b, 2);
        long difference = num1 + num2;
        return Long.toBinaryString(difference);
    }
    
    
    public static String subtract(String a, String b) {
        long num1 = Long.parseLong(a, 2);
        long num2 = Long.parseLong(b, 2);
        long difference = num1 - num2;
        return Long.toBinaryString(difference);
    }

    public static String multiply(String a, String b) {
        long num1 = Long.parseLong(a, 2);
        long num2 = Long.parseLong(b, 2);
        long product = num1 * num2;
        return Long.toBinaryString(product);
    }

    public  static String divide(String a, String b) {
        long num1 = Long.parseLong(a, 2);
        long num2 = Long.parseLong(b, 2);
        long quotient = num1 / num2;
        return Long.toBinaryString(quotient);
//        return Double.toString(quotient);

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

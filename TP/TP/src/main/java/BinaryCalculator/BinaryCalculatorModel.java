package BinaryCalculator;

public class BinaryCalculatorModel {
	
	


	    public int getDecimalPlaces(double number) {
	        int decimalPlaces = 0;
	        while (number % 1 != 0) {
	            number *= 10;
	            decimalPlaces++;
	        }
	        return decimalPlaces;
	    }
	
	
	
	    public  String add(String a, String b) {
	        long num1 = Long.parseLong(a, 2);
	        long num2 = Long.parseLong(b, 2);
	        long sum = num1 + num2;
	        return Long.toBinaryString(sum);
	    }
	    
	    
	    public String subtract(String a, String b) {
	        long num1 = Long.parseLong(a, 2);
	        long num2 = Long.parseLong(b, 2);
	        long difference = num1 - num2;
	        return Long.toBinaryString(difference);
	    }

	    public String multiply(String a, String b) {
	        long num1 = Long.parseLong(a, 2);
	        long num2 = Long.parseLong(b, 2);
	        long product = num1 * num2;
	        return Long.toBinaryString(product);
	    }

	    public String divide(String a, String b) {
	        long num1 = Long.parseLong(a, 2);
	        long num2 = Long.parseLong(b, 2);
	        long quotient = num1 / num2;
	        return Long.toBinaryString(quotient);
//	        return Double.toString(quotient);

	    }

	
}
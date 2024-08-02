package Scientifique_Calculator;

import static Scientifique_Calculator.__Model.*;
import static Scientifique_Calculator.__View.*;

public class __Controller {
	public static void addListener() {
	    // Add event listeners for each button
	    for (int i = 0; i < keys.length; i++) {
	        buttons[i].addActionListener(e -> {
	            String command = e.getActionCommand();
	            if ("0123456789.".contains(command)) {
	                // The user pressed the number key or the decimal point key
	                pressNumber(command);
	            } else if (command.equals("Binary")) {
	                // The user clicked on the Binary button
	                for (int j = 0; j < keys.length; j++) {
	                    if (!"01+-/*=Decimal".contains(keys[j])) {
	                        buttons[j].setEnabled(false);
	                    }
	                }
	                binary = true;
	                __Model.binary = true; // Set binary attribute in __Model class to true
	            } else if (command.equals("Decimal")) {
	                // The user clicked on the Decimal button
	                for (int j = 0; j < keys.length; j++) {
	                    buttons[j].setEnabled(true);
	                }
	                binary = false;
	                __Model.binary = false; // Set binary attribute in __Model class to false
	            } else {
	                doubleOperator(command);
	            }
	        });
	    }
	}
}

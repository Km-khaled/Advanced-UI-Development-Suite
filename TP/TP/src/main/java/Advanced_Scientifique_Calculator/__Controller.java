package Advanced_Scientifique_Calculator;

import static Advanced_Scientifique_Calculator.__Model.*;
import static Advanced_Scientifique_Calculator.__View.*;

public class __Controller {
    public static void addListener() {
        // Add event listeners for each button
        for (int i = 0; i < keys.length; i++) {
            buttons[i].addActionListener(e -> {
                String command = e.getActionCommand();  // Get event source
                if (command.equals(keys[3])) {
                    // The user pressed the "Back" key
                    pressBackspace();
                } else if (command.equals(keys[1])) {
                    // The user pressed the "CE" key
                    resultText.setText("0");
                } else if (command.equals(keys[2])) {
                    // The user pressed the "C" key
                    pressC();
                } else if ("0123456789.".contains(command)) {
                    // The user pressed the number key or the decimal point key
                    pressNumber(command);
                } else if (command.equals(keys[0]) || command.equals(keys[4]) || command.equals(keys[5]) || command.equals(keys[6]) || command.equals(keys[20])) {
                    // The user presses the arithmetic key that only needs one number (see the reciprocal, %, square root, square, take positive and negative numbers)
                    singleOperator(command);
                } else {
                    doubleOperator(command);
                }
            });
        }
    }

}

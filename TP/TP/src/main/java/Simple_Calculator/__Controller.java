package Simple_Calculator;

import static Simple_Calculator.__Model.doubleOperator;
import static Simple_Calculator.__Model.pressNumber;
import static Simple_Calculator.__View.buttons;
import static Simple_Calculator.__View.keys;

public class __Controller {
    public static void addListener() {
        // Add event listeners for each button
        for (int i = 0; i < keys.length; i++) {
            buttons[i].addActionListener(e -> {
                String command = e.getActionCommand();  // Get event source
      if ("0123456789.".contains(command)) {
                    // The user pressed the number key or the decimal point key
                    pressNumber(command);
      }else {
                    doubleOperator(command);
                }
            });
        }
    }

}

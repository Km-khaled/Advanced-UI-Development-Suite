package Scientifique_Calculator;

import static Scientifique_Calculator.__Controller.addListener;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class __View {
    public static JFrame frame = new JFrame();
    public final static String[] keys = {"Binary","","","Decimal","9","8","7","/","6","5","4","*","3","2","1","-","","0",".","+","","","","="};
    public static MyButton[] buttons = new MyButton[keys.length];  //Button on the calculator
    public static JTextField resultText = new JTextField("0");  //Display the calculation result text box

    public __View() {
        init();  // Initialize the calculator
        addListener();
    }

    /**
           * Initialize the calculator
     */
    private void init() {
        Color color1 = new Color(200, 200, 200);  //background color
        Color color2 = new Color(140, 140, 140);  //Equal sign exclusive color
        Color color3 = new Color(230, 230, 230);  //Function key and operator color
        Color color4 = new Color(240, 240, 240);  //Digital color
        // Create a drawing board and place the text box
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        textPanel.add(resultText);
        resultText.setFont(new Font("Kai body", Font.BOLD, 42));  //Set the font and size of the text in the text box, bold
        resultText.setHorizontalAlignment(JTextField.RIGHT);  //The content in the text box is right aligned
        resultText.setEditable(false);  //Cannot modify the result text box
        resultText.setBorder(null);  //Delete the border of the text box
        // Set the background color of the text box
        resultText.setBackground(color1);
        // Initialize the button on the calculator and place the button in a drawing board
        JPanel keysPanel = new JPanel();
        // Using a grid layout, a grid of 6 rows and 4 columns, the horizontal and vertical spacing between the grids is 2 pixels
        keysPanel.setLayout(new GridLayout(6, 4, 2, 2));
        //Initialize function button
        for (int i = 0; i < 8; i++) {
            buttons[i] = new MyButton(keys[i], color3);
            keysPanel.add(buttons[i]);
            buttons[i].setBackground(color3);
            buttons[i].setForeground(Color.black);
            buttons[i].setFont(new Font(Font.SERIF, Font.PLAIN, 18));
            buttons[i].setBorderPainted(false);  //Remove the border of the button
        }
        //Initialize operator and number key button
        for (int i = 8; i < keys.length; i++) {
            if ((i + 1) % 4 == 0) buttons[i] = new MyButton(keys[i], color3);
            else buttons[i] = new MyButton(keys[i], color4);
            keysPanel.add(buttons[i]);
            buttons[i].setForeground(Color.black);
            buttons[i].setFont(new Font(Font.SERIF, Font.PLAIN, 18));
            buttons[i].setBorderPainted(false);  //Remove the border of the button
        }
        buttons[16].setBackground(color2);  //'=' symbol key uses special color
        keysPanel.setBackground(color1);
        //Place the panel where the text box is located in the north and the keysPanel panel in the middle of the calculator
        frame.getContentPane().add("North", textPanel);
        frame.getContentPane().add("Center", keysPanel);
        //Set the borders of the two panels, try to restore the win10 calculator
        textPanel.setBorder(BorderFactory.createMatteBorder(25, 3, 1, 3, color1));
        keysPanel.setBorder(BorderFactory.createMatteBorder(6, 3, 3, 3, color1));
        ImageIcon imageIcon=new ImageIcon("1.ico");
        frame.setIconImage(imageIcon.getImage());
        frame.setTitle("Simple_Calculator");
        frame.setSize(360, 450);
        frame.setLocation(500, 300);
        frame.setResizable(true);  // Allow to modify the size of the calculator window
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}


package BinaryCalculator;

import java.awt.event.ActionListener;

import javax.swing.*;

public class BinaryCalculatorView {
	public JFrame frame;
    public JTextField firstNumberField;
    public JTextField secondNumberField;
    
    public JTextField resultField;
    public JButton addButton;
    public JButton subtractButton;
    public JButton multiplyButton;
    public JButton divideButton;

    public BinaryCalculatorView() {
        frame = new JFrame("Binary Calculator");
        frame.setSize(300, 300);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        firstNumberField = new JTextField();
        JLabel label1 = new JLabel("Enter first binary number");

//        firstNumberField.setText("Enter first binary number");
        frame.add(label1);
        frame.add(firstNumberField);
        secondNumberField = new JTextField();
        JLabel label2 = new JLabel("Enter second binary number");
        frame.add(label2);

//        secondNumberField.setText("Enter second binary number");
        frame.add(secondNumberField);
        JLabel label3 = new JLabel("Result");
        frame.add(label3);

        resultField = new JTextField();
        resultField.setEditable(false);
        frame.add(resultField);
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        frame.add(addButton);
        frame.add(subtractButton);
        frame.add(multiplyButton);
        frame.add(divideButton);
        frame.setVisible(true);
    }

    public String getFirstNumber() {
        return firstNumberField.getText();
    }

    public String getSecondNumber() {
        return secondNumberField.getText();
    }

    public void setResult(String result) {
        resultField.setText(result);
    }

    public void addAdditionListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    public void addSubtractionListener(ActionListener listener) {
        subtractButton.addActionListener(listener);
    }

    public void addMultiplicationListener(ActionListener listener) {
        multiplyButton.addActionListener(listener);
    }

    public void addDivisionListener(ActionListener listener) {
        divideButton.addActionListener(listener);
    }
}
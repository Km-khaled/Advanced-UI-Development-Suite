package BinaryCalculator;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
public class BinaryCalculatorController {
    private BinaryCalculatorView view;
    private BinaryCalculatorModel model;

    public BinaryCalculatorController(BinaryCalculatorView view, BinaryCalculatorModel model) {
        this.view = view;
        this.model = model;

        view.addAdditionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstNumber = view.getFirstNumber();
                String secondNumber = view.getSecondNumber();
                String result = model.add(firstNumber, secondNumber);
                view.setResult(result);
            }
        });

        view.addSubtractionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstNumber = view.getFirstNumber();
                String secondNumber = view.getSecondNumber();
                String result = model.subtract(firstNumber, secondNumber);
                view.setResult(result);
            }
        });

        view.addMultiplicationListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstNumber = view.getFirstNumber();
                String secondNumber = view.getSecondNumber();
                String result = model.multiply(firstNumber, secondNumber);
                view.setResult(result);
            }
        });

        view.addDivisionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstNumber = view.getFirstNumber();
                String secondNumber = view.getSecondNumber();
                String result = model.divide(firstNumber, secondNumber);
                view.setResult(result);
            }
        });
    }
}
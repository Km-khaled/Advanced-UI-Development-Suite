package BinaryCalculator;

public class BinaryCalculator {
    public static void main(String[] args) {
        BinaryCalculatorView view = new BinaryCalculatorView();
        BinaryCalculatorModel model = new BinaryCalculatorModel();
        BinaryCalculatorController controller = new BinaryCalculatorController(view, model);
    }
}
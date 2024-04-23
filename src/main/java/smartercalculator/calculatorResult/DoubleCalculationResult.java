package pao.blsalin.smartercalculator.calculatorResult;

import pao.blsalin.smartercalculator.CalculationRequest;

public class DoubleCalculationResult extends AbstractCalculationResult {
    public DoubleCalculationResult(CalculationRequest request) {
        super(request);
    }

    @Override
    public Object computeResult() {
        CalculationRequest request = getRequest();
        Double leftOperand = (Double) request.getLeftOperand();
        Double rightOperand = (Double) request.getRightOperand();

        return switch (request.getOperation()) {
            case "+" -> leftOperand + rightOperand;
            case "-" -> leftOperand - rightOperand;
            case "*" -> leftOperand * rightOperand;
            case "/" -> leftOperand / rightOperand;
            default -> throw new IllegalArgumentException();
        };
    }
}

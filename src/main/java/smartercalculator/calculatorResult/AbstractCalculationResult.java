package pao.blsalin.smartercalculator.calculatorResult;

import pao.blsalin.smartercalculator.CalculationRequest;

public abstract class AbstractCalculationResult implements CalculationResult {
    private final CalculationRequest request;

    public AbstractCalculationResult(CalculationRequest request) {
        this.request = request;
    }

    @Override
    public CalculationRequest getRequest() {
        return request;
    }
}

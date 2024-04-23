package pao.blsalin.smartercalculator.calculatorResult;

import pao.blsalin.smartercalculator.CalculationRequest;

public interface CalculationResult {
    Object computeResult();
    CalculationRequest getRequest();
}

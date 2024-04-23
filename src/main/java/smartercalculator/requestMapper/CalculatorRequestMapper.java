package pao.blsalin.smartercalculator.requestMapper;

import pao.blsalin.smartercalculator.CalculationRequest;

import java.util.Optional;

public interface CalculatorRequestMapper {
    Optional<CalculationRequest> tryMapRequest(
            String leftOperandString,
            String operatorString,
            String rightOperandString);
}

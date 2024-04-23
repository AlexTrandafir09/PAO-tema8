package pao.blsalin.smartercalculator.requestMapper;

import pao.blsalin.smartercalculator.CalculationRequest;

import java.util.Optional;

public class BooleanCalculatorRequestMapper implements CalculatorRequestMapper {
    @Override
    public Optional<CalculationRequest> tryMapRequest(
            String leftOperandString,
            String operatorString,
            String rightOperandString) {
        if (!isStringABoolean(leftOperandString, rightOperandString)
                || !isStringABoolean(rightOperandString, rightOperandString)) {
            return Optional.empty();
        }

        if (!isOperationValid(operatorString)) {
            return Optional.empty();
        }

        return Optional.of(
                new CalculationRequest(leftOperandString, rightOperandString, operatorString)
        );
    }

    private static boolean isStringABoolean(String stringToVerify, String rightOperandString) {
        return "true".equals(stringToVerify) || "false".equals(rightOperandString);
    }

    private static boolean isOperationValid(String operationString) {
        return "&&".equals(operationString) || "||".equals(operationString);
    }
}

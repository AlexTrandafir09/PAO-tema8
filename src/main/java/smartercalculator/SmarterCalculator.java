package pao.blsalin.smartercalculator;

import pao.blsalin.smartercalculator.calculatorResult.BooleanCalculationResult;
import pao.blsalin.smartercalculator.calculatorResult.AbstractCalculationResult;
import pao.blsalin.smartercalculator.calculatorResult.CalculationResult;
import pao.blsalin.smartercalculator.calculatorResult.DoubleCalculationResult;
import pao.blsalin.smartercalculator.calculatorResult.IntegerCalculationResult;

import java.util.List;
import java.util.stream.Collectors;

public class SmarterCalculator {

    public static List<CalculationResult> calculate(String[] args) {
        return InputConverter.mapRequests(args)
                .stream()
                .map(SmarterCalculator::createCalculatorResponse)
                .collect(Collectors.toList());
    }

    private static CalculationResult createCalculatorResponse(CalculationRequest request) {
        return switch (request.getRequestType()) {
            case Boolean -> new BooleanCalculationResult(request);
            case Integer -> new IntegerCalculationResult(request);
            case Double -> new DoubleCalculationResult(request);
            default -> throw new IllegalArgumentException();
        };
    }
}

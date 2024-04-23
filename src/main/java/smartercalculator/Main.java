package pao.blsalin.smartercalculator;

import pao.blsalin.smartercalculator.calculatorResult.AbstractCalculationResult;
import pao.blsalin.smartercalculator.calculatorResult.CalculationResult;
import pao.blsalin.smartercalculator.calculatorResult.PrintingCalculationResult;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        args = new String[]{
                "1", "+", "2",
                "2", "*", "5",
                "1", "+", "5.0",
                "1.0", "-", "2",
                "10.0", "/", "1",
        };

        runSmarterCalculator(args);
    }

    private static void runSmarterCalculator(String[] args) {
        SmarterCalculator
                .calculate(args)
                .stream()
                .map(PrintingCalculationResult::new)
                .forEach(PrintingCalculationResult::computeResult);
    }
}

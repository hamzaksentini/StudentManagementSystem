package edu.sesame.bank.entity;

import lombok.AllArgsConstructor;

import java.util.function.BiFunction;

@AllArgsConstructor
public enum OperationType {
    WITHDRAW((aDouble, aDouble2) -> aDouble - aDouble2),
    DEPOSIT((Double::sum));

    private final BiFunction<Double, Double, Double> operationFunction;

    public Double apply(Double adouble, Double adouble2) {
        return operationFunction.apply(adouble, adouble2);
    }

}

package com.github.qwelyt.neural;

import java.util.function.BiFunction;
import java.util.function.Function;

import com.github.qwelyt.util.Functions;

public final class ActivationFunctions {
    public static final BiFunction<Double, Double, Double> SIGMOID = (a,x) -> 1.0 / (1.0 + Math.exp(-a * x) );
    public static final BiFunction<Double, Double, Double> LINEAR = (a,x) -> a*x;
    
    // Curried with defaults
    public static final Function<Double, Double> SIGMOID_1 = Functions.curry(SIGMOID, 1.0);
    public static final Function<Double, Double> LINEAR_1 = Functions.curry(LINEAR, 1.0);
}
package com.github.qwelyt.neural.layer;

import java.util.function.Function;

public final class InputLayer extends NeuralLayer{
    public InputLayer(final int numberOfNeurons, Function<Double, Double> activationFunction){
        super(numberOfNeurons, activationFunction);
    }
}
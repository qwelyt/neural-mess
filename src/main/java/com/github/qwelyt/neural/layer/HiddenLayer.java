package com.github.qwelyt.neural.layer;

import java.util.function.Function;

public final class HiddenLayer extends NeuralLayer{
    HiddenLayer(final int numberOfNeurons, Function<Double, Double> activationFunction){
        super(numberOfNeurons, activationFunction);
    }
}
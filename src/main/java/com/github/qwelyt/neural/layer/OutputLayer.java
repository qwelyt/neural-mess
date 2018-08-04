package com.github.qwelyt.neural.layer;

import java.util.function.Function;

final class OutputLayer extends NeuralLayer{
    public OutputLayer(final int numberOfNeurons, Function<Double, Double> activationFunction){
        super(numberOfNeurons, activationFunction);
    }
}
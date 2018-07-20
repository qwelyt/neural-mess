package com.github.qwelyt.neural.layer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public abstract class NeuralLayer {
    private final List<Neuron> neurons;

    NeuralLayer(final int numberOfNeurons, Function<Double, Double> activationFunction){
        this.neurons = new ArrayList<>(numberOfNeurons);
        for(int i=0; i<numberOfNeurons; ++i){
            this.neurons.add(new Neuron());
        }
    }
}
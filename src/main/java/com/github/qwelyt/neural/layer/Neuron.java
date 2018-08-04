package com.github.qwelyt.neural.layer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

final class Neuron{
    private final Function<Double, Double> activationFunction;
    private List<Double> weight = new ArrayList<>();
    private double bias = 1.0;


    Neuron(Function<Double, Double> activationFunction) {
        this.activationFunction = activationFunction;
	}

	Double calc(final List<Double> input){
        Double outputBeforeActivation = 0.0;
        for(int i=0; i < input.size(); ++i){
            // Need to fix bias and weight
            outputBeforeActivation += (i == input.size() ? bias : input.get(i)*weight(i));
        }
        return activationFunction.apply(outputBeforeActivation);
    }

    private double weight(final int i){
        try{
            return weight.get(i);
        } catch(IndexOutOfBoundsException ioobe){
            weight.add(new Random().nextDouble()); // Just to get some diff
            return weight.get(i);
        }
    }
}
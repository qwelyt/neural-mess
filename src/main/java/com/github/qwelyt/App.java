package com.github.qwelyt;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.github.qwelyt.neural.ActivationFunctions;
import com.github.qwelyt.neural.NeuralNet;
import com.github.qwelyt.util.Functions;

public class App {
    public static void main(String[] args) {
        System.out.println("Start the neural network");
        final NeuralNet net = new NeuralNet.Builder()
                     .inputs(2)
                     .hiddenLayers(3)
                     .hiddenActivationFunctions(Arrays.asList(ActivationFunctions.SIGMOID_1, ActivationFunctions.SIGMOID_1, ActivationFunctions.SIGMOID_1))
                     .outputs(1)
                     .outputActivationFunction(ActivationFunctions.LINEAR_1)
                     .build();

        {
            List<Double> inputs = Arrays.asList(1.5, 0.5);
            System.out.println("Feeding: "+inputs.get(0)+" and "+inputs.get(1));
            List<Double> calc = net.calc(inputs);
            System.out.println("Output: " + calc.stream().map(d -> String.valueOf(d)).collect(Collectors.joining(", ", "", "")));
        }
        {
            List<Double> inputs = Arrays.asList(1.0, 2.1);
            System.out.println("Feeding: "+inputs.get(0)+" and "+inputs.get(1));
            List<Double> calc = net.calc(inputs);
            System.out.println("Output: " + calc.stream().map(d -> String.valueOf(d)).collect(Collectors.joining(", ", "", "")));
        }
    }
}

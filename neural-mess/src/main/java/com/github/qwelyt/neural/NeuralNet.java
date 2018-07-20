package com.github.qwelyt.neural;

import java.util.function.Function;

public final class NeuralNet {

    private NeuralNet(
        final int numberOfInputs
        , final int numberOfOutputs
        , final int[] numberOfHiddenNeurons
        , final Function<Double, Double> hiddenActivationFunction
        , final Function<Double, Double> outputActivationFunction
    ) {

    }

    public static final class Builder {
        private int numberOfInputs = 1;
        private int numberOfOutputs = 1;
        private int[] numberOfHiddenNeurons = {};
        private Function<Double, Double> hiddenActivationFunction = ActivationFunctions.SIGMOID_1;
        private Function<Double, Double> outputActivationFunction = ActivationFunctions.LINEAR_1;

        public Builder inputs(final int numberOfInputs){
            this.numberOfInputs = numberOfInputs;
            return this;
        }

        public Builder outputs(final int numberOfOutputs){
            this.numberOfOutputs = numberOfOutputs;
            return this;
        }

        public Builder hiddenNeurons(final int[] numberOfHiddenNeurons){
            this.numberOfHiddenNeurons = numberOfHiddenNeurons;
            return this;
        }

        public Builder hiddenActivationFunction(final Function<Double, Double> hiddenActivationFunction){
            this.hiddenActivationFunction = hiddenActivationFunction;
            return this;
        }

        public Builder outputActivationFunction(final Function<Double, Double> outputActivationFunction){
            this.outputActivationFunction = outputActivationFunction;
            return this;
        }

        public NeuralNet build(){
            return new NeuralNet(
                numberOfInputs
                , numberOfOutputs
                , numberOfHiddenNeurons
                , hiddenActivationFunction
                , outputActivationFunction
            );
        }
    }
    // Make builder
}

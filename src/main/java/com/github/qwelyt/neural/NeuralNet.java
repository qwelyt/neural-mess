package com.github.qwelyt.neural;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.github.qwelyt.neural.layer.HiddenLayer;
import com.github.qwelyt.neural.layer.InputLayer;
import com.github.qwelyt.neural.layer.OutputLayer;

public final class NeuralNet {

    private final List<HiddenLayer> hiddenLayers;
    private final InputLayer inputLayer;
    private final OutputLayer outputLayer;
    private final int numberOfInputs;
	private final int numberOfOutputs;
    private final int numberOfHiddenLayers;

	private NeuralNet(
        final int numberOfInputs
        , final int numberOfOutputs
        , final List<Integer> neuronsInLayer
        , final List<Function<Double, Double>> hiddenActivationFunctions
        , final Function<Double, Double> outputActivationFunction
    ) {
        this.numberOfInputs = numberOfInputs;
        this.numberOfOutputs = numberOfOutputs;
        this.numberOfHiddenLayers = neuronsInLayer.size();

        this.hiddenLayers = new ArrayList<>();
        this.inputLayer = new InputLayer(numberOfInputs, ActivationFunctions.LINEAR_1);
        this.outputLayer = new OutputLayer(numberOfOutputs, outputActivationFunction);
    }

    public static final class Builder {
        private int numberOfInputs = 1;
        private int numberOfOutputs = 1;
        private int numberOfHiddenLayers = 0;
        private List<Integer> neuronsInLayer = new ArrayList<>();
        private List<Function<Double, Double>> hiddenActivationFunctions = new ArrayList<>();
        private Function<Double, Double> outputActivationFunction = ActivationFunctions.LINEAR_1;

        public Builder inputs(final int numberOfInputs){
            this.numberOfInputs = numberOfInputs;
            return this;
        }

        public Builder outputs(final int numberOfOutputs){
            this.numberOfOutputs = numberOfOutputs;
            return this;
        }

        public Builder hiddenLayers(final int numberOfHiddenLayers){
            this.numberOfHiddenLayers = numberOfHiddenLayers;
            resizeHiddenActivationFunctions(numberOfHiddenLayers);
            resizeNeuronsInLayer(numberOfHiddenLayers);
            return this;
        }

        public Builder neuronsInLayer(final int layer, final int neurons){
            if(layer > numberOfHiddenLayers){
                throw new RuntimeException("Can't assign neurons to a layer that does not exist!");
            }
            this.neuronsInLayer.set(layer, neurons);
            return this;
        }
        
		public Builder hiddenActivationFunctions(final Function<Double, Double> hiddenActivationFunctions){
            this.hiddenActivationFunctions.add(hiddenActivationFunctions);
            return this;
        }
        
        public Builder hiddenActivationFunctions(final int forLayer,final Function<Double, Double> hiddenActivationFunctions ){
            this.hiddenActivationFunctions.set(forLayer, hiddenActivationFunctions);
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
                , neuronsInLayer
                , hiddenActivationFunctions
                , outputActivationFunction
            );
        }

        private void resizeHiddenActivationFunctions(int numberOfHiddenLayers) {
            List<Function<Double, Double>> list = new ArrayList<>(numberOfHiddenLayers);
            for(int i=0; i<list.size(); ++i){
                if(hiddenActivationFunctions.size() >= i){
                    list.add(i, hiddenActivationFunctions.get(i));
                } else {
                    list.add(i, ActivationFunctions.LINEAR_1);
                }
            }
            this.hiddenActivationFunctions = list;
        }

        private void resizeNeuronsInLayer(int numberOfHiddenLayers) {
            List<Integer> list = new ArrayList<>(numberOfHiddenLayers);
            for(int i=0; i<list.size(); ++i){
                if(neuronsInLayer.size() >= i){
                    list.add(i, neuronsInLayer.get(i));
                } else {
                    list.add(i, 1);
                }
            }
            this.neuronsInLayer = list;
        }
    }

}
    
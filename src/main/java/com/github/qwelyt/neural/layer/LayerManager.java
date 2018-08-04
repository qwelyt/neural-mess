package com.github.qwelyt.neural.layer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.github.qwelyt.neural.ActivationFunctions;
import com.github.qwelyt.util.Collections;

public final class LayerManager {
    private final InputLayer inputLayer;
    private final List<HiddenLayer> hiddenLayers;
    private final OutputLayer outputLayer;

    public LayerManager(
        final int numberOfInputs
        , final List<Integer> neuronsInLayer
        , final List<Function<Double, Double>> hiddenActivationFunctions
        , final int numberOfOutputs
        , final Function<Double, Double> outputActivationFunction
    ){
        this.hiddenLayers = new ArrayList<>(neuronsInLayer.size());
        for(int i=0; i<hiddenLayers.size(); ++i){
            hiddenLayers.set(i, new HiddenLayer(neuronsInLayer.get(i), hiddenActivationFunctions.get(i)));
        }
        this.inputLayer = new InputLayer(numberOfInputs, ActivationFunctions.LINEAR_1);
        this.outputLayer = new OutputLayer(numberOfOutputs, outputActivationFunction);
    }

    public List<Double> calc(final List<Double> input){
        List<Double> inputForNextLayer = inputLayer.calc(Collections.copy(input));
        for(int i=0; i<hiddenLayers.size(); ++i){
            inputForNextLayer =  hiddenLayers.get(i).calc(inputForNextLayer);
        }
        return Collections.copy(outputLayer.calc(inputForNextLayer));
    }
}
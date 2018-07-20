package com.github.qwelyt.util;

import java.util.function.BiFunction;
import java.util.function.Function;

public final class Functions {
    public static <A,B,C> Function<A, Function<B,C>> curry(BiFunction<A,B,C> biFunc){
        return a -> b -> biFunc.apply(a, b);
    }

    public static <A,B,C> Function<B,C> curry(BiFunction<A,B,C> biFunc, A a){
        return curry(biFunc).apply(a);
    }
}
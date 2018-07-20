package com.github.qwelyt.util;

import java.util.ArrayList;
import java.util.List;

public final class Collections{

    public static <A> List<A> copy(final List<A> list){
        final List<A> copy = new ArrayList<>();
        copy.addAll(list);
        return copy;
    }
}
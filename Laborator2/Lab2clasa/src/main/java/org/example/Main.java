package org.example;

import org.apache.commons.lang3.tuple.Pair;

public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> pair = Pair.of("example", 42);
        int count = countObjectsInTuple(pair);
        System.out.println("Number of objects in tuple: " + count);
    }

    public static int countObjectsInTuple(Pair<?, ?> pair) {
        return 2; // Since Pair always contains exactly two elements
    }
}
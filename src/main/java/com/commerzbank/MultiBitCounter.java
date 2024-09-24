package com.commerzbank;

import java.util.stream.IntStream;

public class MultiBitCounter {
    private final BitCounter[] counterArray;

    public MultiBitCounter(int counters) {
        counterArray = IntStream.range(0, counters)
                .mapToObj(it -> new BitCounter())
                .toArray(BitCounter[]::new);
    }

    public void calculate(boolean clock) {
        counterArray[0].calculate(clock);
        for (int i = 1; i < counterArray.length; i++) {
            counterArray[i].calculate(counterArray[i - 1].getQ());
        }
    }

    public int value() {
        return IntStream.range(0, counterArray.length)
                .map(i -> pow(counterArray[i].getQ(), i))
                .sum();
    }

    private int pow(boolean bit, int nth) {
        return (bit ? 1 : 0) << nth;
    }
}

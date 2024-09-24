package com.commerzbank;

public class BitCounter {
    private final FlipFlop flipFlop = new FlipFlop();

    public void calculate(boolean clock) {
        flipFlop.calculate(clock, flipFlop.getNQ());
    }

    public boolean getQ() {
        return flipFlop.getQ();
    }
}

package com.commerzbank;

import static com.commerzbank.Functions.NOT;

public class FlipFlop {
    GatedDLatch entry = new GatedDLatch();
    GatedDLatch exit = new GatedDLatch();

    public void calculate(boolean clock, boolean D) {
        calculateOnce(clock, D);
        calculateOnce(clock, D);
    }

    private void calculateOnce(boolean clock, boolean D) {
        entry.calculate(clock, D);
        exit.calculate(NOT(clock), entry.getQ());
    }

    public boolean getQ() {
        return exit.getQ();
    }

    public boolean getNQ() {
        return exit.getNQ();
    }
}

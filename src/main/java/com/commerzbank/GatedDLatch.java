package com.commerzbank;

public class GatedDLatch {
    private boolean Q = false;
    private boolean NQ = true;

    public void calculate(boolean E, boolean D) {
        boolean topLeft = Functions.NAND(D, E);
        boolean bottomLeft = Functions.NAND(topLeft, E);
        Q = Functions.NAND(topLeft, NQ);
        NQ = Functions.NAND(bottomLeft,Q);
    }

    public boolean getQ() {
        return Q;
    }

    public boolean getNQ() {
        return NQ;
    }
}

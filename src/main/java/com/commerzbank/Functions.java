package com.commerzbank;

public class Functions {

    static boolean NAND(boolean A, boolean B) {
        return !(A && B);
    }

    private static boolean NOT(boolean A) {
        return NAND(A, A);
    }

    static boolean AND(boolean A, boolean B) {
        return NOT(NAND(A, B));
    }

    static boolean OR(boolean A, boolean B) {
        return NAND(NOT(A), NOT(B));
    }

    static boolean NOR(boolean A, boolean B) {
        return NOT(OR(A, B));
    }


    static boolean XOR(boolean A, boolean B) {
        boolean C = NAND(A, B);
        return NAND(NAND(A, C), NAND(C, B));
    }
}

package com.commerzbank


import spock.lang.Specification

class FunctionsTest extends Specification {
    def "NAND logic"(boolean A, boolean B, boolean Q) {
        expect:
        Functions.NAND(A, B) == Q

        where:
        A | B | Q
        0 | 0 | 1
        0 | 1 | 1
        1 | 0 | 1
        1 | 1 | 0
    }
}

package com.commerzbank


import spock.lang.Specification

class FunctionsTest extends Specification {
    def "NAND gate"(boolean A, boolean B, boolean Q) {
        expect:
        Functions.NAND(A, B) == Q

        where:
        A | B | Q
        0 | 0 | 1
        0 | 1 | 1
        1 | 0 | 1
        1 | 1 | 0
    }

    @SuppressWarnings('GroovyAccessibility')
    def "NOT gate"(boolean A, boolean Q) {
        expect:
        Functions.NOT(A) == Q
        where:
        A | Q
        0 | 1
        1 | 0
    }

    def "NOR gate"(boolean A, boolean B, boolean Q) {
        expect:
        Functions.NOR(A, B) == Q

        where:
        A | B | Q
        0 | 0 | 1
        0 | 1 | 0
        1 | 0 | 0
        1 | 1 | 0
    }

    def "AND gate"(boolean A, boolean B, boolean Q) {
        expect:
        Functions.AND(A, B) == Q

        where:
        A | B | Q
        0 | 0 | 0
        0 | 1 | 0
        1 | 0 | 0
        1 | 1 | 1
    }

    def "OR gate"(boolean A, boolean B, boolean Q) {
        expect:
        Functions.OR(A, B) == Q

        where:
        A | B | Q
        0 | 0 | 0
        0 | 1 | 1
        1 | 0 | 1
        1 | 1 | 1
    }

    def "XOR gate"(boolean A, boolean B, boolean Q) {
        expect:
        Functions.XOR(A, B) == Q

        where:
        A | B | Q
        0 | 0 | 0
        0 | 1 | 1
        1 | 0 | 1
        1 | 1 | 0
    }
}

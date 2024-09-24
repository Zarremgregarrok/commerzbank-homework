package com.commerzbank

import spock.lang.Specification

class GatedDLatchTest extends Specification {
    def 'E true'(boolean E, boolean D, boolean Q, boolean NQ) {
        given:
        def latch = new GatedDLatch()
        latch.calculate(E, D)

        expect:
        latch.getQ() == Q
        latch.getNQ() == NQ

        where:
        E | D | Q | NQ
        1 | 0 | 0 | 1
        1 | 1 | 1 | 0
    }

    def 'E false'(boolean E1, boolean D1, boolean E2, boolean D2, boolean Q, boolean NQ) {
        given:
        def latch = new GatedDLatch()
        latch.calculate(E1, D1)
        boolean Q_1 = latch.getQ()
        boolean NQ1 = latch.getNQ()
        latch.calculate(E2, D2)

        expect:
        Q_1 == Q
        NQ1 == NQ
        latch.getQ() == Q
        latch.getNQ() == NQ

        where:
        E1 | D1 | E2 | D2 | Q | NQ
        1  | 0  | 0  | 0  | 0 | 1
        1  | 0  | 0  | 1  | 0 | 1
        1  | 1  | 0  | 0  | 1 | 0
        1  | 1  | 0  | 1  | 1 | 0
    }
}

package com.commerzbank

import spock.lang.Specification

class FlipFlopTest extends Specification {
    def 'FlipFlop falling edge storage test'(boolean E1, boolean D1, boolean E2, boolean D2, boolean E3, boolean D3, boolean Q) {
        given:
        def flipFlop = new FlipFlop()
        flipFlop.calculate(E1, D1)
        flipFlop.calculate(E2, D2)
        boolean Q_2 = flipFlop.getQ()
        flipFlop.calculate(E3, D3)

        expect:
        Q_2 == Q
        flipFlop.getQ() == Q

        where:
        E1 | D1 | E2 | D2 | E3 | D3 | Q
        1  | 0  | 0  | 0  | 0  | 0  | 0
        1  | 0  | 0  | 0  | 0  | 1  | 0
        1  | 0  | 0  | 0  | 1  | 0  | 0
        1  | 0  | 0  | 0  | 1  | 1  | 0
        1  | 1  | 0  | 1  | 0  | 0  | 1
        1  | 1  | 0  | 1  | 0  | 1  | 1
        1  | 1  | 0  | 1  | 1  | 0  | 1
        1  | 1  | 0  | 1  | 1  | 1  | 1
    }
}

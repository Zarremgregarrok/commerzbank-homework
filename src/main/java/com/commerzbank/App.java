package com.commerzbank;

/**
 * 4 Bit counter
 */
public class App {
    public static void main(String[] args) {
        MultiBitCounter counter = new MultiBitCounter(4);
        int counterValue = 0;
        do {
            System.out.println(counterValue);
            counter.calculate(true);
            counter.calculate(false);
            counterValue = counter.value();
        } while (counterValue != 0);
    }
}
